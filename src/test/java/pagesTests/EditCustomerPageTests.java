package pagesTests;

import base.BaseTest;
import data.InvalidCustomerDataInputs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EditCustomerForm;
import pages.EditCustomerPage;

public class EditCustomerPageTests extends BaseTest {
    private EditCustomerPage editCustomerPage;

    @BeforeMethod
    public void openEditCustomerForm() {
        // login as manager
        loginAsManager();
        // click edit customer
        managerHomePage.clickEditCustomerBtn();
        EditCustomerForm editCustomerForm = new EditCustomerForm(driver);
        // enter customer in form
        editCustomerForm.enterCustomerIDField("61318");
        editCustomerForm.clickSubmitBtn();
        editCustomerPage = new EditCustomerPage(driver);
    }

    // validate fields in page
    @Test
    public void customerNameCannotBeEdited() {
        soft.assertTrue(editCustomerPage.isCustomerNameFieldDisabled());
        soft.assertAll();
    }

    @Test
    public void genderCannotBeEdited() {
        soft.assertTrue(editCustomerPage.isGenderFieldDisabled());
        soft.assertAll();
    }

    @Test
    public void dateOfBirthCannotBeEdited() {
        soft.assertTrue(editCustomerPage.isDateOfBirthFieldDisabled());
        soft.assertAll();
    }

    @Test(dataProvider = "invalidAddressInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateAddressInput(String input, String expectedError) {
        editCustomerPage.enterAddressField(input);
        tab();

        String actualError = editCustomerPage.getTextAddressFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidCityInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateCityInput(String input, String expectedError) {
        editCustomerPage.enterCityField(input);
        tab();

        String actualError = editCustomerPage.getTextCityFieldErrorMessage();
        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidStateInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateStateInput(String input, String expectedError) {
        editCustomerPage.enterStateField(input);
        tab();

        String actualError = editCustomerPage.getTextStateFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidPINInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validatePINInput(String input, String expectedError) {
        editCustomerPage.enterPINField(input);
        tab();

        String actualError = editCustomerPage.getTextPINFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidMobileNumberInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateMobileNumberInput(String input, String expectedError) {
        editCustomerPage.enterMobileNumberField(input);
        tab();

        String actualError = editCustomerPage.getTextMobileNumberFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidEmailInputs", dataProviderClass = InvalidCustomerDataInputs.class)
    public void validateEmailInput(String input, String expectedError) {
        editCustomerPage.enterEmailField(input);
        tab();

        String actualError = editCustomerPage.getTextEmailFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }
}
