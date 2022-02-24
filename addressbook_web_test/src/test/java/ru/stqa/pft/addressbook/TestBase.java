package ru.stqa.pft.addressbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.testData.GroupData;
import ru.stqa.pft.addressbook.testData.NewNoteData;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Базовый класс для тестирования БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class TestBase {
    JavascriptExecutor js;
    private WebDriver driver;
    private Map<String, Object> vars;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // is deprecated
        new WebDriverWait(driver, Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        driver.get("http://localhost/addressbook/");
        authorization("admin", "secret");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // Метод авторизации в БД
    private void authorization(String userName, String password) {

        String mainPageXpath = "//input[@type=\"submit\"]";

        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).sendKeys(userName);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).sendKeys(password);
        goToPage(mainPageXpath);
    }

    // Метод заполнения полей новой группы
    protected void fillGroupForm(String name, String header, String footer, String button, GroupData groupData) {
        driver.findElement(By.name(name)).click();
        driver.findElement(By.name(name)).sendKeys(groupData.getNameGroup());
        driver.findElement(By.name(header)).click();
        driver.findElement(By.name(header)).sendKeys(groupData.getHeaderGroup());
        driver.findElement(By.name(footer)).click();
        driver.findElement(By.name(footer)).sendKeys(groupData.getFooterGroup());
        driver.findElement(By.name(button)).click();
    }

    // Метод создания новой группы
    protected void initGroupCreation(String s) {
        driver.findElement(By.name(s)).click();
    }

    // Метод заполнения полей новой записи в БД
    protected void fillAddNewNoteForm(NewNoteData newNoteData) {

        driver.findElement(By.name(newNoteData.getFIRST_NAME_XPATH())).sendKeys(newNoteData.getFirstName());
        driver.findElement(By.name(newNoteData.getLAST_NAME_XPATH())).sendKeys(newNoteData.getLastName());
        driver.findElement(By.name(newNoteData.getADDRESS_XPATH())).sendKeys(newNoteData.getAddress());
        driver.findElement(By.name(newNoteData.getEMAIL_XPATH())).sendKeys(newNoteData.getEmail());
        driver.findElement(By.name(newNoteData.getMOBILE_PHONE_XPATH())).sendKeys(newNoteData.getMobileFone());
    }

    // Метод перехода на страницу
    protected void goToPage(String s) {
        driver.findElement(By.xpath(s)).click();
    }

    // Метод сохранения данных в БД
    protected void saveData(String s) {
        driver.findElement(By.xpath(s)).click();
    }

    // Геттер для драйвера
    public WebDriver getDriver() {
        return driver;
    }
}
