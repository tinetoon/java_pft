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

        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().groupCreateMethod(new GroupData("TestGroup"));
        }

        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroup();
    }

}
