package test0.test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleResultPage {
    private final WebDriver driver;

    public GoogleResultPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }


    public List<String> getSearchResultsCaptions(String text) {
        return driver.findElements(By.partialLinkText(text))
                .stream()
                .map(x -> x.getText()).collect(Collectors.toList());
    }
    public List<WebElement> getSearchResults(String text) {
        return driver.findElements(By.partialLinkText(text));
    }
}
