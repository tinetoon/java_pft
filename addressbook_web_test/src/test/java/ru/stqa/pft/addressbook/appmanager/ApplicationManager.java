package ru.stqa.pft.addressbook.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationManager {

    protected WebDriver driver;

    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private String browserName;

    public ApplicationManager(String browserName) {

        this.browserName = browserName;
    }

    // Метод инициализации и входа в БД
    public void init() {

//        String browser = BrowserType.CHROME; // deprecated
//        String browser = Browser.CHROME.browserName();

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("internet explorer")) {
            /*WebDriverManager.iedriver().setup();
            InternetExplorerDriverService service = new InternetExplorerDriverService
                    .Builder()
                    .usingPort(80)
//                    .withHost("http://localhost/addressbook/")
//                    .withLogLevel(InternetExplorerDriverLogLevel.DEBUG)
                    .build();
            driver = new InternetExplorerDriver(service);*/
            driver = new InternetExplorerDriver();
        } else if (browserName.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browserName.equals("MicrosoftEdge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("http://localhost/addressbook/group.php"); // !!! Вынести "магические переменные"

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
