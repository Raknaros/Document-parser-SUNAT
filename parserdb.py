import sqlite3
import pandas as pd
from sqlalchemy import create_engine, text
conn=sqlite3.connect("parserdb")
c=conn.cursor()
#c.execute("CREATE TABLE IF NOT EXISTS entities([entity_id] INTEGER UNIQUE,[tipo_documento] INTEGER,[numero_documento] TEXT,[nombre_razon] TEXT)")
#conn.commit()
#conn.close()
#motor=create_engine('postgresql://admindb:72656770@impulsadb.cwtkokblelkx.us-west-1.rds.amazonaws.com/impulsadb')
#entitiesImport=pd.read_sql_query(text("select entity_id,tipo_documento,numero_documento,nombre_razon from acc.entities"),motor)
#entitiesImport.to_sql("entities",con=conn, if_exists='append', index=False)
