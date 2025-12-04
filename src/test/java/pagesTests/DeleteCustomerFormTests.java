package pagesTests;

import base.BaseTest;
import data.InvalidDataInputs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DeleteCustomerForm;

public class DeleteCustomerFormTests extends BaseTest {
    private DeleteCustomerForm deleteCustomerForm;
    @BeforeMethod
    public void openEditCustomerForm() {
        loginAsManager();
        managerHomePage.clickDeleteCustomerBtn();
        deleteCustomerForm = new DeleteCustomerForm(driver);
    }

    @Test(dataProvider = "invalidCustomerIDInputs", dataProviderClass = InvalidDataInputs.class)
    public void validateCustomerIDInput(String input, String expectedResult) {
        deleteCustomerForm.enterCustomerIDField(input);
        tab();

        String actualResult = deleteCustomerForm.getTextCustomerIDFieldErrorMessage();
        soft.assertEquals(actualResult, expectedResult);
        soft.assertAll();
    }

    @Test
    public void resetBtnClearsAllField() {
        deleteCustomerForm.enterCustomerIDField("123123123")
                .clickResetBtn();

        String CustomerID = deleteCustomerForm.getTextCustomerIDField();
        soft.assertEquals(CustomerID, "");
    }
}
