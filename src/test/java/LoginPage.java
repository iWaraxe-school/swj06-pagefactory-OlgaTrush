import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public static final String EMAIL    = "trushdd@gmail.com";
    public static final String PASSWORD = "123qweQWE!!!";

    @FindBy (id = "email")
    private WebElement emailValue;

    @FindBy (id = "pass")
    private WebElement passwordValue;

    @FindBy (id = "send2")
    private WebElement submitBtn;

        public LoginPage(){
            super();
        }


    public LoginPage enterEmail() {
        //enter email, when the field is visible
        wait.until(ExpectedConditions.visibilityOf(emailValue)).sendKeys(EMAIL);
        return this;
    }

    public LoginPage enterPassword() {
        //enter password, when the field is visible
        wait.until(ExpectedConditions.visibilityOf(passwordValue)).sendKeys(PASSWORD);
        return this;
    }

    public WelcomePage submitLogin() {
        //Submit log in
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return new WelcomePage();
    }
}
