package pagesTests;

import base.BaseTest;
import data.InvalidDataInputs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NewAccountForm;

public class NewAccountFormTests extends BaseTest {
    private NewAccountForm newAccountForm;

    @BeforeMethod
    public void openNewAccountForm() {
        loginAsManager();
        managerHomePage.clickNewAccountBtn();
        newAccountForm = new NewAccountForm(driver);
    }

    @Test(dataProvider = "invalidCustomerIDInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateCustomerIDInput(String input, String expectedError) {
        newAccountForm.enterCustomerIDField(input);
        tab();

        String actualError = newAccountForm.getTextCustomerIDFieldErrorMessage();
        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidInitialDepositInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateInitialDepositInput(String input, String expectedError) {
        newAccountForm.enterInitialDepositField(input);
        tab();

        String actualError = newAccountForm.getTextInitialDepositFieldErrorMessage();
        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test
    public void resetBtnClearsAllField() {
        newAccountForm.enterCustomerIDField("123123")
                .selectAccountType("Current")
                .enterInitialDepositField("123")
                .clickResetBtn();

        soft.assertTrue(newAccountForm.areAllFieldsCleared());
        soft.assertAll();
    }
}
