package pagesTests;

import base.BaseTest;
import data.InvalidDataInputs;
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

    @Test(dataProvider = "invalidAccountNumberInputs", dataProviderClass = InvalidDataInputs.class)
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
