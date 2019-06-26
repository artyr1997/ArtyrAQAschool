package test0.test01;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test1 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "/home/artyr/Videos/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void OpenPage1(){

        driver.get("https://www.ultimateqa.com/");
    }

    @Test
    public void OpenPage2(){

        driver.get("https://www.ultimateqa.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
