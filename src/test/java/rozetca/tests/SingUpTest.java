package rozetca.tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import rozetca.objects.MyRandom;
import rozetca.objects.PropertyLoader;
import rozetca.objects.SingUpPage;
import rozetca.objects.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class SingUpTest {

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
    @Description("Make Registration with valid data")
    public void RegistrationPositive() throws InterruptedException {
        String myEmail = "artyr.savytskyy+" + MyRandom.index_hard + "@gmail.com";
        SingUpPage singUpPage = new SingUpPage(driver).openSingUpPage();
        singUpPage.positiveRegistration(PropertyLoader.loadProperty("name"),
                myEmail, PropertyLoader.loadProperty("password"));
        Assert.assertEquals(singUpPage.typeAcceptEmailMessage(), myEmail);
    }

    @Test
    @Description("Make Registration with valid data")
    public void RegistrationNegative() throws InterruptedException {
        String oldEmail = PropertyLoader.loadProperty("login");
        String errorMessage = "Пользователь с логином " + oldEmail + " уже зарегистрирован. Забыли пароль?";
        SingUpPage singUpPage = new SingUpPage(driver).openSingUpPage();
        singUpPage.positiveRegistration(PropertyLoader.loadProperty("name"),
                oldEmail, PropertyLoader.loadProperty("password"));
        Assert.assertEquals(singUpPage.typeExistEmailMessage(), errorMessage);

    }

}
