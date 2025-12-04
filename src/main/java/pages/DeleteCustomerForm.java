package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCustomerForm extends BasePage {
    // Selectors
    private final By customerIDField = By.xpath("//input[@type='text']");
    private final By customerIDFieldErrorMessage = By.xpath("//label[@id='message14']");

    // Constructor
    public DeleteCustomerForm(WebDriver driver) {
        super(driver);
    }

    // Actions
    public DeleteCustomerForm enterCustomerIDField(String input) {
        waitElement(customerIDField).sendKeys(input);
        return this;
    }

    public String getTextCustomerIDField() {
        return driver.findElement(customerIDField).getAttribute("value");
    }

    public String getTextCustomerIDFieldErrorMessage() {
        return waitThenGetError(customerIDFieldErrorMessage);
    }

    public void clickSubmitBtn() {
        click(submitBtn);
    }

    public void clickResetBtn() {
        click(resetBtn);
    }
}
