package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerHomePage extends BasePage {

    // Constructor
    public CustomerHomePage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void clickBalanceEnquiry() {
        driver.findElement(balanceEnquiryBtn).click();
    }

    public void clickFundTransfer() {
        driver.findElement(fundTransferBtn).click();
    }

    public void clickChangePassword() {
        driver.findElement(changePasswordBtn).click();
    }

    public void clickMiniStatement() {
        driver.findElement(miniStatementBtn).click();
    }

    public void clickCustomisedStatement() {
        driver.findElement(customisedStatementBtn).click();
    }

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
}
