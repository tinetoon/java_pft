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

        String groupPageXpath = "//div[@id=\"nav\"]//a[.='groups']";
        String returnGroupPageXpath = "//a[.='group page']";
        String creationGroupName = "new";
        String nameGroupXpath = "group_name";
        String headerGroupXpath = "group_header";
        String footerGroupXpath = "group_footer";
        String buttonNameXpath = "submit";
        GroupData groupData = new GroupData("TestGroup", "Test group header", "Test group footer");

        app.getNavigationHelper().goToPage(groupPageXpath);
        app.getGroupHelper().initGroupCreation(creationGroupName);
        app.getGroupHelper().fillGroupForm(nameGroupXpath, headerGroupXpath, footerGroupXpath, groupData);
        app.getGroupHelper().createNewGroup(buttonNameXpath);
        app.getNavigationHelper().goToPage(returnGroupPageXpath);
    }

}
