import base.BaseTest;
import base.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import step.StepLogin;
import step.StepRegistration;

/**
 * Created by mihaleva on 25.03.2016.
 */
public class RegistrationTest extends BaseTest {

    WebDriver driver = null;
    StepRegistration step = null;
    StepLogin stepLogin = null;

    @Test
    public void logInLogOut() throws InterruptedException {
String phone = "8584738375";
        String name = "Auto";
        String lastname = "Test";
        String city = "Paris";
        String pass = "qwerty";
        String apteka = "Apteka";
        step.
                openPharm().
                clickRegButton().
                putLastName(lastname).
                putFirstName(name).
                putPhone(phone).
                putCity(city).
                putPassword(pass).
                putApteka(apteka).
                enter().
                checkRegOk();

        stepLogin.
                logOut().
                clickSignIn().
                putTelephone(phone).
                putPassword(pass).
                clickEnter().
                checkLog().
                logOut();
    }


    @BeforeTest
    public void bornDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/selenium/chromedriver.exe");
        step = new StepRegistration(driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome()));
        stepLogin = new  StepLogin(driver);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void killDriver() {

        driver.quit();
    }

}