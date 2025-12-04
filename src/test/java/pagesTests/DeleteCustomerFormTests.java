package pagesTests;

import base.BaseTest;
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

    @DataProvider(name = "invalidCustomerIDInputs")
    public Object[][] invalidCustomerIDInputs() {
        return new Object[][] {
                {"", "Customer ID must not be blank"},
                {"@123123", "Special characters are not allowed"},
                {"!@#", "Special characters are not allowed"},
                {"123#123", "Special characters are not allowed"},
                {"123123!", "Special characters are not allowed"},
                {"CustomerID", "Characters are not allowed"},
                {"ID123", "Characters are not allowed"},
                {"123ID", "Characters are not allowed"},
                {" ", "First character can not have space"},
                {" 123123", "First character can not have space"}
        };
    }

    @Test(dataProvider = "invalidCustomerIDInputs")
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
