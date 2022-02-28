package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.testData.GroupData;

/**
 * Класс помощник по группам БД
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    // Метод заполнения полей новой группы
    public void fillGroupForm(GroupData groupData) {
        type(lc.getFILL_GROUP_NAME(), groupData.getNameGroup());
        type(lc.getFILL_GROUP_HEADER(), groupData.getHeaderGroup());
        type(lc.getFILL_GROUP_FOOTER(), groupData.getFooterGroup());
    }

    public void selectGroup() {
        click(lc.getCHECK_BOX_GROUP());
    }

    public void deleteSelectedGroup() {
        click(lc.getBUTTON_GROUP_DELETE_ENTER());
    }

    public void initGroupEdit() {
        click(lc.getBUTTON_GROUP_EDIT());
    }

    public void submitGroupEdit() {
        click(lc.getBUTTON_GROUP_EDIT_ENTER());
    }

    public void returnToGroupPage() {
        click(lc.getBUTTON_PAGE_RETURN_GROUP());
    }

    public void initGroupCreate() {
        click(lc.getBUTTON_GROUP_NEW());
    }

    public void submitGroupCreate() {
        click(lc.getBUTTON_GROUP_NEW_ENTER());
    }

    public void groupCreateMethod(GroupData testGroup) {
        initGroupCreate();
        fillGroupForm(testGroup);
        submitGroupCreate();
        returnToGroupPage();
    }

    public boolean isGroupPresent() {
        return isElementPresent(lc.getCHECK_BOX_GROUP());
    }

    // Счётчик групп
    public int getGroupCount() {

        return wd.findElements(lc.getCHECK_BOX_COUNT_GROUP()).size();
    }
}
