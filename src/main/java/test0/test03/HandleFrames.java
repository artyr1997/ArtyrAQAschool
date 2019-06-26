package test0.test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class HandleFrames {
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
    public void getMainFrameText() {

        driver.get(Paths.get("html/frameset.html").toUri().toString());

        // switch to document in main frame
        driver.switchTo().frame("main");

        WebElement webElement = driver.findElement(By.tagName("h3"));
        System.out.println(webElement.getText());
        //return to the top document
        driver.switchTo().defaultContent();
    }
}
