package pagesTests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import base.BaseTest;

import java.time.Duration;

public class LoginPageTests extends BaseTest {

    @Test
    public void invalidLoginCredentials() {
        loginPage.enterUserID("xyz");
        loginPage.enterPassword("123");
        loginPage.clickLogin();

        String actual = alertHelper.getAlertText(15);
        Assert.assertEquals(actual,"User or Password is not valid");
    }

    @Test
    public void loginWithEmptyCredentials() {
        loginPage.enterUserID("123");
        loginPage.enterPassword("123");
        loginPage.clickReset();
        loginPage.clickLogin();

        String actual = alertHelper.getAlertText(15);
        Assert.assertEquals(actual,"Please enter your userID and Password.");
    }

    @Test
    public void userIDCannotBeEmpty() {
        loginPage.enterUserID("");
        tab();

        String actual = loginPage.getUserIDErrorMessage();
        Assert.assertEquals(actual,"User-ID must not be blank");
    }

    @Test
    public void passwordCannotBeEmpty() {
        loginPage.enterPassword("");
        tab();

        String actual = loginPage.getPasswordErrorMessage();
        Assert.assertEquals(actual,"Password must not be blank");
    }

    @Test
    public void resetBtnClearsAllField() {
        loginPage.enterUserID("someUserID");
        loginPage.enterPassword("somePassword");
        loginPage.clickReset();

        String userID = loginPage.getTextUserID();
        String password = loginPage.getTextPassword();
        Assert.assertEquals(userID,"", "UserID Input Field is not cleared.");
        Assert.assertEquals(password,"", "Password Input Field is not cleared.");
    }
}
