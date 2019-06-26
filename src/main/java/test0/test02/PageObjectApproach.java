package test0.test02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageObjectApproach {
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
    public void simpleSearch() throws InterruptedException {
//        driver.get("https://www.google.com");
        FactoryEmpoweredGoogleSearchPage.open(driver);

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("KindGeek");
        Thread.sleep(500);
        searchInput.sendKeys(Keys.ESCAPE);

        WebElement searchButton = driver.findElement(By.cssSelector("div.FPdoLc [name='btnK']"));
        searchButton.click();

        Assert.assertTrue(driver.getTitle().contains("KindGeek"));
    }

    @Test
    public void pageObjectEmpoweredSearch() throws InterruptedException {
        driver.get("https://www.google.com");
        GoogleResultPage resultsPage = new GoogleSearchPage(driver)
                .typeSearch("KindGeek")
                .clickSearch();
        String title = resultsPage.getTitle();

        Assert.assertTrue(title.contains("KindGeek"));
    }

    @Test
    public void pageFactoryEmpoweredTest() throws InterruptedException{
        driver.get("https://www.google.com");
        GoogleResultPage resultsPage = new FactoryEmpoweredGoogleSearchPage(driver)
                .typeSearch("KindGeek")
                .clickSearch();
        String title = resultsPage.getTitle();

        Assert.assertTrue(title.contains("KindGeek"));
    }
}
