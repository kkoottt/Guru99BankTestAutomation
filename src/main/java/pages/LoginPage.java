package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // Locators (userID, password, loginbtn, resetbtn)
    private final By userIDField = By.xpath("//input[@type='text']");
    private final By userIDErrorMessage = By.xpath("//label[@id='message23']");
    private final By passwordField = By.xpath("//input[@type='password']");
    private final By passwordErrorMessage = By.xpath("//label[@id='message18']");
    private final By loginBtn = By.xpath("//input[@type='submit']");
    private final By resetBtn = By.xpath("//input[@type='reset']");

    // Web Driver Constructor
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions (enterUserID, enterPassword, clickLogin, clickReset, getUserID, getPassword)
    public void enterUserID(String userID) {
        driver.findElement(userIDField).sendKeys(userID);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void clickReset() {
        driver.findElement(resetBtn).click();
    }

    public String getTextUserID() {
        return driver.findElement(userIDField).getAttribute("value");
    }

    public String getTextPassword () {
        return driver.findElement(passwordField).getAttribute("value");
    }

    public String getUserIDErrorMessage() {
        return driver.findElement(userIDErrorMessage).getText();
    }

    public String getPasswordErrorMessage() {
        return driver.findElement(passwordErrorMessage).getText();
    }
}
