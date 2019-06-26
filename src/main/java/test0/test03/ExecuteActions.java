package test0.test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class ExecuteActions {
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
    public void dragndrop() throws IOException {
        driver.get(Paths.get("html/drag-n-drop.html").toUri().toString());

        Actions action = new Actions(driver);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        action
            .moveToElement(draggable) // move mouse to element
            .clickAndHold() // click the mouse button
            .moveToElement(droppable) // move mouse
            .release() //release button
            .build() //Builder's method
            .perform(); //execute actions one by one
    }

    @Test
    public void dragndropShortened() throws IOException {
        driver.get(Paths.get("html/drag-n-drop.html").toUri().toString());

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        new Actions(driver).dragAndDrop(draggable, droppable).perform();
    }

}
