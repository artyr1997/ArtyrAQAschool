package test0.test02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private final WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public GoogleSearchPage typeSearch(String search) throws InterruptedException {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(search);
        Thread.sleep(500);
        searchInput.sendKeys(Keys.ESCAPE);
        return this;
    }

    public GoogleResultPage clickSearch() {
        WebElement searchButton = driver.findElement(By.cssSelector("div.FPdoLc [name='btnK']"));
        searchButton.click();
        return new GoogleResultPage(driver);
    }

    public GoogleResultPage search(String search) throws InterruptedException {
        return typeSearch(search).clickSearch();
    }

    public static GoogleSearchPage open(WebDriver driver) {
        driver.get("https://www.google.com");
        return new GoogleSearchPage(driver);
    }
}
