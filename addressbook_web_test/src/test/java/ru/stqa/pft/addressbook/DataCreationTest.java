package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.ContactData;

/**
 * Класс для тестирования создания новой записи в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class DataCreationTest extends TestBase {

    @Test
    public void testDataCreation() {

        // Тестовые данные
        String addNewPageXpath = "//a[.='add new']";
        String buttonXpath = "//div[@id=\"content\"]//*[@type=\"submit\"][1]";
        String firstName = "Boris";
        String lastName = "Ivanov";
        String address = "Moscow";
        String email = "email@mail.ts";
        String mobileFone = "+79991231212";

        ContactData contactData = new ContactData(firstName, lastName, address, email, mobileFone);

        app.getNavigationHelper().goToPage(addNewPageXpath);
        app.getContactHelper().fillAddNewNoteForm(contactData);
        app.getContactHelper().createNewData(buttonXpath);
    }

    @Test
    public void testDataCreationWithGroup() {

        // Тестовые данные
        String addNewPageXpath = "//a[.='add new']";
        String buttonXpath = "//div[@id=\"content\"]//*[@type=\"submit\"][1]";
        String firstName = "Boris";
        String lastName = "Ivanov";
        String group = "TestGroup";

        ContactData contactData = new ContactData(firstName, lastName, group);

        app.getNavigationHelper().goToPage(addNewPageXpath);
        app.getContactHelper().fillContactForm(contactData, true);
        app.getContactHelper().createNewData(buttonXpath);
    }

}
