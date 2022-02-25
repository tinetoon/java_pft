package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;

/**
 * Класс для тестирования удаления записи в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 25.02.2022
 */

public class DataDeletionTest extends TestBase {

    @Test
    public void testDataDeletion() {

        // Тестовые данные
        String homePageXpath = "//a[.='home']";
        String checkBoxXpath = "//input[@title=\"Select (Boris Ivanov)\"]";
        String deleteButtonXpath = "//input[@value=\"Delete\"]";

        app.getNavigationHelper().goToHomePage(homePageXpath);
        app.getContactHelper().selectData(checkBoxXpath);
        app.getContactHelper().deleteSelectedData(deleteButtonXpath);
        app.getContactHelper().confirmDeletion();
    }
}
