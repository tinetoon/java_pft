package ru.stqa.pft.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

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

    @Test(enabled = false)
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

    @Test()
    public void groupCreationEndListTest() {

        GroupData groupData = new GroupData("TestGroup", "Test group header", "Test group footer");

        app.getNavigationHelper().goToGroupPage();

        // Создаём лист групп
        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().initGroupCreate();
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupCreate();
        app.getGroupHelper().returnToGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), (before.size() + 1));

        /*int maxId = 0;
        for (GroupData g: after) {
            if (g.getId() > maxId) {
                maxId = g.getId();
            }
        }*/
        /*Comparator<? super GroupData> byId = new Comparator<GroupData>() {
            @Override
            public int compare(GroupData o1, GroupData o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        };*/
//        Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        /*Comparator<? super GroupData> byId = Comparator.comparingInt(o -> o.getId());

        int maxId = after
                .stream()
                .max(byId)
                .get()
                .getId();*/
        int maxId = after
                .stream()
                .max(Comparator.comparingInt(o -> o.getId()))
                .get()
                .getId();
//        groupData.setId(maxId);
        before.add(new GroupData(maxId, "TestGroup"));
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
