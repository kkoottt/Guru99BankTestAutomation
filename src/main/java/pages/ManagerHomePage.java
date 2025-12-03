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
        click(newCustomerBtn);
    }
    public EditCustomerForm clickEditCustomerBtn() {
        click(editCustomerBtn);
        return new EditCustomerForm(driver);
    }
    public void clickDeleteCustomerBtn() {
        click(deleteCustomerBtn);
    }
    public void clickNewAccountBtn() {
        click(newAccountBtn);
    }
    public void clickEditAccountBtn() {
        click(editAccountBtn);
    }
    public void clickDeleteAccountBtn() {
        click(deleteAccountBtn);
    }
    public void clickDepositBtn() {
        click(depositBtn);
    }
    public void clickWithdrawalBtn() {
        click(withdrawalBtn);
    }
    public void clickFundTransferBtn() {
        click(fundTransferBtn);
    }
    public void clickChangePasswordBtn() {
        click(changePasswordBtn);
    }
    public void clickBalanceEnquiryBtn() {
        click(balanceEnquiryBtn);
    }
    public void clickMiniStatementBtn() {
        click(miniStatementBtn);
    }
    public void clickCustomisedStatementBtn() {
        click(customisedStatementBtn);
    }
    public void clickLogoutBtn() {
        click(logoutBtn);
    }
}
