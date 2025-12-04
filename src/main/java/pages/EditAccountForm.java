package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountForm extends BasePage {
    // Selectors
    private final By accountNumberField = By.xpath("//input[@type='text']");
    private final By accountNumberFieldErrorMessage = By.xpath("//label[@id='message2']");
    private final By submitBtn = By.xpath("//input[@type='submit']");
    private final By resetBtn = By.xpath("//input[@type='reset']");

    // Constructor
    public EditAccountForm(WebDriver driver) {
        super(driver);
    }

    // Actions
    public EditAccountForm enterAccountNumberField(String input) {
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
