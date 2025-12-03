package integrationTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.time.Duration;

public class LoginToHomePage extends BaseTest {

    @Test
    public void validManagerLogin(){
        loginAsManager();

        String expectedURL = "https://demo.guru99.com/V4/manager/Managerhomepage.php";
        waitURL(expectedURL);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Valid Manager Login Unsuccessful.");
    }

    @Test
    public void validCustomerLogin() {
        loginAsCustomer();

        String expectedURL = "https://demo.guru99.com/V4/customer/Customerhomepage.php";
        waitURL(expectedURL);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Valid Customer Login Unsuccessful.");
    }
}
