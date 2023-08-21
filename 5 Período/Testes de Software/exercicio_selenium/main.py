from selenium.webdriver import Chrome, ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from pdfkit import from_string
from time import sleep

driver = Chrome()
actions = ActionChains(driver)

driver.implicitly_wait(2)

driver.get('https://portal.pucminas.br/biblioteca/index_padrao.php')

search_bar = driver.find_element(By.ID, 'searchboxholdingsid')

search_bar.send_keys('Testes de Software')

enter_btn = driver.find_element(By.CLASS_NAME, 'fa-chevron-right')

enter_btn.click()

WebDriverWait(driver, 0.5).until(expected_conditions.number_of_windows_to_be(2))

driver.switch_to.window(driver.window_handles[1])

confirm_btn = driver.find_element(By.ID, 'proceed-button')

confirm_btn.click()

sleep(5)

show_more = driver.find_element(By.ID, 'multiSelectDocTypeContent')

show_more = show_more.find_element(By.CSS_SELECTOR, 'a')

show_more.click()

book_selector = driver.find_element(By.ID, 'modal__doc_type_430BK')

book_selector.click()

selector_btn = driver.find_element(By.CLASS_NAME, 'button.primary-action.evt-update-btn')

selector_btn.click()

books_data = {}

for page in range(0, 5):
    books = driver.find_elements(By.CSS_SELECTOR, 'li.result-list-li')
    for book in books:
        title = book.find_element(By.CSS_SELECTOR, 'h3').text.split('/')[0]
        text = book.find_element(By.CLASS_NAME, 'display-info').text
        books_data.update({title: text})

    next_page_btn = driver.find_element(By.ID, 'ctl00_ctl00_MainContentArea_MainContentArea_bottomMultiPage_lnkNext')
    next_page_btn.click()

num_of_books = str(len(books_data))

html_template = '<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> \n' \
                '<h3>Número de livros</h3><p>' + num_of_books + '</p> \n'

for data in books_data:
    html_template += "<h1>" + data + '</h1><p>' + books_data[data] + '</p>' + '\n'

from_string(html_template, 'selenium_test.pdf')

driver.quit()
