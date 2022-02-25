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
    public void fillGroupForm(String nameName, String headerName, String footerName, GroupData groupData) {
        type(By.name(nameName), groupData.getNameGroup());
        type(By.name(headerName), groupData.getHeaderGroup());
        type(By.name(footerName), groupData.getFooterGroup());
    }

    // Метод создания новой группы
    public void initGroupCreation(String buttonName) {
        click(By.name(buttonName));
    }

    // Метод выделения группы
    public void selectGroup(String checkBoxXpath) {
        click(By.xpath(checkBoxXpath));
    }

    // Метод удаления выделенной группы
    public void deleteSelectedGroup(String deleteButtonXpath) {
        click(By.xpath(deleteButtonXpath));
    }

    public void createNewGroup(String createButtonName) {
        click(By.name(createButtonName));
    }

    public void initGroupEdit(String initButtonName) {
        click(By.name(initButtonName));
    }

    public void submitGroupEdit(String editButtonName) {
        click(By.name(editButtonName));
    }
}
