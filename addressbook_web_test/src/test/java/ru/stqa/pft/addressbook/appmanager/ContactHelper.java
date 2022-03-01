package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.testData.ContactData;

import java.util.ArrayList;
import java.util.List;

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

        type(lc.getFILL_DATA_FIRST_NAME(), contactData.getFirstName());
        type(lc.getFILL_DATA_LAST_NAME(), contactData.getLastName());
        type(lc.getFILL_DATA_EMAIL(), contactData.getEmail());
        type(lc.getFILL_DATA_ADDRESS(), contactData.getAddress());
        type(lc.getFILL_DATA_PHONE(), contactData.getMobileFone());
    }

    // Метод заполнения полей новой записи в БД
    public void fillContactForm(ContactData contactData, boolean isCreationForm) {

        type(lc.getFILL_DATA_FIRST_NAME(), contactData.getFirstName());
        type(lc.getFILL_DATA_LAST_NAME(), contactData.getLastName());

        // Проверка изменяется форма или создаётся
        if (isCreationForm) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group"))); // При изменении формы поле выбора группы должно отсутствовать
        }
    }

    // Метод сохранения данных в БД
    public void createNewData() {
        click(lc.getBUTTON_DATA_NEW_ENTER());
    }

    public void selectData(int index) {

        wd.findElements(lc.getCHECK_BOX_COUNT_DATA())
                .get(index)
                .click();
//        click(lc.getCHECK_BOX_DATA());
    }

    public void deleteSelectedData() {
        click(lc.getBUTTON_DATA_DELETE_ENTER());
    }

    public void confirmDeletion() {

        if (isAlertPresent()) {
            alertOk();
        }
    }

    public void initDatEdit(int index) {

        wd.findElements(lc.getSPAN_DATA())
                .get(index)
                .findElement(By.cssSelector("img[title='Edit']"))
                .click();
//        click(lc.getBUTTON_DATA_EDIT());
    }

    public void submitDataEdit() {
        click(lc.getBUTTON_DATA_EDIT_ENTER());
    }

    public void createDataMethod(ContactData testData) {
        fillAddNewNoteForm(testData);
        createNewData();
    }

    public boolean isDataPresent() {
        return isElementPresent(lc.getCHECK_BOX_DATA());
    }

    public List<ContactData> getDataList() {

        List<ContactData> contactDataList = new ArrayList<>();
        List<WebElement> elements = wd.findElements(lc.getSPAN_DATA());

        for (WebElement element: elements) {

//            String lastName = elements.get(0).findElements(By.tagName("td")).get(1).getText();
//            String lastName = elements.get(1).findElements(By.tagName("td")).get(1).getText();
            String lastName = element
                    .findElements(By.tagName("td"))
                    .get(1)
                    .getText();
            String firstName = element
                    .findElements(By.tagName("td"))
                    .get(2)
                    .getText();
            String address = element
                    .findElements(By.tagName("td"))
                    .get(3)
                    .getText();
            String email = element
                    .findElements(By.tagName("td"))
                    .get(4)
                    .getText();
            String idString = element
                    .findElement(lc.getCHECK_BOX_IN_SPAN())
                    .getAttribute("value");

            ContactData contact = new ContactData(Integer.valueOf(idString), firstName, lastName);
            contactDataList.add(contact);

        }

        return contactDataList;
    }
}
