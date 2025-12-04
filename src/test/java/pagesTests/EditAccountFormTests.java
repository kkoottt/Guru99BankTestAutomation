package pagesTests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EditAccountForm;

public class EditAccountFormTests extends BaseTest {
    private EditAccountForm editAccountForm;
    @BeforeMethod
    public void openEditAccountForm() {
        loginAsManager();
        managerHomePage.clickEditAccountBtn();
        editAccountForm = new EditAccountForm(driver);
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
        editAccountForm.enterAccountNumberField(input);
        tab();

        String actualResult = editAccountForm.getTextAccountNumberFieldErrorMessage();
        soft.assertEquals(actualResult, expectedResult);
        soft.assertAll();
    }

    @Test
    public void resetBtnClearsAllField() {
        editAccountForm.enterAccountNumberField("123123123")
                .clickResetBtn();

        String accountNumber = editAccountForm.getTextAccountNumberField();
        soft.assertEquals(accountNumber, "");
    }
}
