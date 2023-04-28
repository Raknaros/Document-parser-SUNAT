import sqlite3
conn=sqlite3.connect("parserdb")
c=conn.cursor()
c.execute("SELECT entity_id FROM entities WHERE numero_documento='20548030529'")
entitiId=c.fetchone()
conn.close()
print(entitiId)