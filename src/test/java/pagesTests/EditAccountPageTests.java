package pagesTests;

import base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EditAccountForm;
import pages.EditAccountPage;

public class EditAccountPageTests extends BaseTest {

    private EditAccountPage editAccountPage;

    @BeforeMethod
    public void openEditAccountPage() {
        loginAsManager();
        managerHomePage.clickEditAccountBtn()
                .enterAccountNumberField("178730")
                .clickSubmitBtn();
        editAccountPage = new EditAccountPage(driver);
    }

    @Test
    public void customerIDFieldShouldBeDisabled() {
        throw new SkipException("Page unable: 500 Internal Server Error");
    }

    @Test
    public void balanceFieldShouldBeDisabled() {
        throw new SkipException("Page unable: 500 Internal Server Error");
    }
}
