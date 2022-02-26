package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

/**
 * Класс помощник по авторизации в БД
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    // Метод авторизации в БД
    public void authorization(String userName, String password) {

        wd.manage().window().setSize(new Dimension(1936, 1056));
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(lc.getBUTTON_AUTHORIZATION_ENTER());
    }
}
