package rozetca.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;

    @FindBy(css = ".header-topline__user-link")
    private WebElement personalOfficeButton;

    @FindBy(css = ".auth-modal__register-link")
    private WebElement registrationButton;

    @FindBy(id = "auth_email")
    private WebElement emailFieldPopup;

    @FindBy(id = "auth_pass")
    private WebElement passwordFieldPopup;

    @FindBy(css = ".auth-modal__login-button")
    private WebElement loginButton;

    @FindBy(css = ".header-topline__user-link")
    private WebElement nameUser;

    @FindBy(name = "signout")
    private WebElement logout;

    @FindBy(css = ".logo")
    private WebElement logo;

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    @FindBy(name = "search")
    private WebElement searchField;

    @FindBy(css = ".search-form__submit")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Open Main page")
    public MainPage openMainPage () {
        driver.get(PropertyLoader.loadProperty("site.url"));
        return this;
    }

    @Step("Click to the personal office and open pop-up form")
    public MainPage typeClickPersonalOffice () {
        personalOfficeButton.click();
        return this;
    }

    @Step("Move to Sing Up page")
    public SingUpPage typeClickRegistrationMain () {
        registrationButton.click();
        return new SingUpPage(driver);
    }

    @Step("Fill email field")
    public MainPage typeEmailfield (String email) {
        emailFieldPopup.sendKeys(email);
        return this;
    }

    @Step("Fill password field")
    public MainPage typePasswordfield (String password) {
        passwordFieldPopup.sendKeys(password);
        return this;
    }

    @Step("Press on the button LOGIN")
    public MainPage typeClickLogin () {
        loginButton.click();
        return this;
    }

    @Step("Make hover to the name title")
    public MainPage typeHoverToMane () {
        Actions action = new Actions(driver);
        action.moveToElement(nameUser).build().perform();
        return this;
    }

    @Step("Press on the button Logout")
    public MainPage typeClickLogout () {
        logout.click();
        return this;
    }

    @Step("Press on the logo image")
    public MainPage typeClickLogo () {
        logo.click();
        return this;
    }

    @Step("Get Text from name element")
    public String typeGetNameText () {
        String newName = nameUser.getText();
        return newName;
    }

    @Step("Enter Data to search field")
    public MainPage typeSearchfield (String searchData) {
        searchField.sendKeys(searchData);
        return this;
    }

    @Step("Press on the button search")
    public MainPage typeSearchButton () {
        searchButton.click();
        return this;
    }

    @Step("Get Text from error message after incorrect login")
    public String typeErrorMessage () {
        String errorMessageText = errorMessage.getText();
        return errorMessageText;
    }

    public SingUpPage moveToSingUp() throws InterruptedException {
        this.typeClickPersonalOffice();
        Thread.sleep(1000);
        this.typeClickRegistrationMain();
        return new SingUpPage(driver);
    }

    public MainPage positiveLogIn(String email, String password) throws InterruptedException {
        this.typeClickPersonalOffice();
        this.typeEmailfield(email);
        this.typePasswordfield(password);
        this.typeClickLogin();
        Thread.sleep(1000);
        return new MainPage(driver);
    }

    public MainPage MainSearch(String searchData) throws InterruptedException {
        this.typeSearchfield(searchData);
        this.typeSearchButton();
        Thread.sleep(1000);
        return new MainPage(driver);
    }

}