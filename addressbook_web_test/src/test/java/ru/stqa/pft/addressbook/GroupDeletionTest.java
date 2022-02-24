package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Класс для тестирования удаления групп в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest() {

        String groupPageXpath = "//div[@id=\"nav\"]//a[.='groups']";
        String checkBoxXpath = "//input[@title=\"Select (TestGroup)\"]";
        String deleteButtonXpath = "//*[@name=\"delete\"][1]";

        goToPage(groupPageXpath);
        selectGroup(checkBoxXpath);
        deleteSelectedGroup(deleteButtonXpath);
    }

    // Метод выделения группы
    private void selectGroup(String s) {
        getDriver().findElement(By.xpath(s)).click();
    }

    // Метод удаления выделенной группы
    private void deleteSelectedGroup(String s) {
        getDriver().findElement(By.xpath(s)).click();
    }
}
