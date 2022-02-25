package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
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

    // Метод создания новой группы
    public void initGroupCreation() {
        click(lc.getBUTTON_GROUP_NEW());
    }

    // Метод выделения группы
    public void selectGroup(String checkBoxXpath) {
        click(By.xpath(checkBoxXpath));
    }

    // Метод удаления выделенной группы
    public void deleteSelectedGroup(String deleteButtonXpath) {
        click(By.xpath(deleteButtonXpath));
    }

    public void clickButtonCreateNewGroup() {
        click(lc.getBUTTON_GROUP_NEW_ENTER());
    }

    public void initGroupEdit() {
        click(lc.getBUTTON_GROUP_EDIT());
    }

    public void submitGroupEdit() {
        click(lc.getBUTTON_GROUP_EDIT_ENTER());
    }

    // Метод возврата на страницу групп
    public void returnToGroupPage() {
        click(lc.getBUTTON_PAGE_RETURN_GROUP());
    }

    public void createGroup(GroupData testGroup) {
        initGroupCreation();
        fillGroupForm(testGroup);
        clickButtonCreateNewGroup();
        returnToGroupPage();
    }

    public boolean isGroupPresent(String checkBoxXpath) {
        return isElementPresent(By.xpath(checkBoxXpath));
    }
}
