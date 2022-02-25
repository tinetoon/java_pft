package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.GroupData;

/**
 * Класс для тестирования редактирования групп в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class GroupEditTest extends TestBase {

    @Test
    public void testGroupEdit() {

        String checkBoxXpath = "//input[@title=\"Select (TestGroup)\"]";
        /*GroupData groupData = new GroupData("TestGroupEdit",
                                            "Test group header edit",
                                            "Test group footer edit");*/
        GroupData groupData = new GroupData("TestGroup",
                                            "Test group header",
                                            "Test group footer");

        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isGroupPresent(checkBoxXpath)) {
            app.getGroupHelper().createGroup(new GroupData("TestGroup"));
        }

        app.getGroupHelper().selectGroup(checkBoxXpath);
        app.getGroupHelper().initGroupEdit();
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupEdit();
        app.getGroupHelper().returnToGroupPage();
    }
}
