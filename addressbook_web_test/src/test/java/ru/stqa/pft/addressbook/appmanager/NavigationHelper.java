package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Класс помощник навигации по БД
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    // Метод перехода на страницу
    public void goToPage(String buttonXpath) {
            click(By.xpath(buttonXpath));
    }

    // Метод перехода на страницу групп
    public void goToGroupPage() {

        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        } else {
            click(lc.getMENU_GROUP_PAGE());
        }
    }

    // Метод перехода на главную страницу
    public void goToHomePage(String buttonXpath) {

        if (! isElementPresent(By.id("maintable"))) {
            click(By.xpath(buttonXpath));
        }
    }
}
