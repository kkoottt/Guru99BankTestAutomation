package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCustomerForm extends ManagerHomePage{

    // Locators
    private final By customerNameField = By.xpath("//body/table[@class='layout']/tbody/tr/td[@colspan='2']/table[@border='0']/tbody/tr[4]/td[2]/input[1]");
    private final By maleRadioBtn = By.xpath("//body/table[@class='layout']/tbody/tr/td[@colspan='2']/table[@border='0']/tbody/tr[5]/td[2]/input[1]");
    private final By femaleRadioBtn = By.xpath("//body/table[@class='layout']/tbody/tr/td[@colspan='2']/table[@border='0']/tbody/tr[5]/td[2]/input[2]");
    private final By dateOfBirthField = By.xpath("//input[@id='dob']");
    private final By addressField = By.xpath("//textarea[@rows='5']");
    private final By cityField = By.xpath("//body/table[@class='layout']/tbody/tr/td[@colspan='2']/table[@border='0']/tbody/tr[8]/td[2]/input[1]");
    private final By stateField = By.xpath("//body/table[@class='layout']/tbody/tr/td[@colspan='2']/table[@border='0']/tbody/tr[8]/td[2]/input[1]");
    private final By PINField = By.xpath("//body/table[@class='layout']/tbody/tr/td[@colspan='2']/table[@border='0']/tbody/tr[8]/td[2]/input[1]");
    private final By mobileNumberField = By.xpath("//body/table[@class='layout']/tbody/tr/td[@colspan='2']/table[@border='0']/tbody/tr[8]/td[2]/input[1]");
    private final By emailField = By.xpath("//input[@name='emailid']");
    private final By passwordField = By.xpath("//input[@type='password']");
    private final By customerNameFieldError = By.xpath("//label[@id='message']");
    private final By dateOfBirthFieldErrorMessage = By.xpath("//label[@id='message24']");
    private final By addressFieldErrorMessage = By.xpath("//label[@id='message3']");
    private final By cityFieldErrorMessage = By.xpath("//label[@id='message4']");
    private final By stateFieldErrorMessage = By.xpath("//label[@id='message5']");
    private final By PINFieldErrorMessage = By.xpath("//label[@id='message6']");
    private final By mobileNumberFieldErrorMessage = By.xpath("//label[@id='message7']");
    private final By emailFieldErrorMessage = By.xpath("//label[@id='message9']");
    private final By passwordFieldErrorMessage = By.xpath("//label[@id='message18']");

    // Constructor
    public NewCustomerForm(WebDriver driver) {
        super(driver);
    }

    // Actions
    public NewCustomerForm enterCustomerNameField(String customerName) {
        waitElement(customerNameField).clear();
        driver.findElement(customerNameField).sendKeys(customerName);

        return this;
    }

    public NewCustomerForm selectMaleRadioBtn() {
        WebElement rbMale = driver.findElement(maleRadioBtn);
        if (!rbMale.isSelected()) {
            rbMale.click();
        }

        return this;
    }

    public NewCustomerForm selectFemaleRadioBtn() {
        WebElement rbFemale = driver.findElement(femaleRadioBtn);
        if (!rbFemale.isSelected()) {
            rbFemale.click();
        }

        return this;
    }

    public NewCustomerForm enterDateOfBirthField(String input) {
        waitElement(dateOfBirthField).sendKeys(input);

        return this;
    }

    public NewCustomerForm enterAddressField(String input) {
        waitElement(addressField).sendKeys(input);

        return this;
    }

    public NewCustomerForm enterCityField(String input) {
        waitElement(cityField).sendKeys(input);

        return this;
    }

    public NewCustomerForm enterStateField(String input) {
        waitElement(stateField).sendKeys(input);

        return this;
    }

    public NewCustomerForm enterPINField(String input) {
        waitElement(PINField).sendKeys(input);

        return this;
    }

    public NewCustomerForm enterMobileNumberField(String input) {
        waitElement(mobileNumberField).sendKeys(input);

        return this;
    }

    public NewCustomerForm enterEmailField(String input) {
        waitElement(emailField).sendKeys(input);

        return this;
    }

    public NewCustomerForm enterPasswordField(String input) {
        waitElement(passwordField).sendKeys(input);

        return this;
    }

    public String getTextCustomerNameField() {
        return driver.findElement(customerNameField).getAttribute("value");
    }

    public String getTextMaleRadioBtn() {
        return driver.findElement(maleRadioBtn).getAttribute("value");
    }

    public String getTextDateOfBirthField() {
        return driver.findElement(dateOfBirthField).getAttribute("value");
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

    public String getTextPasswordField() {
        return driver.findElement(passwordField).getAttribute("value");
    }

    public String getTextCustomerNameFieldError() {
        return waitThenGetError(customerNameFieldError);
    }

    public String getTextDateOfBirthFieldErrorMessage() {
        return waitThenGetError(dateOfBirthFieldErrorMessage);
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

    public String getTextPasswordFieldErrorMessage() {
        return waitThenGetError(passwordFieldErrorMessage);
    }

    public void clickSubmitBtn() {
        click(submitBtn);
    }

    public NewCustomerForm clickResetBtn() {
        click(resetBtn);
        return this;
    }

    public boolean areAllFieldsCleared() {
        return getTextCustomerNameField().isEmpty() &&
                getTextDateOfBirthField().isEmpty() &&
                getTextAddressField().isEmpty() &&
                getTextCityField().isEmpty() &&
                getTextStateField().isEmpty() &&
                getTextPINField().isEmpty() &&
                getTextMobileNumberField().isEmpty() &&
                getTextEmailField().isEmpty() &&
                getTextPasswordField().isEmpty();
    }
}
