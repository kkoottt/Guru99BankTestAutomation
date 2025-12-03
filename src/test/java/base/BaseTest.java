package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.AlertHelper;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ManagerHomePage managerHomePage;
    protected CustomerHomePage customerHomePage;
    protected AlertHelper alertHelper;
    protected WebDriverWait wait;
    protected SoftAssert soft;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/V4/index.php");
        loginPage = new LoginPage(driver);
        alertHelper = new AlertHelper(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        soft = new SoftAssert();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    public void loginAsManager() {
        loginPage.enterUserID("mngr646646")
                .enterPassword("@123")
                .clickLogin();

        managerHomePage = new ManagerHomePage(driver);
    }

    public void loginAsCustomer() {
        loginPage.enterUserID("61318")
                .enterPassword("asd")
                .clickLogin();

        customerHomePage = new CustomerHomePage(driver);
    }

    public void tab() {
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
    }

    public void waitURL(String expectedURL) {
        wait.until(ExpectedConditions.urlToBe(expectedURL));
    }
}
