package rozetca.tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import rozetca.objects.MainPage;
import rozetca.objects.PropertyLoader;
import rozetca.objects.SearchResultPage;
import rozetca.objects.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class SearchTest {

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
    @Description("Make Search with valid data")
    public void SearchPositive() throws InterruptedException {
        String searchData = PropertyLoader.loadProperty("valid.data");
        MainPage mainPage = new MainPage(driver)
                .openMainPage()
                .MainSearch(searchData);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertEquals(searchResultPage.typeGetNameText(), searchData);
    }

    @Test
    @Description("Make Search with invalid data")
    public void SearchNegative() throws InterruptedException {
        String searchData = PropertyLoader.loadProperty("invalid.data");
        MainPage mainPage = new MainPage(driver)
                .openMainPage()
                .MainSearch(searchData);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertEquals(searchResultPage.typeGetExptyNameText(), searchData);
    }

}
