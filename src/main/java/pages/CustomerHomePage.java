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
        click(balanceEnquiryBtn);
    }

    public void clickFundTransfer() {
        click(fundTransferBtn);
    }

    public void clickChangePassword() {
        click(changePasswordBtn);
    }

    public void clickMiniStatement() {
        click(miniStatementBtn);
    }

    public void clickCustomisedStatement() {
        click(customisedStatementBtn);
    }

    public void clickLogout() {
        click(logoutBtn);
    }
}
