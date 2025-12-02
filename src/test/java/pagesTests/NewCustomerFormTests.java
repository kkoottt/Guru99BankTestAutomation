package pagesTests;

import base.BaseTest;
import data.NewCustomerFormTestsData;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.NewCustomerForm;

public class NewCustomerFormTests extends BaseTest {
    private SoftAssert soft;

    @BeforeMethod
    public void openNewCustomerForm() {
        loginAsManager();
        managerHomePage.clickNewCustomerBtn();
        newCustomerForm = new NewCustomerForm(driver);
        soft = new SoftAssert();
    }

    @Test(dataProvider = "invalidCustomerNameInputs", dataProviderClass = NewCustomerFormTestsData.class)
    public void validateCustomerNameInput(String input, String expectedError) {
        newCustomerForm.enterCustomerNameField(input);
        tab();

        String actualError = newCustomerForm.getTextCustomerNameFieldError();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }



    @Test(dataProvider = "invalidAddressInputs", dataProviderClass = NewCustomerFormTestsData.class)
    public void validateAddressInput(String input, String expectedError) {
        newCustomerForm.enterAddressField(input);
        tab();

        String actualError = newCustomerForm.getTextAddressFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }



    @Test(dataProvider = "invalidCityInputs", dataProviderClass = NewCustomerFormTestsData.class)
    public void validateCityInput(String input, String expectedError) {
        newCustomerForm.enterCityField(input);
        tab();

        String actualError = newCustomerForm.getTextCityFieldErrorMessage();
        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }



    @Test(dataProvider = "invalidStateInputs", dataProviderClass = NewCustomerFormTestsData.class)
    public void validateStateInput(String input, String expectedError) {
        newCustomerForm.enterStateField(input);
        tab();

        String actualError = newCustomerForm.getTextStateFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }



    @Test(dataProvider = "invalidPINInputs", dataProviderClass = NewCustomerFormTestsData.class)
    public void validatePINInput(String input, String expectedError) {
        newCustomerForm.enterPINField(input);
        tab();

        String actualError = newCustomerForm.getTextPINFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }



    @Test(dataProvider = "invalidMobileNumberInputs", dataProviderClass = NewCustomerFormTestsData.class)
    public void validateMobileNumberInput(String input, String expectedError) {
        newCustomerForm.enterMobileNumberField(input);
        tab();

        String actualError = newCustomerForm.getTextMobileNumberFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }



    @Test(dataProvider = "invalidEmailInputs", dataProviderClass = NewCustomerFormTestsData.class)
    public void validateEmailInput(String input, String expectedError) {
        newCustomerForm.enterEmailField(input);
        tab();
        newCustomerForm.enterPasswordField("");

        String actualError = newCustomerForm.getTextEmailFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test
    public void passwordCannotBeEmpty() {
        newCustomerForm.enterPasswordField("");
        tab();

        String actualError = newCustomerForm.getTextPasswordFieldErrorMessage();

        soft.assertEquals(actualError, "Password must not be blank");
    }

    @Test
    public void dateOfBirthCannotBeEmpty() {
        newCustomerForm.enterDateOfBirthField("");
        tab();

        String actualError = newCustomerForm.getTextDateOfBirthFieldErrorMessage();

        soft.assertEquals(actualError, "Date Field must not be blank");
        soft.assertAll();
    }

    @Test
    public void resetBtnClearsAllField() {
        newCustomerForm.enterCustomerNameField("Carlo");
        newCustomerForm.enterDateOfBirthField("01/01/1212");
        newCustomerForm.enterAddressField("Some address");
        newCustomerForm.enterCityField("MyCity");
        newCustomerForm.enterStateField("MyState");
        newCustomerForm.enterPINField("123123");
        newCustomerForm.enterMobileNumberField("123123123123");
        newCustomerForm.enterEmailField("carlo@mail.org");
        newCustomerForm.enterPasswordField("mypassword");

        newCustomerForm.clickResetBtn();

        String txtCustomerName = newCustomerForm.getTextCustomerNameField();
        String txtDateOfBirth = newCustomerForm.getTextDateOfBirthField();
        String txtAddress = newCustomerForm.getTextAddressField();
        String txtCity = newCustomerForm.getTextCityField();
        String txtState = newCustomerForm.getTextStateField();
        String txtPIN = newCustomerForm.getTextPINField();
        String txtMobileNumber = newCustomerForm.getTextMobileNumberField();
        String txtEmail = newCustomerForm.getTextEmailField();
        String txtPassword = newCustomerForm.getTextPasswordField();

        soft.assertEquals(txtCustomerName,"");
        soft.assertEquals(txtDateOfBirth,"");
        soft.assertEquals(txtAddress,"");
        soft.assertEquals(txtCity,"");
        soft.assertEquals(txtState,"");
        soft.assertEquals(txtPIN,"");
        soft.assertEquals(txtMobileNumber,"");
        soft.assertEquals(txtEmail,"");
        soft.assertEquals(txtPassword,"");
        soft.assertAll();
    }
}
