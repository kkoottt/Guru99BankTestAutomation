package data;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InvalidDataInputs {

    private static final Object[][] no_numbers= {
            {"123123", "Numbers are not allowed"},
            {"abc123", "Numbers are not allowed"},
            {"123abc", "Numbers are not allowed"},
            {"a1b2c", "Numbers are not allowed"}
    };

    private static final Object[][] no_characters = {
            {"abc", "Characters are not allowed"},
            {"abc123", "Characters are not allowed"},
            {"123abc", "Characters are not allowed"},
            {"1a2b3", "Characters are not allowed"}
    };

    private static final Object[][] no_special_characters_with_numbers = {
            {"@!#", "Special characters are not allowed"},
            {"@23", "Special characters are not allowed"},
            {"1!3", "Special characters are not allowed"},
            {"12#", "Special characters are not allowed"}
    };

    private static final Object[][] no_special_characters_with_characters = {
            {"@!#", "Special characters are not allowed"},
            {"@23", "Special characters are not allowed"},
            {"1!3", "Special characters are not allowed"},
            {"12#", "Special characters are not allowed"}
    };

    private static final Object[][] no_firstCharacterSpace_with_numbers = {
            {" ", "First character can not have space"},
            {" 123", "First character can not have space"}
    };

    private static final Object[][] no_firstCharacterSpace_with_characters = {
            {" ", "First character can not have space"},
            {" abc", "First character can not have space"}
    };

    private static final Object[][] no_invalid_email = {
            {"myemail", "Email-ID is not valid"},
            {"name@email", "Email-ID is not valid"},
            {"Mail.com", "Email-ID is not valid"}
    };


    @DataProvider(name = "invalidCustomerNameInputs")
    public Iterator<Object[]> invalidCustomerInputs() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"", "Customer name must not be blank"});
        data.addAll(Arrays.asList(no_numbers));
        data.addAll(Arrays.asList(no_special_characters_with_characters));
        data.addAll(Arrays.asList(no_firstCharacterSpace_with_characters));

        return data.iterator();
    }

    @DataProvider(name = "invalidAddressInputs")
    public Iterator<Object[]> invalidAddressInputs() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"", "Address Field must not be blank"});
        data.addAll(Arrays.asList(no_special_characters_with_characters));
        data.addAll(Arrays.asList(no_firstCharacterSpace_with_characters));

        return data.iterator();
    }

    @DataProvider(name = "invalidCityInputs")
    public Iterator<Object[]> invalidCityInputs() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"", "City Field must not be blank"});
        data.addAll(Arrays.asList(no_numbers));
        data.addAll(Arrays.asList(no_special_characters_with_characters));
        data.addAll(Arrays.asList(no_firstCharacterSpace_with_characters));

        return data.iterator();
    }

    @DataProvider(name = "invalidStateInputs")
    public Iterator<Object[]> invalidStateInputs() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"", "State must not be blank"});
        data.addAll(Arrays.asList(no_numbers));
        data.addAll(Arrays.asList(no_special_characters_with_characters));
        data.addAll(Arrays.asList(no_firstCharacterSpace_with_characters));

        return data.iterator();
    }

    @DataProvider(name = "invalidPINInputs")
    public Iterator<Object[]> invalidPINInputs() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"", "PIN Code must not be blank"});
        data.addAll(Arrays.asList(no_characters));
        data.addAll(Arrays.asList(no_special_characters_with_numbers));
        data.addAll(Arrays.asList(no_firstCharacterSpace_with_numbers));

        return data.iterator();
    }

    @DataProvider(name = "invalidMobileNumberInputs")
    public Iterator<Object[]> invalidMobileNumberInputs() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"", "Mobile no must not be blank"});
        data.addAll(Arrays.asList(no_characters));
        data.addAll(Arrays.asList(no_special_characters_with_numbers));
        data.addAll(Arrays.asList(no_firstCharacterSpace_with_numbers));

        return data.iterator();
    }

    @DataProvider(name = "invalidEmailInputs")
    public Iterator<Object[]> invalidEmailInputs() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"", "Email-ID must not be blank"});
        data.addAll(Arrays.asList(no_invalid_email));
        data.addAll(Arrays.asList(no_firstCharacterSpace_with_characters));

        return data.iterator();
    }

    @DataProvider(name = "invalidCustomerIDInputs")
    public Iterator<Object[]> invalidCustomerIDInputs() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"", "Customer ID is required"});
        data.addAll(Arrays.asList(no_special_characters_with_numbers));
        data.addAll(Arrays.asList(no_characters));
        data.addAll(Arrays.asList(no_firstCharacterSpace_with_numbers));

        return data.iterator();
    }

    @DataProvider(name = "invalidInitialDepositInputs")
    public Iterator<Object[]> invalidInitialDepositInputs() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"", "Initial Deposit must not be blank"});
        data.addAll(Arrays.asList(no_special_characters_with_numbers));
        data.addAll(Arrays.asList(no_characters));
        data.addAll(Arrays.asList(no_firstCharacterSpace_with_numbers));

        return data.iterator();
    }

    @DataProvider(name = "invalidAccountNumberInputs")
    public Iterator<Object[]> invalidAccountNumberInputs() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"", "Account Number must not be blank"});
        data.addAll(Arrays.asList(no_special_characters_with_numbers));
        data.addAll(Arrays.asList(no_characters));
        data.addAll(Arrays.asList(no_firstCharacterSpace_with_numbers));

        return data.iterator();
    }
}
