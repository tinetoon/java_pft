package ru.stqa.pft.addressbook.model;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

/**
 * Базовый класс для тестирования БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class TestBase {

    // Раскомментируйте нужную строку для выполнения тестов в соответствующем браузере
    String typeBrowser = Browser.CHROME.browserName();
//    String typeBrowser = Browser.IE.browserName(); // !!! Не работает, разобраться с настройками драйвера
//    String typeBrowser = Browser.EDGE.browserName();
//    String typeBrowser = Browser.OPERA.browserName();

    protected final ApplicationManager app = new ApplicationManager(typeBrowser);

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
