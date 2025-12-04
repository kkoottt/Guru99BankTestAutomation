package pagesTests;

import base.BaseTest;
import data.InvalidCustomerDataInputs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NewCustomerForm;

public class NewCustomerFormTests extends BaseTest {
    protected NewCustomerForm newCustomerForm;

    @BeforeMethod
    public void openNewCustomerForm() {
        loginAsManager();
        managerHomePage.clickNewCustomerBtn();
        newCustomerForm = new NewCustomerForm(driver);
    }

    @Test(dataProvider = "invalidCustomerNameInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateCustomerNameInput(String input, String expectedError) {
        newCustomerForm.enterCustomerNameField(input);
        tab();

        String actualError = newCustomerForm.getTextCustomerNameFieldError();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidAddressInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateAddressInput(String input, String expectedError) {
        newCustomerForm.enterAddressField(input);
        tab();

        String actualError = newCustomerForm.getTextAddressFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidCityInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateCityInput(String input, String expectedError) {
        newCustomerForm.enterCityField(input);
        tab();

        String actualError = newCustomerForm.getTextCityFieldErrorMessage();
        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidStateInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateStateInput(String input, String expectedError) {
        newCustomerForm.enterStateField(input);
        tab();

        String actualError = newCustomerForm.getTextStateFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidPINInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validatePINInput(String input, String expectedError) {
        newCustomerForm.enterPINField(input);
        tab();

        String actualError = newCustomerForm.getTextPINFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidMobileNumberInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateMobileNumberInput(String input, String expectedError) {
        newCustomerForm.enterMobileNumberField(input);
        tab();

        String actualError = newCustomerForm.getTextMobileNumberFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidEmailInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateEmailInput(String input, String expectedError) {
        newCustomerForm.enterEmailField(input);
        tab();

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
        newCustomerForm.enterCustomerNameField("Carlo")
                .enterDateOfBirthField("01/01/1212")
                .enterAddressField("Some address")
                .enterCityField("MyCity")
                .enterStateField("MyState")
                .enterPINField("123123")
                .enterMobileNumberField("123123123123")
                .enterEmailField("carlo@mail.org")
                .enterPasswordField("mypassword")
                .clickResetBtn();

        soft.assertTrue(newCustomerForm.areAllFieldsCleared());
        soft.assertAll();
    }
}
