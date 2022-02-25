package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.NewNoteData;

/**
 * Класс для тестирования создания новой записи в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class AddNewDataTest extends TestBase {

    @Test
    public void addNewTest() {

        // Тестовые данные
        String addNewPageXpath = "//a[.='add new']";
        String buttonXpath = "//div[@id=\"content\"]//*[@type=\"submit\"][1]";
        String firstName = "Boris";
        String lastName = "Ivanov";
        String address = "Moscow";
        String email = "email@mail.ts";
        String mobileFone = "+79991231212";

        NewNoteData newNoteData = new NewNoteData(firstName, lastName, address, email, mobileFone);

        app.getNavigationHelper().goToPage(addNewPageXpath);
        app.getContactHelper().fillAddNewNoteForm(newNoteData);
        app.getContactHelper().createNewData(buttonXpath);
    }

}
