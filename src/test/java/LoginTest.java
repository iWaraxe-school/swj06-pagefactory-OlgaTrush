
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private WelcomePage welcomePage;

    @BeforeEach
    public void login (){
        homePage = new HomePage();
        homePage.acceptCookiesIfPresent();
        loginPage = homePage.goToLogin();
        welcomePage = loginPage.enterEmail()
                .enterPassword()
                .submitLogin();

    }

    @Test
    public void welcomeMessageIsDisplayed() {
        assertTrue(welcomePage.isLoggedIn(),
                "User should be logged in with displayed welcome message");
    }
}
