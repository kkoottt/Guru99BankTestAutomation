package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomerForm extends ManagerHomePage {
    // Selectors
    private final By customerIDField = By.xpath("//input[@type='text']");
    private final By customerIDFieldErrorMessage = By.xpath("//label[@id='message14']");
    private final By submitBtn = By.xpath("//input[@type='submit']");
    private final By resetBtn = By.xpath("//input[@type='reset']");

    // Constructor
    public EditCustomerForm(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void enterCustomerIDField(String input) {
        waitElement(customerIDField).sendKeys(input);
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
