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
    public void fillGroupForm(String nameName, String headerName, String footerName, String buttonName, GroupData groupData) {
        type(By.name(nameName), groupData.getNameGroup());
        type(By.name(headerName), groupData.getHeaderGroup());
        type(By.name(footerName), groupData.getFooterGroup());
        click(By.name(buttonName));
    }

    // Метод создания новой группы
    public void initGroupCreation(String buttonName) {
        click(By.name(buttonName));
    }

    // Метод выделения группы
    public void selectGroup(String s) {
        wd.findElement(By.xpath(s)).click();
    }

    // Метод удаления выделенной группы
    public void deleteSelectedGroup(String s) {
        wd.findElement(By.xpath(s)).click();
    }
}
