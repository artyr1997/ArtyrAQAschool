package test0.test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class HandleAlerts {
    private WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void after() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void handleAlert() {

        driver.get(Paths.get("html/alert.html").toUri().toString());

        driver.findElement(By.id("alert1")).click();

        //Get alert object
        Alert alert = driver.switchTo().alert();
        //read the alert text
        System.out.println(alert.getText());
        //Accept alert
        alert.accept();

        //Try to switch to alert
        try {
            driver.switchTo().alert();
            Assert.fail("Alert was open");
        } catch (NoAlertPresentException e) {
            System.out.println("All right, no alert open");
        }
    }

    @Test
    public void handlePrompt() {
        driver.get(Paths.get("html/alert.html").toUri().toString());

        driver.findElement(By.id("prompt1")).click();

        Alert prompt = driver.switchTo().alert();
        System.out.println(prompt.getText());
        prompt.sendKeys("blah!");
        prompt.accept();
    }

}
