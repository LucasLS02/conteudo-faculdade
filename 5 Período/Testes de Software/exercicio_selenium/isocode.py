from selenium.webdriver import Chrome, ActionChains
from selenium.webdriver.common.by import By
from pandas import DataFrame
from time import sleep

driver = Chrome()
actions = ActionChains(driver)

driver.implicitly_wait(5)

driver.get('https://www.iso.org/obp/ui/#search/code/')

codes = []

for index in range(0, 9):
    driver.get(driver.current_url)
    sleep(1)

    table_div = driver.find_element(By.CSS_SELECTOR, 'div.v-grid-tablewrapper')

    rows = table_div.find_elements(By.CSS_SELECTOR, 'tr')

    for row in rows:
        cols = row.find_elements(By.CSS_SELECTOR, 'td')
        if len(cols) > 0:
            col = cols[2].text
            codes.append(col)

    btns = driver.find_elements(By.CSS_SELECTOR, 'span.v-button-caption')

    btn = btns[len(btns) - 1]

    btn.click()

values = []

for code in codes:
    try:
        url = 'https://www.iso.org/obp/ui/#iso:code:3166:' + code
        print(url)

        driver.get(url)
        sleep(10)

        table = driver.find_element(By.ID, 'subdivision')
        print(2)

        locations_data = table.find_elements(By.CSS_SELECTOR, 'tr')
        print(3)

        for location_data in locations_data:
            print('')
            current_location_data = location_data.find_elements(By.CSS_SELECTOR, 'td')
            print(len(current_location_data))
            if len(current_location_data) > 0:
                values.append({
                    'name': current_location_data[2].text,
                    'iso_code': current_location_data[1].text,
                })
    except Exception as e:
        print(e)

pd = DataFrame(values)

pd.to_csv('all_locations_iso_code.csv')
