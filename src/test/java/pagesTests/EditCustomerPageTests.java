package pagesTests;

import base.BaseTest;
import data.InvalidDataInputs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EditCustomerPage;

public class EditCustomerPageTests extends BaseTest {
    private EditCustomerPage editCustomerPage;

    @BeforeMethod
    public void openEditCustomerForm() {
        loginAsManager();
        managerHomePage.clickEditCustomerBtn()
                .enterCustomerIDField("61318")
                .clickSubmitBtn();

        editCustomerPage = new EditCustomerPage(driver)
                .saveInfo();
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

    @Test(dataProvider = "invalidAddressInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateAddressInput(String input, String expectedError) {
        editCustomerPage.enterAddressField(input);
        tab();

        String actualError = editCustomerPage.getTextAddressFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidCityInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateCityInput(String input, String expectedError) {
        editCustomerPage.enterCityField(input);
        tab();

        String actualError = editCustomerPage.getTextCityFieldErrorMessage();
        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidStateInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateStateInput(String input, String expectedError) {
        editCustomerPage.enterStateField(input);
        tab();

        String actualError = editCustomerPage.getTextStateFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidPINInputs", dataProviderClass = InvalidDataInputs.class)
    public void validatePINInput(String input, String expectedError) {
        editCustomerPage.enterPINField(input);
        tab();

        String actualError = editCustomerPage.getTextPINFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidMobileNumberInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateMobileNumberInput(String input, String expectedError) {
        editCustomerPage.enterMobileNumberField(input);
        tab();

        String actualError = editCustomerPage.getTextMobileNumberFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidEmailInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateEmailInput(String input, String expectedError) {
        editCustomerPage.enterEmailField(input);
        tab();

        String actualError = editCustomerPage.getTextEmailFieldErrorMessage();

        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    // Reset button works
    @Test
    public void resetButtonResetsFields() {
        editCustomerPage.enterAddressField("")
                        .enterCityField("")
                        .enterStateField("")
                        .enterPINField("")
                        .enterMobileNumberField("")
                        .enterEmailField("");

        editCustomerPage.clickResetBtn();

        soft.assertTrue(editCustomerPage.isResetSuccessful());
    }
}
