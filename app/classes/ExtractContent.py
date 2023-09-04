from bs4 import BeautifulSoup as bs
import zipfile
import os

class Extract():

    def __init__(self):
        pass

    def Xml(self,ruta:str,encode:str):
        bs_content={}
        xmlfiles=os.listdir(ruta)
        #carpetas=os.listdir('D:\\Onedrive')
        for a in xmlfiles:
            #destino=[string for string in carpetas if "20548030529" in string]
            with zipfile.ZipFile(ruta + a, mode="r") as archive:
                file=archive.read((archive.namelist())[0]).decode(encoding=encode)
                content="".join(file)
                bs_content[a]=bs(content,'xml')
        return bs_content

    def Csv(self,ruta:str,encode:str):
        pass

    