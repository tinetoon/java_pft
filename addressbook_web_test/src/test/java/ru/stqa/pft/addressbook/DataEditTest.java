package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.ContactData;

/**
 * Класс для тестирования редактирования записи в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 25.02.2022
 */

public class DataEditTest extends TestBase {

    @Test
    public void testDataEdit() {

        // Тестовые данные
        String firstName = "Boris Edit";
        String lastName = "Ivanov Edit";
        String address = "Moscow city";
        String email = "edit@mail.ts";
        String mobileFone = "+70001231212";

        ContactData contactData = new ContactData(firstName, lastName, address, email, mobileFone);

        app.getNavigationHelper().goToHomePage();

        if (! app.getContactHelper().isDataPresent()) {
            app.getNavigationHelper().goToAddNewPage();
            app.getContactHelper().createDataMethod(contactData);
        }

        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initDatEdit();
        app.getContactHelper().fillContactForm(contactData, false);
        app.getContactHelper().submitDataEdit();
    }
}
