package pagesTests;

import base.BaseTest;
import data.InvalidDataInputs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MiniStatementForm;

public class ManagerMiniStatementFormTests extends BaseTest {

    MiniStatementForm miniStatementForm;

    @BeforeMethod
    public void openMiniStatementForm() {
        loginAsManager();
        managerHomePage.clickMiniStatementBtn();
        miniStatementForm = new MiniStatementForm(driver);
    }

    @Test(dataProvider = "invalidAccountNumberInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateAccountNumberInput(String input, String expectedError) {
        miniStatementForm.enterAccountNumberField(input);
        tab();

        String actualError = miniStatementForm.getTextAccountNumberFieldErrorMessage();
        soft.assertEquals(actualError, expectedError);
    }

    @Test
    public void resetBtnClearsAllField() {
        miniStatementForm.enterAccountNumberField("123123123")
                .clickResetBtn();

        String customerNumber = miniStatementForm.getTextAccountNumberField();
        soft.assertEquals(customerNumber, "");
    }
}
