from selenium.webdriver import Chrome, ActionChains
from selenium.webdriver.common.by import By

import pandas as pd


driver = Chrome()
actions = ActionChains(driver)

driver.implicitly_wait(2)

driver.get('https://service.unece.org/trade/locode/2022-2%20SubdivisionCodes.htm')

table = driver.find_elements(By.CSS_SELECTOR, 'tr')

locations = []

for line in table:
    elements = line.find_elements(By.CSS_SELECTOR, 'td')
    locations.append({
        'name': elements[2].text,
        'region': elements[3].text,
        'code': str(elements[0].text) + '-' + str(elements[1].text),
    })

df = pd.DataFrame(locations)


df.to_csv('locations.csv')
