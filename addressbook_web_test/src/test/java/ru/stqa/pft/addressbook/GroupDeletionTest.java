package ru.stqa.pft.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.GroupData;

import java.util.List;

/**
 * Класс для тестирования удаления групп в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class GroupDeletionTest extends TestBase {

    @Test(enabled = false)
    public void groupDeletionTest() {

        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().groupCreateMethod(new GroupData("TestGroup"));
        }

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
    }

    @Test
    public void groupDeletionListTest() {

        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().groupCreateMethod(new GroupData("TestGroup"));
        }

        app.getNavigationHelper().goToGroupPage();

        // Создаём лист групп
        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().selectGroup(before.size() - 2); // Выбираем предпоследнюю группу с индексом (before - 2)
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().goToGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), (before.size() - 1));

        // Удаляем из списка before удалённую группу
        before.remove(before.size() - 2);

        /*for (int i = 0; i < after.size(); i++) {

            Assert.assertEquals(before.get(i), after.get(i));
        }*/

        // Сравниваем списки групп
        Assert.assertEquals(before, after);
    }

}
