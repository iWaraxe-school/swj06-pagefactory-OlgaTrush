import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver() {
        if (driver.get() == null) {

            WebDriverManager.chromedriver().setup();

            WebDriver webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            //implicit waiter
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.set(webDriver);

        }

        return driver.get();
    }

         public static void tearDown() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
    }
}

