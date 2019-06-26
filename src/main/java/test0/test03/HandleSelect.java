package test0.test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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

public class HandleSelect {
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
    public void mainTest2() {
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get(Paths.get("html/frameset.html").toUri().toString());

        driver.switchTo().frame("main");




        WebElement webElement = driver.findElement(By.tagName("h3"));
        System.out.println(webElement.getText());

    }

    @Test
    public void mainTest3() {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get(Paths.get("html/window.html").toUri().toString());

        driver.findElement(By.tagName("a")).click();

        String myHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle:handles){
            if (!handle.equals(myHandle)){
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(myHandle);



    }
    @Test
    public void mainTest4() {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get(Paths.get("html/window.html").toUri().toString());

        WebElement element = driver.findElement(By.id("option"));
        Select select = new Select(element);
//        select.


    }
    @Test
    public void select() throws IOException {
        driver.get(Paths.get("html/select.html").toUri().toString());

        WebElement element = driver.findElement(By.id("selenium_commands"));
        Select multiselect = new Select(element);
        multiselect.selectByValue("Switch");

        List<WebElement> selectedOptions = multiselect.getAllSelectedOptions();

        Assert.assertEquals(selectedOptions.size(), 1);
        Assert.assertTrue(selectedOptions.get(0).isSelected());
    }
}
