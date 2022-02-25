package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
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

    // Метод, заполняющий текстовое поле ввода
    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    // Метод, подтверждающий действие на алерте
    protected void alertOk() {
        wd.switchTo().alert().accept();
    }

    // Метод, проверяющий наличие алерта на странице
    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    // Метод, проверяющий наличие элемента на странице
    protected boolean isElementPresent(By locator) {

        try {
            wd.findElement(locator);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
