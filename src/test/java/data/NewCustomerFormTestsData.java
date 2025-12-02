package data;

import org.testng.annotations.DataProvider;

public class NewCustomerFormTestsData {

    @DataProvider(name = "invalidCustomerNameInputs")
    public Object[][] invalidCustomerInputs() {
        return new Object[][] {
                {"", "Customer name must not be blank"},
                {"123123", "Numbers are not allowed"},
                {"Carl123", "Numbers are not allowed"},
                {"123Carl", "Numbers are not allowed"},
                {"C4rl", "Numbers are not allowed"},
                {"@Carl", "Special characters are not allowed"},
                {"!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~", "Special characters are not allowed"},
                {"C@rl", "Special characters are not allowed"},
                {"Carl!", "Special characters are not allowed"},
                {" ", "First character can not have space"},
                {" Carl", "First character can not have space"}
        };
    }

    @DataProvider(name = "invalidAddressInputs")
    public Object[][] invalidAddressInputs() {
        return new Object[][]{
                {"", "Address Field must not be blank"},
                {"@Town", "Special characters are not allowed"},
                {"!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~", "Special characters are not allowed"},
                {"T()wn", "Special characters are not allowed"},
                {"Town!", "Special characters are not allowed"},
                {" ", "First character can not have space"},
                {" Town", "First character can not have space"}
        };
    }

    @DataProvider(name = "invalidCityInputs")
    public Object[][] invalidCityInputs() {
        return new Object[][] {
                {"", "City Field must not be blank"},
                {"123123", "Numbers are not allowed"},
                {"City123", "Numbers are not allowed"},
                {"123City", "Numbers are not allowed"},
                {"C1ty", "Numbers are not allowed"},
                {"@City", "Special characters are not allowed"},
                {"!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~", "Special characters are not allowed"},
                {"C!ty", "Special characters are not allowed"},
                {"City!", "Special characters are not allowed"},
                {" ", "First character can not have space"},
                {" City", "First character can not have space"}
        };
    }

    @DataProvider(name = "invalidStateInputs")
    public Object[][] invalidStateInputs() {
        return new Object[][] {
                {"", "State must not be blank"},
                {"123123", "Numbers are not allowed"},
                {"State123", "Numbers are not allowed"},
                {"123State", "Numbers are not allowed"},
                {"St4te", "Numbers are not allowed"},
                {"@State", "Special characters are not allowed"},
                {"!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~", "Special characters are not allowed"},
                {"Sta+e", "Special characters are not allowed"},
                {"State!", "Special characters are not allowed"},
                {" ", "First character can not have space"},
                {" State", "First character can not have space"}
        };
    }

    @DataProvider(name = "invalidPINInputs")
    public Object[][] invalidPINInputs() {
        return new Object[][] {
                {"", "PIN Code must not be blank"},
                {"PIN", "Characters are not allowed"},
                {"PIN123", "Characters are not allowed"},
                {"123PIN", "Characters are not allowed"},
                {"12345", "PIN Code must have 6 Digits"},
                {"@PIN", "Special characters are not allowed"},
                {"!@#", "Special characters are not allowed"},
                {"P!N", "Special characters are not allowed"},
                {"PIN!", "Special characters are not allowed"},
                {" ", "First character can not have space"},
                {" 23456", "First character can not have space"}
        };
    }

    @DataProvider(name = "invalidMobileNumberInputs")
    public Object[][] invalidMobileNumberInputs() {
        return new Object[][] {
                {"", "Mobile no must not be blank"},
                {"abc", "Characters are not allowed"},
                {"abc123", "Characters are not allowed"},
                {"123abc", "Characters are not allowed"},
                {"@123", "Special characters are not allowed"},
                {"!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~", "Special characters are not allowed"},
                {"1#3", "Special characters are not allowed"},
                {"123!", "Special characters are not allowed"},
                {" ", "First character can not have space"},
                {" 123", "First character can not have space"}
        };
    }

    @DataProvider(name = "invalidEmailInputs")
    public Object[][] invalidEmailInputs() {
        return new Object[][] {
                {"", "Email-ID must not be blank"},
                {"myemail", "Email-ID is not valid"},
                {"name@email", "Email-ID is not valid"},
                {"Mail.com", "Email-ID is not valid"},
                {" ", "First character can not have space"},
                {" 123", "First character can not have space"}
        };
    }
}
