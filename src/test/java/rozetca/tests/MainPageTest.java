package rozetca.tests;

import io.qameta.allure.Description;
import rozetca.objects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;


    @BeforeMethod
    @Parameters({"browser"})
    public void before(String browser) {
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void after() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    @Description("Check move to sing up page from main page")
    public void MoveToSingUpPage() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.moveToSingUp();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, PropertyLoader.loadProperty("singup.url"));
    }

    @Test
    @Description("Check move to main page from sing up page")
    public void MoveToMainPage() throws InterruptedException {
        SingUpPage singUpPage = new SingUpPage(driver).openSingUpPage();
        MainPage mainPage = new MainPage(driver).typeClickLogo();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, PropertyLoader.loadProperty("site.url"));
    }

}