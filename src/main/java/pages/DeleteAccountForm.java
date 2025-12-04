package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccountForm extends BasePage {
    // Selectors
    private final By accountNumberField = By.xpath("//input[@type='text']");
    private final By accountNumberFieldErrorMessage = By.xpath("//label[@id='message2']");

    // Constructor
    public DeleteAccountForm(WebDriver driver) {
        super(driver);
    }

    // Actions
    public DeleteAccountForm enterAccountNumberField(String input) {
        waitElement(accountNumberField).sendKeys(input);
        return this;
    }

    public String getTextAccountNumberField() {
        return driver.findElement(accountNumberField).getAttribute("value");
    }

    public String getTextAccountNumberFieldErrorMessage() {
        return waitThenGetError(accountNumberFieldErrorMessage);
    }

    public void clickSubmitBtn() {
        click(submitBtn);
    }

    public void clickResetBtn() {
        click(resetBtn);
    }
}
