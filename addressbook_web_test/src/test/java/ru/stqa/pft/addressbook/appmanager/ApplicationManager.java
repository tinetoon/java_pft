package ru.stqa.pft.addressbook.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.addressbook.testData.NewNoteData;

import java.time.Duration;

public class ApplicationManager {

    protected WebDriver driver;

    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;

    // Метод инициализации и входа в БД
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // is deprecated
        new WebDriverWait(driver, Duration.ofSeconds(60));

        driver.get("http://localhost/addressbook/");

        sessionHelper = new SessionHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        groupHelper = new GroupHelper(driver);

        sessionHelper.authorization("admin", "secret");
    }

    // Метод заполнения полей новой записи в БД
    public void fillAddNewNoteForm(NewNoteData newNoteData) {

        driver.findElement(By.name(newNoteData.getFIRST_NAME_XPATH())).sendKeys(newNoteData.getFirstName());
        driver.findElement(By.name(newNoteData.getEMAIL_XPATH())).sendKeys(newNoteData.getEmail());
        driver.findElement(By.name(newNoteData.getLAST_NAME_XPATH())).sendKeys(newNoteData.getLastName());
        driver.findElement(By.name(newNoteData.getADDRESS_XPATH())).sendKeys(newNoteData.getAddress());
        driver.findElement(By.name(newNoteData.getMOBILE_PHONE_XPATH())).sendKeys(newNoteData.getMobileFone());
    }

    // Метод сохранения данных в БД
    public void saveData(String s) {
        driver.findElement(By.xpath(s)).click();
    }

    // Метод завершения тестов
    public void stop() {
        driver.quit();
    }

    // Геттер для драйвера
    public WebDriver getDriver() {
        return driver;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
