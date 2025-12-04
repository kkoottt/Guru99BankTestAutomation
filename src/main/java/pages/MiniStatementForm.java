package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MiniStatementForm extends BasePage {

    // Locator
    private final By accountNumberField = By.xpath("//input[@type='text']");
    private final By accountNumberFieldErrorMessage = By.xpath("//label[@id='message2']");

    // Constructor
    public MiniStatementForm(WebDriver driver) {
        super(driver);
    }

    // Actions
    public MiniStatementForm enterAccountNumberField(String input) {
        waitElement(accountNumberField).sendKeys(input);
        return this;
    }

    public String getTextAccountNumberField() {
        return waitElement(accountNumberField).getAttribute("value");
    }

    public String getTextAccountNumberFieldErrorMessage() {
        return waitThenGetError(accountNumberFieldErrorMessage);
    }

    public void clickResetBtn() {
        driver.findElement(resetBtn).click();
    }

}
