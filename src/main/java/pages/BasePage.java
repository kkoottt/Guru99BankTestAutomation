package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    // Locators
    protected By newCustomerBtn = By.xpath("//a[contains(text(),'New Customer')]");
    protected By editCustomerBtn = By.xpath("//a[contains(text(),'Edit Customer')]");
    protected By deleteCustomerBtn = By.xpath("//a[@href='DeleteCustomerInput.php']");
    protected By newAccountBtn = By.xpath("//a[contains(text(),'New Account')]");
    protected By editAccountBtn = By.xpath("//a[contains(text(),'Edit Account')]");
    protected By deleteAccountBtn = By.xpath("//a[contains(text(),'Delete Account')]");
    protected By depositBtn = By.xpath("//a[contains(text(),'Deposit')]");
    protected By withdrawalBtn = By.xpath("//a[contains(text(),'Withdrawal')]");
    protected By fundTransferBtn = By.xpath("//a[contains(text(),'Fund Transfer')]");
    protected By changePasswordBtn = By.xpath("//a[contains(text(),'Change Password')]");
    protected By balanceEnquiryBtn = By.xpath("//a[contains(text(),'Balance Enquiry')]");
    protected By miniStatementBtn = By.xpath("//a[contains(text(),'Mini Statement')]");
    protected By customisedStatementBtn = By.xpath("//a[contains(text(),'Customised Statement')]");
    protected By logoutBtn = By.xpath("//a[contains(text(),'Log out')]");

    protected WebDriver driver;
    private WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    protected String waitThenGetError(By locator) {
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBe(locator, "")
        ));

        return driver.findElement(locator).getText();
    }

    protected WebElement waitElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected boolean isDisabled(By locator) {
        return !driver.findElement(locator).isEnabled();
    }
}
