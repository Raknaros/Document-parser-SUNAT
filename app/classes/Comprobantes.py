from classes import ExtractContent
from bs4 import BeautifulSoup as bs
import pandas as pd
import zipfile
import os, shutil
import psycopg2

class Facturas(ExtractContent.Extract):
    def __init__(self,ruta,encode):
        self.bsdict=super().Xml(ruta,encode)

    def facturas(self):
        columnas=["descripcion","cantidad","unidad_medida","precio_unitario","precio_unitario_incigv","precio_total","igv_total","tasa_igv","fecha_emision","serie_comprobante","numero_correlativo","entity_id","tipo_documento","numero_documento","valor","igv","tipo_moneda","forma_pago"]
        dfImport=pd.DataFrame(columns=columnas)
        for a in self.bsdict.keys():
            if "FACTURA" in a:
                facturas=[]
                facturas.append(self.bsdict[a].find("cbc:IssueDate").text) #Fecha de emision
                facturas.append((self.bsdict[a].find("cbc:ID").text.split("-"))[0]) #Serie del comprobante
                facturas.append((self.bsdict[a].find("cbc:ID").text.split("-"))[1]) #Numero del comprobante
                infoProveedor=self.bsdict[a].find("cac:AccountingSupplierParty") #Informacion de emisor/proveedor
                infoCliente=self.bsdict[a].find("cac:AccountingCustomerParty") # Informacion de remitente/cliente
                facturas.append(a[-15:-4]) #ID de entidad
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
                taxInfo=self.bsdict[a].find("cac:TaxTotal") #Informacion de impuestos
                facturas.append(taxInfo.find("cbc:TaxableAmount").text) #subtotal
                facturas.append(taxInfo.find("cbc:TaxAmount").text) #igv total
                facturas.append(taxInfo.find("cbc:TaxAmount").get("currencyID")) #tipo de moneda
                #totalInfo = bs_content.find("cac:LegalMonetaryTotal")
                documentoReferencia=self.bsdict[a].find("cac:DespatchDocumentReference") #Informacion de documentos de referencia
                try:
                    tipoReferencia=documentoReferencia.find("cbc:DocumentTypeCode").text #tipo de documento de referencia
                    serieReferencia=(documentoReferencia.find("cbc:ID").text.split(" - "))[0] #serie de documento de referencia
                    numeroReferencia=(documentoReferencia.find("cbc:ID").text.split(" - "))[1] #numero de documento de referencia
                except: pass
                try: 
                    formaPago=self.bsdict[a].find_all("cac:PaymentTerms") #Informacion de forma de pago y cuotas
                    tipoPago=formaPago[0].find("cbc:PaymentMeansID").text #Forma de pago   
                    formaPago.pop(0)
                except:
                    tipoPago="Contado"
                finally: facturas.append(tipoPago)
                itemsInfo=self.bsdict[a].find_all("cac:InvoiceLine") #Descripcion de la factura
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
                    lista.append(IGvs[0].text) #Porcentaje de IGV
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
                #shutil.move('D:\\xmltest\\' + a,'D:\\Onedrive\\'+destino[0]+'\\XML\\')
                print(a)
                paGos=pd.DataFrame([cuoTas],columns=columnasCuotas)
                #numListas=sum(isinstance(x, list) for x in filas)
                newFila=pd.DataFrame(facturas[10:]).merge(pd.DataFrame(facturas[:10]).T, how='cross').set_axis(columnas, axis=1)
                newFila=newFila.merge(paGos, how='cross')
                dfImport=pd.concat([dfImport,newFila],ignore_index=True)
                dfImport.to_excel("/home/raknaros/xmls/parseractual.xlsx")