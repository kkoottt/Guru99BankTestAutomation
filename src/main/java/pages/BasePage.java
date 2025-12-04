package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    // Locators
    protected final By newCustomerBtn = By.xpath("//a[contains(text(),'New Customer')]");
    protected final By editCustomerBtn = By.xpath("//a[contains(text(),'Edit Customer')]");
    protected final By deleteCustomerBtn = By.xpath("//a[@href='DeleteCustomerInput.php']");
    protected final By newAccountBtn = By.xpath("//a[contains(text(),'New Account')]");
    protected final By editAccountBtn = By.xpath("//a[contains(text(),'Edit Account')]");
    protected final By deleteAccountBtn = By.xpath("//a[contains(text(),'Delete Account')]");
    protected final By depositBtn = By.xpath("//a[contains(text(),'Deposit')]");
    protected final By withdrawalBtn = By.xpath("//a[contains(text(),'Withdrawal')]");
    protected final By fundTransferBtn = By.xpath("//a[contains(text(),'Fund Transfer')]");
    protected final By changePasswordBtn = By.xpath("//a[contains(text(),'Change Password')]");
    protected final By balanceEnquiryBtn = By.xpath("//a[contains(text(),'Balance Enquiry')]");
    protected final By miniStatementBtn = By.xpath("//a[contains(text(),'Mini Statement')]");
    protected final By customisedStatementBtn = By.xpath("//a[contains(text(),'Customised Statement')]");
    protected final By logoutBtn = By.xpath("//a[contains(text(),'Log out')]");
    protected final By submitBtn = By.xpath("//input[@type='submit']");
    protected final By resetBtn = By.xpath("//input[@type='reset']");
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

    public String getFirstOption(By locator) {
        Select select = new Select(waitElement(locator));
        return select.getOptions().getFirst().getText();
    }
}
