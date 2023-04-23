import pandas as pd
import os
import shutil
import psycopg2
#ples=pd.DataFrame(columns=([f'column_{i}' for i in range(45)]))
filas=[]
directory = os.listdir('D:\\ples')
connection = psycopg2.connect(user="admindb",password="72656770",host="impulsadb.cwtkokblelkx.us-west-1.rds.amazonaws.com",port="5432",database="impulsadb")
cursor = connection.cursor()


for i in directory:
    cursor.execute("SELECT entity_id FROM acc.entities WHERE numero_documento = '"+i[2:13]+"';")
    entity_id=(cursor.fetchone())[0]
    print(i)
    try:
        with open("D:\\ples\\"+i,encoding="utf8") as f:
            for line in f.readlines(): 
                splitted = line.split("|")
    except:  
        with open("D:\\ples\\"+i) as f:
            for line in f.readlines(): 
                splitted = line.split("|")
    finally:
            columnas=splitted[:3]
            columnas.append(i[21:25])
            columnas.append(entity_id)
            filas.append(columnas)
ples=pd.DataFrame(filas)#.set_axis([f'column_{i}' for i in range(45)], axis=1)
#ples=ples[ples.column_41 != '9']
#ples=ples[['column_0','column_1','column_2','column_43','column_44']]
#ples['column_44']=ples['column_44'].astype(dtype='int')
#ples.rename(columns={"column_0": "periodo_tributario", "column_1": "cuo", "column_2": "correlativo_asiento_contable","column_43": "codigo_ple","column_44": "entity_id"},inplace=True)
ples.to_excel("D:\\pless.xlsx")

#cursor.close()
#connection.close()