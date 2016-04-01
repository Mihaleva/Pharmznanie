import base.BaseTest;
import base.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import step.StepLanding;
import step.StepLogin;

/**
 * Created by mihaleva on 31.03.2016.
 */
public class LandingTest extends BaseTest {

    WebDriver driver = null;
    StepLanding step = null;

    @Test
    public void logInLogOut() throws InterruptedException {
        String phone = "1587968375";
        String name = "Auto";
        String lastname = "Test";
        String city = "Paris";
        String mail = "qwe@rt.com";
        String apteka = "Apteka";

        step.
                openPharm().
                putLastName(lastname).
                putFirstName(name).
                putPhone(phone).
                putCity(city).
                putMail(mail).
                putApteka(apteka).
                enter().
                checkRegisterOk();

    }

    @BeforeTest
    public void bornDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/selenium/chromedriver.exe");
        step = new StepLanding(driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome()));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void killDriver() {

        driver.quit();
    }

}
