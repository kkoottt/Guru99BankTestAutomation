package pagesTests;

import base.BaseTest;
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

    @DataProvider(name = "invalidAccountNumberInputs")
    public Object[][] invalidAccountNumberInputs() {
        return new Object[][] {
                {"", "Account Number must not be blank"},
                {"@123123", "Special characters are not allowed"},
                {"!@#", "Special characters are not allowed"},
                {"123#123", "Special characters are not allowed"},
                {"123123!", "Special characters are not allowed"},
                {"Accountnumber", "Characters are not allowed"},
                {"number123", "Characters are not allowed"},
                {"123number", "Characters are not allowed"},
                {" ", "First character can not have space"},
                {" 123123", "First character can not have space"}
        };
    }

    @Test(dataProvider = "invalidAccountNumberInputs")
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
