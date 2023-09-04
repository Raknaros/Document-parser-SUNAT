from classes import ExtractContent, Comprobantes

class Dog():
    species="canis familairis"
    def __init__(self,arg1,arg2):
        pass
        self.name=arg1
        self.age=arg2
    def __str__(self):
        return f"{self.name} is {self.age} years old"

    def metodo2(self,sound):
        return f"{self.name} says {sound}"

class Puddle(Dog):
    pass

class ShiIztu(Dog):
    pass

class Labrador(Dog):
    pass



testextract = ExtractContent.Extract()
extraer=Comprobantes.Facturas('/home/raknaros/code/Parser-SUNAT/xmls/','latin_1')

#print(testextract.Xml('/home/raknaros/code/Parser-SUNAT/xmls/','latin_1').keys())
print(extraer.facturas())