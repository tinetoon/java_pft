package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;

/**
 * Класс для тестирования удаления групп в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest() {

        String groupPageXpath = "//div[@id=\"nav\"]//a[.='groups']";
        String checkBoxXpath = "//input[@title=\"Select (TestGroup)\"]";
        String deleteButtonXpath = "//*[@name=\"delete\"][1]";

        app.getNavigationHelper().goToGroupPage(groupPageXpath);
        app.getGroupHelper().selectGroup(checkBoxXpath);
        app.getGroupHelper().deleteSelectedGroup(deleteButtonXpath);
    }

}
