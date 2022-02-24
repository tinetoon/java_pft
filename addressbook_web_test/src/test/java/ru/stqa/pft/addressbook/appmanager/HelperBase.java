package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

/**
 * Базовый класс помощников
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver driver) {
        this.wd = driver;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    // Метод заполняющий текстовое поле ввода
    protected void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
