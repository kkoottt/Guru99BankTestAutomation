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
    private final By mobileNumberField = By.xpath("//input[@type='text' and @name='telephoneno']");
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
    private String address, city, state, PIN, mobileNumber, email;
    public EditCustomerPage saveInfo() {
        this.address = getTextAddressField();
        this.city = getTextCityField();
        this.state = getTextStateField();
        this.PIN = getTextPINField();
        this.mobileNumber = getTextMobileNumberField();
        this.email = getTextEmailField();

        return this;
    }

    public boolean isResetSuccessful() {
        return address.equals(getTextAddressField()) &&
                city.equals(getTextCityField()) &&
                state.equals(getTextStateField()) &&
                PIN.equals(getTextPINField()) &&
                mobileNumber.equals(getTextMobileNumberField()) &&
                email.equals(getTextEmailField());
    }

    public boolean isCustomerNameFieldDisabled() {
        return isDisabled(customerNameField);
    }

    public boolean isGenderFieldDisabled() {
        return isDisabled(genderField);
    }

    public boolean isDateOfBirthFieldDisabled() {
        return isDisabled(dateOfBirthField);
    }

    public EditCustomerPage enterAddressField(String input) {
        waitElement(addressField).clear();
        driver.findElement(addressField).sendKeys(input);

        return this;
    }

    public EditCustomerPage enterCityField(String input) {
        waitElement(cityField).clear();
        driver.findElement(cityField).sendKeys(input);

        return this;
    }

    public EditCustomerPage enterStateField(String input) {
        waitElement(stateField).clear();
        driver.findElement(stateField).sendKeys(input);

        return this;
    }

    public EditCustomerPage enterPINField(String input) {
        waitElement(PINField).clear();
        driver.findElement(PINField).sendKeys(input);

        return this;
    }

    public EditCustomerPage enterMobileNumberField(String input) {
        waitElement(mobileNumberField).clear();
        driver.findElement(mobileNumberField).sendKeys(input);

        return this;
    }

    public EditCustomerPage enterEmailField(String input) {
        waitElement(emailField).clear();
        driver.findElement(emailField).sendKeys(input);

        return this;
    }

    public String getTextAddressField() {
        return driver.findElement(addressField).getAttribute("value");
    }

    public String getTextCityField() {
        return driver.findElement(cityField).getAttribute("value");
    }

    public String getTextStateField() {
        return driver.findElement(stateField).getAttribute("value");
    }

    public String getTextPINField() {
        return driver.findElement(PINField).getAttribute("value");
    }

    public String getTextMobileNumberField() {
        return driver.findElement(mobileNumberField).getAttribute("value");
    }

    public String getTextEmailField() {
        return driver.findElement(emailField).getAttribute("value");
    }

    public String getTextAddressFieldErrorMessage() {
        return waitThenGetError(addressFieldErrorMessage);
    }

    public String getTextCityFieldErrorMessage() {
        return waitThenGetError(cityFieldErrorMessage);
    }

    public String getTextStateFieldErrorMessage() {
        return waitThenGetError(stateFieldErrorMessage);
    }

    public String getTextPINFieldErrorMessage() {
        return waitThenGetError(PINFieldErrorMessage);
    }

    public String getTextMobileNumberFieldErrorMessage() {
        return waitThenGetError(mobileNumberFieldErrorMessage);
    }

    public String getTextEmailFieldErrorMessage() {
        return waitThenGetError(emailFieldErrorMessage);
    }

    public void clickSubmitBtn() {
        driver.findElement(submitBtn).click();
    }

    public void clickResetBtn() {
        driver.findElement(resetBtn).click();
    }
}
