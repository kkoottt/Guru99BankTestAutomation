package pagesTests;

import base.BaseTest;
import data.InvalidDataInputs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EditCustomerForm;

public class EditCustomerFormTests extends BaseTest {
    private EditCustomerForm editCustomerForm;
    @BeforeMethod
    public void openEditCustomerForm() {
        loginAsManager();
        managerHomePage.clickEditCustomerBtn();
        editCustomerForm = new EditCustomerForm(driver);
    }

    @Test(dataProvider = "invalidCustomerIDInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateCustomerIDInput(String input, String expectedResult) {
        editCustomerForm.enterCustomerIDField(input);
        tab();

        String actualResult = editCustomerForm.getTextCustomerIDFieldErrorMessage();
        soft.assertEquals(actualResult, expectedResult);
        soft.assertAll();
    }

    @Test
    public void resetBtnClearsAllField() {
        editCustomerForm.enterCustomerIDField("123123123")
                .clickResetBtn();

        String customerID = editCustomerForm.getTextCustomerIDField();
        soft.assertEquals(customerID, "");
    }
}
