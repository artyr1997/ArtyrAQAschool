package test0.test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class TakeScreenshots {
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
    public void screenshot() throws IOException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");

        //Take screenshot into default temporary file
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Copy over into designated filename
        FileUtils.copyFile(srcFile, new File("screenshot.png"));

    }
}
