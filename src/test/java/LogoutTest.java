import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private WelcomePage welcomePage;
    private HomePage postLogoutPage;


    @BeforeEach
    public void login (){
        homePage = new HomePage();
        homePage.acceptCookiesIfPresent();
        loginPage = homePage.goToLogin();
        welcomePage = loginPage.enterEmail()
                .enterPassword()
                .submitLogin();
        postLogoutPage = welcomePage.logout();
    }

    @Test
    public void signInLinkIsVisibleAfterLogout() {
        assertTrue(postLogoutPage.isSignInLinkDisplayed(),
                "After logout, 'Sign In' link should be visible on home page");
    }
}
