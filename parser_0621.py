import pandas as pd
import os, shutil
import zipfile
import psycopg2

if os.name=="nt":
    dir='D:\\SUNAT-Parser\\documentosprueba\\'
else:
    dir='/home/raknaros/code/SUNAT-Parser/documentosprueba/'
pdtdir=os.listdir(dir)
for a in pdtdir:
    if "_0621_" in a:
        pdtcsv=pd.read_csv(zipfile.ZipFile(dir+a).open(a[-12:-4]+a[:11]+"pdt621_casillas.csv")).reset_index()
        columnas=list(pdtcsv)
        columnas.append("popable")
        pdtdf=pdtcsv.set_axis([columnas[1:]],axis=1).drop("popable",axis=1)
        print(pdtdf)