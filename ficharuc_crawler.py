from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from time import sleep
from bs4 import BeautifulSoup as bs

claves=['20600416716','ISPONDAT','estudiomar']
path = 'D:\\chromedriver'
options = webdriver.ChromeOptions()
options.add_experimental_option("detach", True) 
options.add_experimental_option('excludeSwitches', ['enable-logging'])
driver = webdriver.Chrome(options=options)
driver.get('https://www.sunat.gob.pe/sol.html')
driver.maximize_window()
main_page = driver.current_window_handle
WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH,'/html/body/section[1]/div/div/section[2]/div[2]/div/a')))
driver.find_element(By.XPATH,'/html/body/section[1]/div/div/section[2]/div[2]/div/a').click() #Tramites y consultas
for handle in driver.window_handles:
    if handle != main_page:
        login_page = handle
driver.switch_to.window(login_page) #Cambiar de ventana
driver.maximize_window()
WebDriverWait(driver, 20).until(EC.presence_of_element_located((By.XPATH,'//*[@id ="txtRuc"]')))
driver.find_element(By.XPATH,'//*[@id ="txtRuc"]').send_keys(claves[0]) #Cuadro input RUC
driver.find_element(By.XPATH,'//*[@id ="txtUsuario"]').send_keys(claves[1]) #Cuadro input nombre o razon
driver.find_element(By.XPATH,'//*[@id ="txtContrasena"]').send_keys(claves[2]) #Cuadro input clave
driver.find_element(By.XPATH, '//*[@id ="btnAceptar"]').click() #Aceptar login
try:
    WebDriverWait(driver,60).until(EC.frame_to_be_available_and_switch_to_it(('ifrVCE')))
    WebDriverWait(driver,8).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="btnFinalizarValidacionDatos"]')))
    driver.find_element(By.XPATH, '//*[@id="btnFinalizarValidacionDatos"]"]').click()
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="btnCerrar"]')))
    driver.find_element(By.XPATH, '//*[@id="btnCerrar"]').click()
except:
    WebDriverWait(driver,60).until(EC.frame_to_be_available_and_switch_to_it(('ifrVCE')))
    WebDriverWait(driver,8).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="btnFinalizarValidacionDatos"]')))
    driver.find_element(By.XPATH, '//*[@id="btnFinalizarValidacionDatos"]"]').click()
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="btnCerrar"]')))
    driver.find_element(By.XPATH, '//*[@id="btnCerrar"]').click()
finally:
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id ="divOpcionServicio2"]')))
    driver.find_element(By.XPATH, '//*[@id ="divOpcionServicio2"]').click() #Opcion Empresas
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="nivel1_10"]')))
    driver.find_element(By.XPATH,'//*[@id="nivel1_10"]').click() #Mi RUC y otros registros
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="nivel2_10_1"]')))
    driver.find_element(By.XPATH,'//*[@id="nivel2_10_1"]').click() #Mis datos del RUC
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="nivel3_10_1_1"]')))
    driver.find_element(By.XPATH,'//*[@id="nivel3_10_1_1"]').click() #RUC
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="nivel4_10_1_1_1_1"]')))
    driver.find_element(By.XPATH,'//*[@id="nivel4_10_1_1_1_1"]').click() #Ficha RUC
    WebDriverWait(driver,60).until(EC.frame_to_be_available_and_switch_to_it(('iframeApplication'))) #Cambiar a iframe Ficha RUC
    WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH,'/html/body/center/table[2]/tbody/tr/td[2]/form/input[2]')))
    driver.find_element(By.XPATH,'/html/body/center/table[2]/tbody/tr/td[2]/form/input[2]').click() #Mostrar Ficha RUC
    sleep(5)
    datos=bs(driver.page_source,'html.parser')
    sleep(2)
    driver.close()
    driver.switch_to.window(main_page)
    driver.close()
    table1=datos.find('table')
    print(table1)
    datostabla1=datos.find_all('td',{'class':'bg'})

    for i in (datostabla1):
        print((i.replace("\n", "")).replace(" ",""))