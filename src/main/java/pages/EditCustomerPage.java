package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomerPage extends EditCustomerForm {

    // Locators
    // Text Input Fields
    private final By customerNameField = By.xpath("//input[@type='text' and @name='name']");
    private final By genderField = By.xpath("//input[@type='text' and @name='gender']");
    private final By dateOfBirthField = By.xpath("//input[@type='text' and @name='dob']");
    private final By addressField = By.xpath("//textarea[@name='addr']");
    private final By cityField = By.xpath("//input[@type='text' and @name='city']");
    private final By stateField = By.xpath("//input[@type='text' and @name='state']");
    private final By PINField = By.xpath("//input[@type='text' and @name='pinno']");
    private final By mobileNumberField = By.xpath("//input[@type='text' and @name='telephone']");
    private final By emailField = By.xpath("//input[@type='text' and @name='emailid']");
    // Error Messages
    private final By addressFieldErrorMessage = By.xpath("//label[@id='message3']");
    private final By cityFieldErrorMessage = By.xpath("//label[@id='message4']");
    private final By stateFieldErrorMessage = By.xpath("//label[@id='message5']");
    private final By PINFieldErrorMessage = By.xpath("//label[@id='message6']");
    private final By mobileNumberFieldErrorMessage = By.xpath("//label[@id='message7']");
    private final By emailFieldErrorMessage = By.xpath("//label[@id='message9']");
    // Buttons
    private final By submitBtn = By.xpath("//input[@type='submit']");
    private final By resetBtn = By.xpath("//input[@type='reset']");

    // Constructors
    public EditCustomerPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public boolean isCustomerNameFieldDisabled() {
        return isDisabled(customerNameField);
    }

    public boolean isGenderFieldDisabled() {
        return isDisabled(genderField);
    }

    public boolean isDateOfBirthFieldDisabled() {
        return isDisabled(dateOfBirthField);
    }

    public void enterAddressField(String input) {
        driver.findElement(addressField).sendKeys(input);
    }

    public void enterCityField(String input) {
        driver.findElement(cityField).sendKeys(input);
    }

    public void enterStateField(String input) {
        driver.findElement(stateField).sendKeys(input);
    }

    public void enterPINField(String input) {
        driver.findElement(PINField).sendKeys(input);
    }

    public void enterMobileNumberField(String input) {
        driver.findElement(mobileNumberField).sendKeys(input);
    }

    public void enterEmailField(String input) {
        driver.findElement(emailField).sendKeys(input);
    }

    public String getTextAddressField() {
        return driver.findElement(addressField).getText();
    }

    public String getTextCityField() {
        return driver.findElement(cityField).getText();
    }

    public String getTextStateField() {
        return driver.findElement(stateField).getText();
    }

    public String getTextPINField() {
        return driver.findElement(PINField).getText();
    }

    public String getTextMobileNumberField() {
        return driver.findElement(mobileNumberField).getText();
    }

    public String getTextEmailField() {
        return driver.findElement(emailField).getText();
    }

    public String getTextAddressFieldErrorMessage() {
        return waitError(addressFieldErrorMessage);
    }

    public String getTextCityFieldErrorMessage() {
        return waitError(cityFieldErrorMessage);
    }

    public String getTextStateFieldErrorMessage() {
        return waitError(stateFieldErrorMessage);
    }

    public String getTextPINFieldErrorMessage() {
        return waitError(PINFieldErrorMessage);
    }

    public String getTextMobileNumberFieldErrorMessage() {
        return waitError(mobileNumberFieldErrorMessage);
    }

    public String getTextEmailFieldErrorMessage() {
        return waitError(emailFieldErrorMessage);
    }
}
