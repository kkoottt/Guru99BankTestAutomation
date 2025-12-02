package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerHomePage extends BasePage {

    // Web Driver Constructor
    public ManagerHomePage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void clickNewCustomerBtn() {
        driver.findElement(newCustomerBtn).click();
    }
    public void clickEditCustomerBtn() {
        driver.findElement(editCustomerBtn).click();
    }
    public void clickDeleteCustomerBtn() {
        driver.findElement(deleteCustomerBtn).click();
    }
    public void clickNewAccountBtn() {
        driver.findElement(newAccountBtn).click();
    }
    public void clickEditAccountBtn() {
        driver.findElement(editAccountBtn).click();
    }
    public void clickDeleteAccountBtn() {
        driver.findElement(deleteAccountBtn).click();
    }
    public void clickDepositBtn() {
        driver.findElement(depositBtn).click();
    }
    public void clickWithdrawalBtn() {
        driver.findElement(withdrawalBtn).click();
    }
    public void clickFundTransferBtn() {
        driver.findElement(fundTransferBtn).click();
    }
    public void clickChangePasswordBtn() {
        driver.findElement(changePasswordBtn).click();
    }
    public void clickBalanceEnquiryBtn() {
        driver.findElement(balanceEnquiryBtn).click();
    }
    public void clickMiniStatementBtn() {
        driver.findElement(miniStatementBtn).click();
    }
    public void clickCustomisedStatementBtn() {
        driver.findElement(customisedStatementBtn).click();
    }
    public void clickLogoutBtn() {
        driver.findElement(logoutBtn).click();
    }
}
