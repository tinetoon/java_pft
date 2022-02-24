package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.testData.GroupData;
import ru.stqa.pft.addressbook.testData.NewNoteData;

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

        goToPage(groupPageXpath);
        initGroupCreation(creationGroupName);
        fillGroupForm(nameGroupXpath, headerGroupXpath, footerGroupXpath, buttonNameXpath, groupData);
        goToPage(returnGroupPageXpath);
    }

}
