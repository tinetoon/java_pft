package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.testData.ContactData;

/**
 * Класс помощник по записям в БД
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    // Метод заполнения полей новой записи в БД
    public void fillAddNewNoteForm(ContactData contactData) {

        type(By.name(contactData.getFIRST_NAME_XPATH()), contactData.getFirstName());
        type(By.name(contactData.getEMAIL_XPATH()), contactData.getEmail());
        type(By.name(contactData.getLAST_NAME_XPATH()), contactData.getLastName());
        type(By.name(contactData.getADDRESS_XPATH()), contactData.getAddress());
        type(By.name(contactData.getMOBILE_PHONE_XPATH()), contactData.getMobileFone());
    }

    // Метод заполнения полей новой записи в БД
    public void fillContactForm(ContactData contactData, boolean isCreationForm) {

        type(By.name(contactData.getFIRST_NAME_XPATH()), contactData.getFirstName());
        type(By.name(contactData.getLAST_NAME_XPATH()), contactData.getLastName());

        // Проверка изменяется форма или создаётся
        if (isCreationForm) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group"))); // При изменении формы поле выбора группы должно отсутствовать
        }
    }

    // Метод сохранения данных в БД
    public void createNewData(String createButtonXpath) {
        click(By.xpath(createButtonXpath));
    }

    public void selectData(String checkBoxXpath) {
        click(By.xpath(checkBoxXpath));
    }

    public void deleteSelectedData(String deleteButtonXpath) {
        click(By.xpath(deleteButtonXpath));
    }

    public void confirmDeletion() {

        if (isAlertPresent()) {
            alertOk();
        }
    }

    public void initDatEdit(String editButtonXpath) {
        click(By.xpath(editButtonXpath));
    }

    public void submitDataEdit(String editButtonOkXpath) {
        click(By.xpath(editButtonOkXpath));
    }
}
