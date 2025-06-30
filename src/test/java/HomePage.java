import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage{
    @FindBy(linkText = "Sign In")
    private WebElement signInLink;

    @FindBy(css = ".fc-button-label")
    private WebElement acceptCookiesBtn;

    public HomePage() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    public void acceptCookiesIfPresent() {
        WebElement acceptCookies = wait.until(
                ExpectedConditions.elementToBeClickable(acceptCookiesBtn));
        acceptCookies.click();
    }

    public LoginPage goToLogin() {
        signInLink.click();
        return new LoginPage();
    }

    public boolean isSignInLinkDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(signInLink));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}