package test0.test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.Set;

public class HandleWindows {
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
    public void mainTest3() {
        driver.get(Paths.get("html/window.html").toUri().toString());

        // Assume we clicked on a link thatopen new window
        driver.findElement(By.tagName("a")).click();

        // Store current window's handle
        String myHandle = driver.getWindowHandle();
        // Retrieve handles of all windows
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(myHandle)) {
                // Switch to just opened window by it's handle
                driver.switchTo().window(handle);

                // Do some work in this window

                // Close window
                driver.close();
            }
        }

        //return to main window
        driver.switchTo().window(myHandle);
    }
}
