package rozetca.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SingUpPage {

    public WebDriver driver;

    @FindBy(name = "title")
    private WebElement registrationNameField;

    @FindBy(name = "login")
    private WebElement registrationEmailField;

    @FindBy(name = "password")
    private WebElement registrationPasswordField;

    @FindBy(css = ".signup-submit")
    private WebElement registrationButton;

    @FindBy(xpath = "//div[@class='message-confirm-mail-i bold']")
    private WebElement acceptEmailText;

    @FindBy(css = ".btn-link-confirm-mail")
    private WebElement acceptEmailButton;

    @FindBy(css = ".message")
    private WebElement existEmail;

    public SingUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Open SingUp page")
    public SingUpPage openSingUpPage () {
        driver.get(PropertyLoader.loadProperty("singup.url"));
        return this;
    }

    @Step("Fill name field")
    public SingUpPage typeNamefield (String nameRe) {
        registrationNameField.sendKeys(nameRe);
        return this;
    }

    @Step("Fill email field")
    public SingUpPage typeEmailfield (String emailRe) {
        registrationEmailField.sendKeys(emailRe);
        return this;
    }

    @Step("Fill password field")
    public SingUpPage typePasswordfield (String passwordRe) {
        registrationPasswordField.sendKeys(passwordRe);
        return this;
    }

    @Step("Press on the button Registration")
    public MainPage typeClickRegistration () {
        registrationButton.click();
        return new MainPage(driver);
    }

    @Step("Get text from error message after success registration")
    public String typeAcceptEmailMessage () {
        String acceptEmailMessage = acceptEmailText.getText();
        return acceptEmailMessage;
    }

    @Step("Press in the button Accept Registration")
    public MainPage typeClickAcceptRegistration () {
        acceptEmailButton.click();
        return new MainPage(driver);
    }

    @Step("Get text from error message after failed registration")
    public String typeExistEmailMessage () {
        String existEmailText = existEmail.getText();
        return existEmailText;
    }

    public MainPage positiveRegistration(String nameRe, String emailRe, String passwordRe) throws InterruptedException {
        this.typeNamefield(nameRe);
        this.typeEmailfield(emailRe);
        this.typePasswordfield(passwordRe);
        this.typeClickRegistration();
        Thread.sleep(2000);
        return new MainPage(driver);
    }


}