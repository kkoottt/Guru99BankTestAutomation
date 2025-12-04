package pagesTests;

import base.BaseTest;
import data.invalidAccountDataInputs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "invalidCustomerIDInputs", dataProviderClass = invalidAccountDataInputs.class)
    public void validateCustomerIDInput(String input, String expectedError) {
        newAccountForm.enterCustomerIDField(input);
        tab();

        String actualError = newAccountForm.getTextCustomerIDFieldErrorMessage();
        soft.assertEquals(actualError, expectedError);
        soft.assertAll();
    }

    @Test(dataProvider = "invalidInitialDepositInputs", dataProviderClass = invalidAccountDataInputs.class)
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
