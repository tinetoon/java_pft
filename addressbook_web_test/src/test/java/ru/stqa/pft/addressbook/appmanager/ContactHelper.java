package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.testData.NewNoteData;

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
    public void fillAddNewNoteForm(NewNoteData newNoteData) {

        wd.findElement(By.name(newNoteData.getFIRST_NAME_XPATH())).sendKeys(newNoteData.getFirstName());
        wd.findElement(By.name(newNoteData.getEMAIL_XPATH())).sendKeys(newNoteData.getEmail());
        wd.findElement(By.name(newNoteData.getLAST_NAME_XPATH())).sendKeys(newNoteData.getLastName());
        wd.findElement(By.name(newNoteData.getADDRESS_XPATH())).sendKeys(newNoteData.getAddress());
        wd.findElement(By.name(newNoteData.getMOBILE_PHONE_XPATH())).sendKeys(newNoteData.getMobileFone());
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
