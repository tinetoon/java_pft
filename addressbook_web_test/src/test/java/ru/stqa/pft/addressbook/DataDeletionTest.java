package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.ContactData;

/**
 * Класс для тестирования удаления записи в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 25.02.2022
 */

public class DataDeletionTest extends TestBase {

    @Test
    public void testDataDeletion() {

        // Тестовые данные
        String firstName = "Boris";
        String lastName = "Ivanov";
        String address = "Moscow";
        String email = "email@mail.ts";
        String mobileFone = "+79991231212";

        ContactData contactData = new ContactData(firstName, lastName, address, email, mobileFone);

        app.getNavigationHelper().goToHomePage();

        if (! app.getContactHelper().isDataPresent()) {
            app.getNavigationHelper().goToAddNewPage();
            app.getContactHelper().createDataMethod(contactData);
        }

        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectData();
        app.getContactHelper().deleteSelectedData();
        app.getContactHelper().confirmDeletion();
    }
}
