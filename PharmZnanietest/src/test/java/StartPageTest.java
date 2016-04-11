import base.BaseTest;
import base.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import step.StepLogin;
import step.StepStartPage;

/**
 * Created by mihaleva on 08.04.2016.
 */
public class StartPageTest extends BaseTest {

    WebDriver driver = null;
    StepStartPage step = null;

    @Test
    public void logInWebinar() throws InterruptedException {

        step.
                openPharm().
                clickViewAndLogIn();
    }

    @Test
    public void registerWebinar() throws InterruptedException {

        step.
                openPharm().
                clickViewAndRegister();
    }
    @BeforeTest
    public void bornDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/selenium/chromedriver.exe");
        step = new StepStartPage(driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome()));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void killDriver() {

        driver.quit();
    }

}
