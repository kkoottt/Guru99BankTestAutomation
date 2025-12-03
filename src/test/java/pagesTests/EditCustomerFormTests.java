package pagesTests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EditCustomerForm;

public class EditCustomerFormTests extends BaseTest {

    @BeforeMethod
    public void openEditCustomerForm() {
        loginAsManager();
        managerHomePage.clickEditCustomerBtn();
        editCustomerForm = new EditCustomerForm(driver);
    }

    @DataProvider(name = "invalidCustomerIdInputs")
    public Object[][] invalidCustomerIdInputs() {
        return new Object[][] {
            {"", "Customer ID is required"},
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

    @Test(dataProvider = "invalidCustomerIdInputs")
    public void validateCustomerIDInput(String input, String expectedResult) {
        editCustomerForm.enterCustomerIDField(input);
        tab();

        String actualResult = editCustomerForm.getTextCustomerIDFieldErrorMessage();
        soft.assertEquals(actualResult, expectedResult);
        soft.assertAll();
    }
}
