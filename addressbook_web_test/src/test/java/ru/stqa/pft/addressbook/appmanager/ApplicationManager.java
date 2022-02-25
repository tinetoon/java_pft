package ru.stqa.pft.addressbook.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationManager {

    protected WebDriver driver;

    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;

    // Метод инициализации и входа в БД
    public void init() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("http://localhost/addressbook/"); // !!! Вынести "магические переменные"

        groupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper = new SessionHelper(driver);
        navigationHelper = new NavigationHelper(driver);

        sessionHelper.authorization("admin", "secret"); // !!! Вынести "магические переменные"
    }

    // Метод завершения тестов
    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
