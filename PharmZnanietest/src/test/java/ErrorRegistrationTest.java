import base.BaseTest;
import base.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import step.StepLogin;
import step.StepRegistration;

/**
 * Created by mihaleva on 28.03.2016.
 */
public class ErrorRegistrationTest extends BaseTest {

    WebDriver driver = null;
    StepRegistration step = null;
    StepLogin stepLogin = null;

    @Test
    public void NullField() throws InterruptedException {

        step.
                openPharm().
                clickRegButton().
                putLastName("").
                putFirstName("").
                putPassword("").
                putPhone("").
                putCity("").
                putMail("").
                putApteka("").
                checkNullFirstNameMessage().
                checkNullLastNameMessage().
                checkNullPhoneMessage().
                checkNullPassMessage();

    }

    @Test
    public void ErrorLengthMaxField() throws InterruptedException {

        step.
                openPharm().
                clickRegButton().
                putLastName("алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр").
                putFirstName("алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр").
                putPassword("алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр").
                putCity("алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр").
                putApteka("алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр").
                putMail("").
                checkMaxAptekaMessage().
                checkMaxCityMessage().
                checkMaxFirstNameMessage().
                checkMaxLastNameMessage().
                checkMaxPassMessage();

    }
 @Test
    public void ErrorLengthMinField() throws InterruptedException {

        step.
                openPharm().
                clickRegButton().
                putLastName("а").
                putFirstName("а").
                putPassword("d").
                putMail("").
                checkMinFirstNameMessage().
                checkMinLastNameMessage().
                checkMinPass();

Thread.sleep(1000);
    }

    @Test
    public void ErrorInvalidField() throws InterruptedException {

        step.
                openPharm().
                clickRegButton().

                putLastName("!@#$%^&*()_").
                putMail("").
                checkInvalidLastname().



                putFirstName("!@#$%^&*()_").
                putMail("").
                checkInvalidFirstname().
                putLastName("12345").
                putMail("").
                checkInvalidLastname().

                putFirstName("12345").
                putMail("").
                checkInvalidFirstname().

                putCity("12345").
                putMail("").
                putApteka("").
                checkInvalidCity().

                putCity("!@#$%^&*()_").
                putMail("").
                checkInvalidCity().

                putMail("qwerty").
                putApteka("").
                checkInvalidMail().

                putMail("12345").
                putApteka("").
                checkInvalidMail().

                putMail("!@#$%^").
                putApteka("").
                checkInvalidMail().

                putMail("qwerty@").
                putApteka("").
                checkInvalidMail().

                putMail("qwerty fh@yh.f").
                putApteka("").
                checkInvalidMail().

                putMail("@ghd.gh").
                putApteka("").
                checkInvalidMail().

                putMail("qwerty@gfh").
                putApteka("").
                checkInvalidMail()
                ;


        Thread.sleep(1000);
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