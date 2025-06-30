import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/";

    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(BASE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        DriverManager.tearDown();
    }
}
