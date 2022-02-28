package ru.stqa.pft.addressbook;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Класс для тестирования редактирования групп в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class GroupEditTest extends TestBase {

    @Test(enabled = false)
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

    @Test
    public void testGroupListEdit() {

        /*GroupData groupData = new GroupData("TestGroupEdit",
                                            "Test group header edit",
                                            "Test group footer edit");*/
        /*GroupData groupData = new GroupData("TestGroup",
                "Test group header",
                "Test group footer");*/

        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().groupCreateMethod(new GroupData("TestGroup"));
        }

        app.getNavigationHelper().goToGroupPage();

        // Создаём лист групп
        List<GroupData> before = app.getGroupHelper().getGroupList();
        int id = before.get(before.size() - 2).getId();

        app.getGroupHelper().selectGroup(before.size() - 2);
        app.getGroupHelper().initGroupEdit();

        GroupData groupData = new GroupData(
                id,
                "TestGroup",
                "Test group header",
                "Test group footer");

        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupEdit();
        app.getGroupHelper().returnToGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size());

        // Сравниваем два множества групп
        before.remove(before.size() - 2);
        before.add(new GroupData(id, "TestGroup"));
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    @AfterTest
    public void groupDeletion() {

        app.init();
        app.getNavigationHelper().goToGroupPage();

        // Создаём лист групп
        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().selectGroup(before.size() - 2); // Выбираем предпоследнюю группу с индексом (before - 2)
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().goToGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), (before.size() - 1));

        app.stop();
    }
}
