package ru.stqa.pft.addressbook;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
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

        /*GroupData groupData = new GroupData("TestGroupEdit",
                                            "Test group header edit",
                                            "Test group footer edit");*/
        GroupData groupData = new GroupData("TestGroup",
                                            "Test group header",
                                            "Test group footer");

        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().groupCreateMethod(new GroupData("TestGroup"));
        }

        app.getNavigationHelper().goToGroupPage();

        // Вычисляем количество групп до добавления
        int before = app
                .getGroupHelper()
                .getGroupCount();

        app.getGroupHelper().selectGroup(before - 2);
        app.getGroupHelper().initGroupEdit();
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupEdit();
        app.getGroupHelper().returnToGroupPage();

        // Вычисляем количество групп после добавления
        int after = app
                .getGroupHelper()
                .getGroupCount();

        Assert.assertEquals(after, before);
    }

    @AfterTest
    public void groupDeletion() {

        app.init();
        app.getNavigationHelper().goToGroupPage();

        // Вычисляем количество групп до добавления
        int before = app
                .getGroupHelper()
                .getGroupCount();

        app.getGroupHelper().selectGroup(before - 2); // Выбираем предпоследнюю группу с индексом (before - 2)
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().goToGroupPage();

        // Вычисляем количество групп после добавления
        int after = app
                .getGroupHelper()
                .getGroupCount();

        Assert.assertEquals(after, (before - 1));

        app.stop();
    }
}
