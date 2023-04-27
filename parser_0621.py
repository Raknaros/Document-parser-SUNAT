import pandas as pd
import os, shutil
import zipfile
import psycopg2

pdtImport=pd.DataFrame(columns=["entity_id","periodo_tributario","fecha_presentacion","nro_orden","100","101","154","155","102","103","160","161","162","163","106","127","105","109","112","107","108","110","111","113","114","115","116","117","119","120","122","172","169","173","340","341","182","301","312","380","315","140","145","184","171","168","164","179","176","165","681","185","187","188","302","303","304","326","327","305","328","682","317","319","324"])
if os.name=="nt":
    dir='D:\\Parser-SUNAT\\documentosprueba\\'
else:
    dir='/home/raknaros/code/Parser-SUNAT/documentosprueba/'
pdtdir=os.listdir(dir)
for a in pdtdir:
    if "_0621_" in a:
        pdtcsv=pd.read_csv(zipfile.ZipFile(dir+a).open(a[-12:-4]+a[:11]+"pdt621_casillas.csv")).iloc[:,-3:-1].reset_index(drop=True).T #Leer csv dentro de un zip, elegir la antepenultima y penultima columnas, resetear el index descartando el anterior y trasponer.
        pdtcsv.columns=pdtcsv.iloc[0]
        strcolumns=[]
        for column in list(pdtcsv):
            strcolumns.append(str(column))
        pdtcsv=pdtcsv[1:].set_axis(strcolumns,axis="columns").rename(columns={"7":"periodo_tributario","13":"fecha_presentacion","58":"hora"})
        pdtcsv["nro_orden"]=a[a.index("_",12)+1:a.index("_",17)]
        #pdtImport.