package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CustomerHomePage;
import pages.LoginPage;
import pages.ManagerHomePage;
import pages.NewCustomerForm;
import utils.AlertHelper;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ManagerHomePage managerHomePage;
    protected NewCustomerForm newCustomerForm;
    protected CustomerHomePage customerHomePage;
    protected AlertHelper alertHelper;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/V4/index.php");
        loginPage = new LoginPage(driver);
        alertHelper = new AlertHelper(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    public void loginAsManager() {
        loginPage.enterUserID("mngr646646");
        loginPage.enterPassword("@123");
        loginPage.clickLogin();

        managerHomePage = new ManagerHomePage(driver);
    }

    public void loginAsCustomer() {
        loginPage.enterUserID("61318");
        loginPage.enterPassword("asd");
        loginPage.clickLogin();

        customerHomePage = new CustomerHomePage(driver);
    }

    public void tab() {
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
    }
}
