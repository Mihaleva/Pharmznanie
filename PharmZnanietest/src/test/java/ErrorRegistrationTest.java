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
    public void ErrorNullField() throws InterruptedException {

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

    @Test (dataProvider = "ErrorLongRegistration", dataProviderClass = DataProviders.class)
    public void ErrorLengthMaxField(String last, String first, String pass, String city, String apteka) throws InterruptedException {

        step.
                openPharm().
                clickRegButton().
                putLastName(last).
                putFirstName(first).
                putPassword(pass).
                putCity(city).
                putApteka(apteka).
                putMail("").
                checkMaxAptekaMessage().
                checkMaxCityMessage().
                checkMaxFirstNameMessage().
                checkMaxLastNameMessage().
                checkMaxPassMessage();

    }

    @Test (dataProvider = "ErrorShortRegistration", dataProviderClass = DataProviders.class)
    public void ErrorLengthMinField(String last, String first, String pass ) throws InterruptedException {

        step.
                openPharm().
                clickRegButton().
                putLastName(last).
                putFirstName(first).
                putPassword(pass).
                putMail("").
                checkMinFirstNameMessage().
                checkMinLastNameMessage().
                checkMinPass();

Thread.sleep(1000);
    }

    @Test (dataProvider = "ErrorRegistration", dataProviderClass = DataProviders.class)
    public void ErrorInvalidField(String last, String first, String city, String mail) throws InterruptedException {

        step.
                openPharm().
                clickRegButton().

                putLastName(last).
                putFirstName(first).
                putMail(mail).
                putCity(city).
                putApteka("").
                checkInvalidLastname().
                checkInvalidFirstname().
                checkInvalidCity().
                checkInvalidMail();


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