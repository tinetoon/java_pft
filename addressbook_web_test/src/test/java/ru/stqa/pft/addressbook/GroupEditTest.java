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

        String groupPageXpath = "//div[@id=\"nav\"]//a[.='groups']";
        String checkBoxXpath = "//input[@title=\"Select (TestGroup)\"]";
        String editButtonName = "edit";
        String nameGroupXpath = "group_name";
        String headerGroupXpath = "group_header";
        String footerGroupXpath = "group_footer";
        String editSubmitButtonName = "update";
        String returnGroupPageXpath = "//a[.='group page']";
        /*GroupData groupData = new GroupData("TestGroupEdit",
                                            "Test group header edit",
                                            "Test group footer edit");*/
        GroupData groupData = new GroupData("TestGroup",
                                            "Test group header",
                                            "Test group footer");

        app.getNavigationHelper().goToPage(groupPageXpath);
        app.getGroupHelper().selectGroup(checkBoxXpath);
        app.getGroupHelper().initGroupEdit(editButtonName);
        app.getGroupHelper().fillGroupForm(nameGroupXpath, headerGroupXpath, footerGroupXpath, groupData);
        app.getGroupHelper().submitGroupEdit(editSubmitButtonName);
        app.getNavigationHelper().goToPage(returnGroupPageXpath);
    }
}
