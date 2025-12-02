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
    private final By submitBtn = By.xpath("//input[@type='submit']");
    private final By resetBtn = By.xpath("//input[@type='reset']");
    // Constructor
    public NewCustomerForm(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void enterCustomerNameField(String customerName) {
        WebElement tfCustName = driver.findElement(customerNameField);
        tfCustName.clear();
        tfCustName.sendKeys(customerName);
    }

    public void selectMaleRadioBtn() {
        WebElement rbMale = driver.findElement(maleRadioBtn);
        if (!rbMale.isSelected()) {
            rbMale.click();
        }
    }

    public void selectFemaleRadioBtn() {
        WebElement rbFemale = driver.findElement(femaleRadioBtn);
        if (!rbFemale.isSelected()) {
            rbFemale.click();
        }
    }

    public void enterDateOfBirthField(String input) {
        driver.findElement(dateOfBirthField).sendKeys(input);
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

    public void enterPasswordField(String input) {
        driver.findElement(passwordField).sendKeys(input);
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
        return wait(customerNameFieldError,1);
    }

    public String getTextDateOfBirthFieldErrorMessage() {
        return wait(dateOfBirthFieldErrorMessage,1);
    }

    public String getTextAddressFieldErrorMessage() {
        return wait(addressFieldErrorMessage,1);
    }

    public String getTextCityFieldErrorMessage() {
        return wait(cityFieldErrorMessage,1);
    }

    public String getTextStateFieldErrorMessage() {
        return wait(stateFieldErrorMessage,1);
    }

    public String getTextPINFieldErrorMessage() {
        return wait(PINFieldErrorMessage,1);
    }

    public String getTextMobileNumberFieldErrorMessage() {
        return wait(mobileNumberFieldErrorMessage,1);
    }

    public String getTextEmailFieldErrorMessage() {
        return wait(emailFieldErrorMessage,1);
    }

    public String getTextPasswordFieldErrorMessage() {
        return wait(passwordFieldErrorMessage,1);
    }

    public void clickSubmitBtn() {
        driver.findElement(submitBtn).click();
    }

    public void clickResetBtn() {
        driver.findElement(resetBtn).click();
    }
}
