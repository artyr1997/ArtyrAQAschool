package rozetca.tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import rozetca.objects.MainPage;
import rozetca.objects.MyRandom;
import rozetca.objects.PropertyLoader;
import rozetca.objects.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class LogInTest {

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
    @Description("Make sing in with valid data")
    public void LoginPositive() throws InterruptedException {
        MainPage mainPage = new MainPage(driver)
                .openMainPage()
                .positiveLogIn(PropertyLoader.loadProperty("login"), PropertyLoader.loadProperty("password"));
        Assert.assertEquals(mainPage.typeGetNameText(), PropertyLoader.loadProperty("name"));
    }

    @Test
    @Description("Make sing in with invalid data")
    public void LoginNegative() throws InterruptedException {
        String emailWrong = PropertyLoader.loadProperty("login") + MyRandom.index_hard;
        String errorMessage = "Пользователь с логином " + emailWrong + " не зарегистрирован";
        MainPage mainPage = new MainPage(driver)
                .openMainPage()
                .positiveLogIn(emailWrong, PropertyLoader.loadProperty("password"));
        Assert.assertEquals(mainPage.typeErrorMessage(), errorMessage);
    }

}
