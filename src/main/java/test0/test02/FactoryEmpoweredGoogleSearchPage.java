package test0.test02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactoryEmpoweredGoogleSearchPage {
    private final WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public FactoryEmpoweredGoogleSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public FactoryEmpoweredGoogleSearchPage typeSearch(String search) {
        searchInput.sendKeys(search);
        return this;
    }

    public GoogleResultPage clickSearch() {
        searchButton.click();
        return new GoogleResultPage(driver);
    }

    public GoogleResultPage search(String search) throws InterruptedException {
        return typeSearch(search).clickSearch();
    }

    public static FactoryEmpoweredGoogleSearchPage open(WebDriver driver) {
        driver.get("https://www.google.com");
        return new FactoryEmpoweredGoogleSearchPage(driver);
    }
}
