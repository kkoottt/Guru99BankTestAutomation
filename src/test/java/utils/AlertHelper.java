package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {
    private WebDriver driver;
    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    public Alert waitForAlert(int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(int timeOutInSeconds) {
        waitForAlert(timeOutInSeconds).accept();
    }

    public String getAlertText(int timeOutInSeconds) {
        return waitForAlert(timeOutInSeconds).getText();
    }
}
