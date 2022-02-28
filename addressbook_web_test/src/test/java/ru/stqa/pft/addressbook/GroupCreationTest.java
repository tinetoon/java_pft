package ru.stqa.pft.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.GroupData;

/**
 * Класс для тестирования создания групп в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class GroupCreationTest extends TestBase {

    @Test(enabled = false)
    public void groupCreationTest() {

        GroupData groupData = new GroupData("TestGroup", "Test group header", "Test group footer");

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreate();
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupCreate();
        app.getGroupHelper().returnToGroupPage();
    }

    @Test()
    public void groupCreationEndCountTest() {

        GroupData groupData = new GroupData("TestGroup", "Test group header", "Test group footer");

        app.getNavigationHelper().goToGroupPage();

        // Вычисляем количество групп до добавления
        int before = app
                .getGroupHelper()
                .getGroupCount();

        app.getGroupHelper().initGroupCreate();
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupCreate();
        app.getGroupHelper().returnToGroupPage();

        // Вычисляем количество групп после добавления
        int after = app
                .getGroupHelper()
                .getGroupCount();

        Assert.assertEquals(after, (before + 1));
    }

}
