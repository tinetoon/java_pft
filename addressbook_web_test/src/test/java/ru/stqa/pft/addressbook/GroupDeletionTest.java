package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.GroupData;

/**
 * Класс для тестирования удаления групп в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest() {

        String checkBoxXpath = "//input[@title=\"Select (TestGroup)\"]";
        String deleteButtonXpath = "//*[@name=\"delete\"][1]";

        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isGroupPresent(checkBoxXpath)) {
            app.getGroupHelper().createGroup(new GroupData("TestGroup"));
        }

        app.getGroupHelper().selectGroup(checkBoxXpath);
        app.getGroupHelper().deleteSelectedGroup(deleteButtonXpath);
    }

}
