package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountForm extends ManagerHomePage{
    // Locators
    private final By customerIDField = By.xpath("//input[@type='text' and @name='cusid']");
    private final By accountTypeField = By.xpath("//select[@name='selaccount']");
    private final By initialDepositField = By.xpath("//input[@type='text' and @name='inideposit']");
    private final By customerIDFieldErrorMessage = By.xpath("//label[@id='message14']");
    private final By initialDepositFieldErrorMessage = By.xpath("//label[@id='message19']");

    // Constructor
    public NewAccountForm(WebDriver driver) {
        super(driver);
    }

    // Actions
    public NewAccountForm enterCustomerIDField(String input) {
        waitElement(customerIDField).sendKeys(input);
        return this;
    }

    public NewAccountForm selectAccountType(String input) {
        Select select = new Select(waitElement(accountTypeField));
        select.selectByVisibleText(input);
        return this;
    }

    public NewAccountForm enterInitialDepositField(String input) {
        waitElement(initialDepositField).sendKeys(input);
        return this;
    }

    public String getTextCustomerIDField() {
        return waitElement(customerIDField).getAttribute("value");
    }

    public String getSelectedAccountType() {
        Select select = new Select(waitElement(accountTypeField));
        return select.getFirstSelectedOption().getText();
    }

    public String getTextInitialDepositField() {
        return waitElement(initialDepositField).getAttribute("value");
    }

    public String getTextCustomerIDFieldErrorMessage() {
        return waitThenGetError(customerIDFieldErrorMessage);
    }

    public String getTextInitialDepositFieldErrorMessage() {
        return waitThenGetError(initialDepositFieldErrorMessage);
    }

    public void clickSubmitBtn() {
        click(submitBtn);
    }

    public NewAccountForm clickResetBtn() {
        click(resetBtn);
        return this;
    }

    public String getAccountFirstOption() {
        return getFirstOption(accountTypeField);
    }

    public Boolean areAllFieldsCleared() {
        return getTextCustomerIDField().isEmpty() &&
                getSelectedAccountType().equals(getAccountFirstOption()) &&
                getTextInitialDepositField().isEmpty();
    }
}
