package rozetca.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    public WebDriver driver;

    @FindBy(id = "search_result_title_text")
    private WebElement searchResultTitle;

    @FindBy(id = "search_result_title_text")
    private WebElement searchResultEmpty;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Get text result of search")
    public String typeGetNameText () {
        String searchResultTitleText = searchResultTitle.getText();
        return searchResultTitleText;
    }

    @Step("Get text result of search")
    public String typeGetExptyNameText () {
        String searchResultTitleText = searchResultTitle.getText();
        return searchResultTitleText;
    }
}