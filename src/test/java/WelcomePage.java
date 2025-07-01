import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WelcomePage extends BasePage {
    @FindBy(css = "li.greet.welcome > span.logged-in")
    private WebElement welcomeMsg;

    @FindBy(css = "button.action.switch")
    private WebElement accountMenuBtn;

    @FindBy(linkText = "Sign Out")
    private WebElement signOutLink;

    public WelcomePage() {
        super();
    }

    public boolean isLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMsg)).isDisplayed();
        return welcomeMsg.isDisplayed();
    }

    public HomePage logout() {
        wait.until(ExpectedConditions.elementToBeClickable(accountMenuBtn)).click();

        wait.until(ExpectedConditions.elementToBeClickable(signOutLink)).click();

        return new HomePage();
    }
}
