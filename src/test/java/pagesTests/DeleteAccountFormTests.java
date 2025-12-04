package pagesTests;

import base.BaseTest;
import data.InvalidDataInputs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DeleteAccountForm;
import pages.DeleteCustomerForm;
import pages.EditAccountForm;

public class DeleteAccountFormTests extends BaseTest {
    private DeleteAccountForm deleteAccountForm;
    @BeforeMethod
    public void openEditAccountForm() {
        loginAsManager();
        managerHomePage.clickDeleteAccountBtn();
        deleteAccountForm = new DeleteAccountForm(driver);
    }

    @Test(dataProvider = "invalidAccountNumberInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateAccountNumberInput(String input, String expectedResult) {
        deleteAccountForm.enterAccountNumberField(input);
        tab();

        String actualResult = deleteAccountForm.getTextAccountNumberFieldErrorMessage();
        soft.assertEquals(actualResult, expectedResult);
        soft.assertAll();
    }

    @Test
    public void resetBtnClearsAllField() {
        deleteAccountForm.enterAccountNumberField("123123123")
                .clickResetBtn();

        String accountNumber = deleteAccountForm.getTextAccountNumberField();
        soft.assertEquals(accountNumber, "");
    }
}
