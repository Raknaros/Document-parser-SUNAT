from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import datetime as dt
from dateutil.relativedelta import relativedelta
import psycopg2
from time import sleep
periodoactual=[(dt.date.today()-relativedelta(months=1,day=1)).strftime("%d/%m/%Y"),(dt.date.today()-relativedelta(months=1,day=31)).strftime("%d/%m/%Y")]
connection = psycopg2.connect(user="admindb",password="72656770",host="impulsadb.cwtkokblelkx.us-west-1.rds.amazonaws.com",port="5432",database="impulsadb")
cursor = connection.cursor()
cursor.execute("SELECT numero_documento, usuario_sol, clave_sol FROM acc.entities WHERE clave_sol IS NOT null;")
claves=[]
for i in cursor.fetchall():
    claves.append([i[0],i[1],i[2]])
cursor.close()
connection.close()
categories_1 = ['FE Emitidas', 'FE Recibidas', 'FE Anuladas', 'NC Recibidas', 'NC Emitidas', 'ND Recibidas', 'ND Emitidas'] #Lista de tipos de consulta
path = 'D:\\chromedriver'
options = webdriver.ChromeOptions()
options.add_experimental_option("detach", True) 
options.add_experimental_option('excludeSwitches', ['enable-logging'])
driver = webdriver.Chrome(options=options)
driver.get('https://www.sunat.gob.pe/sol.html')
driver.maximize_window()
sleep(5)
main_page = driver.current_window_handle
WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH,'/html/body/section[1]/div/div/section[2]/div[2]/div/a')))
for i in claves:
    driver.find_element(By.XPATH,'/html/body/section[1]/div/div/section[2]/div[2]/div/a').click() #Tramites y consultas
    for handle in driver.window_handles:
        if handle != main_page:
            login_page = handle
    driver.switch_to.window(login_page) #Cambiar de ventana
    driver.maximize_window()
    WebDriverWait(driver, 20).until(EC.presence_of_element_located((By.XPATH,'//*[@id ="txtRuc"]')))
    driver.find_element(By.XPATH,'//*[@id ="txtRuc"]').send_keys(i[0]) #Cuadro input RUC
    driver.find_element(By.XPATH,'//*[@id ="txtUsuario"]').send_keys(i[1]) #Cuadro input nombre o razon
    driver.find_element(By.XPATH,'//*[@id ="txtContrasena"]').send_keys(i[2]) #Cuadro input clave
    driver.find_element(By.XPATH, '//*[@id ="btnAceptar"]').click() #Aceptar login
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH, '//*[@id ="divOpcionServicio2"]')))
    driver.find_element(By.XPATH, '//*[@id ="divOpcionServicio2"]').click() #Opcion Empresas
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id ="nivel1_11"]')))
    driver.find_element(By.XPATH,'//*[@id ="nivel1_11"]').click() # Comprobantes de pago
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id ="nivel2_11_5"]')))
    driver.find_element(By.XPATH,'//*[@id ="nivel2_11_5"]').click() #Sistema de emision electronica (SEE-SOL)
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id ="nivel3_11_5_3"]')))
    driver.find_element(By.XPATH,'//*[@id ="nivel3_11_5_3"]').click() # Factura electronica
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id ="nivel4_11_5_3_1_2"]')))
    driver.find_element(By.XPATH,'//*[@id ="nivel4_11_5_3_1_2"]').click() # Consultar factura y nota
    WebDriverWait(driver,60).until(EC.frame_to_be_available_and_switch_to_it(('iframeApplication'))) #Cambiar a iframe consulta de facturas
    for z in categories_1:
        WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.XPATH,'/html/body/div[1]/table/tbody/tr/td/div/div/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[1]/td[3]/div/div[2]/input')))
        driver.find_element(By.XPATH,'/html/body/div[1]/table/tbody/tr/td/div/div/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[1]/td[3]/div/div[2]/input').send_keys(periodoactual[0]) #Rellenar fecha inicio
        driver.find_element(By.XPATH,'/html/body/div[1]/table/tbody/tr/td/div/div/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[3]/div/div[2]/input').send_keys(periodoactual[1]) #Rellenar fecha final
        driver.find_element(By.XPATH,'/html/body/div[1]/table/tbody/tr/td/div/div/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[3]/td[3]/div/div[3]/input[1]').clear() #Limpiar campo de tipo de consulta
        driver.find_element(By.XPATH,'/html/body/div[1]/table/tbody/tr/td/div/div/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[3]/td[3]/div/div[3]/input[1]').send_keys('FE Recibidas') #Llenar con tipo de consultas
        driver.find_element(By.XPATH,'/html/body/div[1]/table/tbody/tr/td/div/div/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[1]/td[1]/span/span/span/span[3]').click() #Clickear en buscar comprobantes
        sleep(5)
        driver.switch_to.default_content()
        WebDriverWait(driver,20).until(EC.element_to_be_clickable((By.ID,'iframeApplication')))
        marco= driver.find_element(By.ID,'iframeApplication')
        driver.execute_script('arguments[0].scrollIntoView(true)', marco)
        WebDriverWait(driver,60).until(EC.frame_to_be_available_and_switch_to_it(('iframeApplication')))
        print(len(driver.find_elements(By.LINK_TEXT,'Descargar Factura (XML)')))
        try:
            for i in range(0,len(driver.find_elements(By.LINK_TEXT,'Descargar Factura (XML)'))): #Iterado segun la cantidad de facturas encontradas 
                driver.implicitly_wait(2)
                driver.find_element(By.XPATH,'//a[contains(@onclick,"consultaFactura.descargar(\''+ str(i) +'\')")]').click() #Descargar XML
            driver.find_element(By.XPATH,'/html/body/div[1]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr/td/table[4]/tbody/tr/td[3]/span/span/span/span[3]').click() #Retroceder a ventana de consulta
            driver.implicitly_wait(1)
            sleep(5)
            driver.switch_to.alert.accept() #Aceptar posible alerta
            driver.implicitly_wait(2)
        except:
            driver.switch_to.alert.accept()
        
#/html/body/div[1]/table/tbody/tr/td/div/form/table/tbody/tr/td/table/tbody/tr/td/div/div/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[8]/a