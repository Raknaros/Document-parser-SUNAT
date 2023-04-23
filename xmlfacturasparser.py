from bs4 import BeautifulSoup as bs
import pandas as pd
import zipfile
import os, shutil
import psycopg2

connection=psycopg2.connect(user="admindb",password="72656770",host="impulsadb.cwtkokblelkx.us-west-1.rds.amazonaws.com",port="5432",database="impulsadb")
cursor=connection.cursor()
cursor.execute("SELECT entity_id, numero_documento FROM acc.entities;")
entities={}
columnas=["descripcion","cantidad","unidad_medida","precio_unitario","precio_unitario_incigv","precio_total","igv_total","tasa_igv","fecha_emision","serie_comprobante","numero_correlativo","entity_id","tipo_documento","numero_documento","valor","igv","tipo_moneda","forma_pago"]
for row in cursor.fetchall():
    entities[row[1]]=row[0]
xmlfiles=os.listdir('D:\\xmltest')
carpetas=os.listdir('D:\\Onedrive')
dfImport=pd.DataFrame(columns=columnas)
for a in xmlfiles:
    destino=[string for string in carpetas if "20548030529" in string]
    with zipfile.ZipFile('D:\\xmltest\\' + a, mode="r") as archive:
        file=archive.read((archive.namelist())[0]).decode(encoding="latin_1")
        content="".join(file)
        bs_content=bs(content,'xml')
        if "FACTURA" in a:
            facturas=[]
            facturas.append(bs_content.find("cbc:IssueDate").text) #Fecha de emision
            facturas.append((bs_content.find("cbc:ID").text.split("-"))[0]) #Serie del comprobante
            facturas.append((bs_content.find("cbc:ID").text.split("-"))[1]) #Numero del comprobante
            infoProveedor=bs_content.find("cac:AccountingSupplierParty") #Informacion de emisor/proveedor
            infoCliente=bs_content.find("cac:AccountingCustomerParty") # Informacion de remitente/cliente
            facturas.append(entities[a[-15:-4]]) #ID de entidad
            if infoProveedor.find("cbc:ID").text == a[-15:-4]:
                if infoCliente.find("cbc:ID").get("schemeID")=="-":
                    facturas.append("0")
                    facturas.append(infoCliente.find("cbc:RegistrationName").text)
                else:
                    facturas.append(infoCliente.find("cbc:ID").get("schemeID")) #tipo de documento remitente/cliente
                    facturas.append(infoCliente.find("cbc:ID").text) #numero de documento remitente/cliente
            elif infoCliente.find("cbc:ID").text == a[-15:-4]:
                if infoCliente.find("cbc:ID").get("schemeID")=="-":
                    facturas.append("0")
                    facturas.append(infoProveedor.find("cbc:RegistrationName").text)
                else:
                    facturas.append(infoProveedor.find("cbc:ID").get("schemeID")) #tipo de documento remitente/cliente
                    facturas.append(infoProveedor.find("cbc:ID").text) #numero de documento remitente/cliente
            taxInfo=bs_content.find("cac:TaxTotal") #Informacion de impuestos
            facturas.append(taxInfo.find("cbc:TaxableAmount").text) #subtotal
            facturas.append(taxInfo.find("cbc:TaxAmount").text) #igv total
            facturas.append(taxInfo.find("cbc:TaxAmount").get("currencyID")) #tipo de moneda
            #totalInfo = bs_content.find("cac:LegalMonetaryTotal")
            documentoReferencia=bs_content.find("cac:DespatchDocumentReference") #Informacion de documentos de referencia
            try:
                tipoReferencia=documentoReferencia.find("cbc:DocumentTypeCode").text #tipo de documento de referencia
                serieReferencia=(documentoReferencia.find("cbc:ID").text.split(" - "))[0] #serie de documento de referencia
                numeroReferencia=(documentoReferencia.find("cbc:ID").text.split(" - "))[1] #numero de documento de referencia
            except: pass
            try: 
                formaPago=bs_content.find_all("cac:PaymentTerms") #Informacion de forma de pago y cuotas
                tipoPago=formaPago[0].find("cbc:PaymentMeansID").text #Forma de pago   
                formaPago.pop(0)
            except:
                tipoPago="Contado"
            finally: facturas.append(tipoPago)
            itemsInfo=bs_content.find_all("cac:InvoiceLine") #Descripcion de la factura
            for item in itemsInfo:
                lista=[]
                lista.append((item.find("cbc:Description").text).replace("Ã¯Â¿Â½","Ñ")) #Descripcion corrigiendo la Ñ
                lista.append(item.find("cbc:InvoicedQuantity").text) #Cantidad
                lista.append(item.find("cbc:InvoicedQuantity").get("unitCode")) #Unidad de medida
                precios=item.find_all("cbc:PriceAmount")
                lista.append(precios[1].text) #Precio unitario sin IGV
                lista.append(precios[0].text) #Precio unitario incluido IGV
                lista.append(item.find("cbc:LineExtensionAmount").text) #Subtotal de articulo
                lista.append(item.find("cbc:TaxAmount").text) #IGV total del articulo
                IGvs=item.find_all("cbc:Percent")
                lista.append(IGvs[1].text) #Porcentaje de IGV
                facturas.append(lista)
            cuoTas=[]
            columnasCuotas=[]
            if tipoPago=="Credito":   
                for pago in formaPago:
                    cuoTas.append(pago.find("cbc:PaymentDueDate").text) #Fecha cuota
                    cuoTas.append(pago.find("cbc:Amount").text) #Importe cuota
                fechaCuota=1
                importeCuota=1
                for i in range(len(cuoTas)): 
                    if (i%2)==0:
                        columnasCuotas.append("fecha_cuota"+str(fechaCuota))
                        fechaCuota+=1
                    else:
                        columnasCuotas.append("importe_cuota"+str(importeCuota))
                        importeCuota+=1
            shutil.move('D:\\xmltest\\' + a,'D:\\Onedrive\\'+destino[0]+'\\XML\\')
            paGos=pd.DataFrame([cuoTas],columns=columnasCuotas)
            #numListas=sum(isinstance(x, list) for x in filas)
            newFila=pd.DataFrame(facturas[10:]).merge(pd.DataFrame(facturas[:10]).T, how='cross').set_axis(columnas, axis=1)
            newFila=newFila.merge(paGos, how='cross')
            dfImport=pd.concat([dfImport,newFila],ignore_index=True)
            #dfImport.to_excel("D:\\parseractual.xlsx")
        elif "NOTA_CREDITO" in a:
            notacredito = []
            refInfo=bs_content.find("cac:DiscrepancyResponse")
            notacredito.append(entities[a[-15:-4]]) #ID de entidad
            notacredito.append(bs_content.find("cbc:IssueDate").text) #Fecha de emision
            notacredito.append((bs_content.find("cbc:ID").text.split("-"))[0]) #Serie del comprobante
            notacredito.append((bs_content.find("cbc:ID").text.split("-"))[1]) #Numero del comprobante
            infoProveedor=bs_content.find("cac:AccountingSupplierParty") #Informacion de emisor/proveedor
            infoCliente=bs_content.find("cac:AccountingCustomerParty") # Informacion de remitente/cliente
            if infoProveedor.find("cbc:ID").text == a[-15:-4]:
                if infoCliente.find("cbc:ID").get("schemeID")=="-":
                    notacredito.append("0")
                    notacredito.append(infoCliente.find("cbc:RegistrationName").text)
                else:
                    notacredito.append(infoCliente.find("cbc:ID").get("schemeID")) #tipo de documento remitente/cliente
                    notacredito.append(infoCliente.find("cbc:ID").text) #numero de documento remitente/cliente
            elif infoCliente.find("cbc:ID").text == a[-15:-4]:
                if infoCliente.find("cbc:ID").get("schemeID")=="-":
                    notacredito.append("0")
                    notacredito.append(infoProveedor.find("cbc:RegistrationName").text)
                else:
                    notacredito.append(infoProveedor.find("cbc:ID").get("schemeID")) #tipo de documento remitente/cliente
                    notacredito.append(infoProveedor.find("cbc:ID").text) #numero de documento remitente/cliente
            notacredito.append((refInfo.find("cbc:ReferenceID").text.split(" - "))[0]) #Serie del comprobante
            notacredito.append((refInfo.find("cbc:ReferenceID").text.split(" - "))[1]) #Numero del comprobante
            amountInfo=bs_content.find("cac:LegalMonetaryTotal")
            taxInfo=bs_content.find("cac:TaxTotal")
            notacredito.append(taxInfo.find("cbc:TaxAmount").get("currencyID"))
            print(notacredito)
            tipo=(refInfo.find("cbc:Description").text.replace("Ã³","ó").replace("Ã­","í"))
            if refInfo.find("cbc:ResponseCode").text=="01":
                nc1=[]
                nc1.append(taxInfo.find("cbc:TaxableAmount").text)
                nc1.append(taxInfo.find("cbc:TaxAmount").text)
                nc1.append("ANULACION")
            elif refInfo.find("cbc:ResponseCode").text=="Anulación por Error en el RUC":
                pass
            elif refInfo.find("cbc:ResponseCode").text=="Descuento Global":
                pass
            elif refInfo.find("cbc:ResponseCode").text=="Devolución Total":
                pass
            elif refInfo.find("cbc:ResponseCode").text=="03":
                pass
            elif refInfo.find("cbc:ResponseCode").text=="Devolución por ítem":
                pass
            elif refInfo.find("cbc:ResponseCode").text=="Descuento por item":
                pass
            elif refInfo.find("cbc:ResponseCode").text=="Otros Conceptos":
                pass
            elif refInfo.find("cbc:ResponseCode").text=="Ajustes - montos y/o fechas de pago":
                pass
        elif "NOTA_DEBITO" in a:
            if "cac:DiscrepancyResponse - cbc:Description"=="Intereses por Mora":
                pass
            elif "cac:DiscrepancyResponse - cbc:Description"=="Aumento en el Valor":
                pass
            elif "cac:DiscrepancyResponse - cbc:Description"=="Penalidad":
                pass