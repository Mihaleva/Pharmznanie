import base.BaseTest;
import base.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import step.StepLogin;
import step.StepStartPage;
import step.StepWebinar;

/**
 * Created by mihaleva on 08.04.2016.
 */
public class WebinarTest extends BaseTest {

    WebDriver driver = null;
    StepLogin step = null;
    StepWebinar step2 = null;

    @Test
    public void logIn() throws InterruptedException {

        step.
                openPharm().
                clickSignIn().
                putTelephone("9139875583").
                putPassword("105034").
                clickEnter().
                checkLog();
    }

    @Test
    public void viewWebinarLogUser() throws InterruptedException {

        step2.
                openWebPage();
        Thread.sleep(3000);
    }
    @BeforeTest
    public void bornDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/selenium/chromedriver.exe");
        step = new StepLogin(driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome()));
        step2 = new StepWebinar (driver );
        driver.manage().window().maximize();
    }

    @AfterTest
    public void killDriver() {

        driver.quit();
    }

}
