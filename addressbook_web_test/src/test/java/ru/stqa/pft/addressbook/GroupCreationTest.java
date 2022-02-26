package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.GroupData;

/**
 * Класс для тестирования создания групп в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTest() {

        GroupData groupData = new GroupData("TestGroup", "Test group header", "Test group footer");

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreate();
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupCreate();
        app.getGroupHelper().returnToGroupPage();
    }

}
