package data;

import org.testng.annotations.DataProvider;

public class invalidAccountDataInputs {

    @DataProvider(name = "invalidCustomerIDInputs")
    public Object[][] invalidCustomerIDInputs() {
        return new Object[][]{
                {"", "Customer ID is required"},
                {"@123", "Special characters are not allowed"},
                {"!@#", "Special characters are not allowed"},
                {"123#123", "Special characters are not allowed"},
                {"123123!", "Special characters are not allowed"},
                {"customerid", "Characters are not allowed"},
                {"customerid123", "Characters are not allowed"},
                {"123customerid", "Characters are not allowed"},
                {" ", "First character can not have space"},
                {" 23456", "First character can not have space"}
        };
    }

    @DataProvider(name = "invalidInitialDepositInputs")
    public Object[][] invalidInitialDepositInputs() {
        return new Object[][] {
                {"", "Initial Deposit must not be blank"},
                {"@123", "Special characters are not allowed"},
                {"!@#", "Special characters are not allowed"},
                {"123#123", "Special characters are not allowed"},
                {"123123!", "Special characters are not allowed"},
                {"deposit", "Characters are not allowed"},
                {"deposit123", "Characters are not allowed"},
                {"123deposit", "Characters are not allowed"},
                {" ", "First character can not have space"},
                {" 23456", "First character can not have space"}
        };
    }
}
