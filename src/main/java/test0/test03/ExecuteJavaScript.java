package test0.test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExecuteJavaScript {
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
    public void js() throws IOException {
        driver.get("https://www.google.com");

        // Call  alert with JavaScript
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("alert('Hello!');");

    }
    @Test
    public void js2() throws IOException {
        driver.get("https://www.google.com");

        WebElement button = driver.findElement(By.name("btnI"));
        // Execute JavaScript on behalf of webelement
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

}
