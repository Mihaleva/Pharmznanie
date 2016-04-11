import base.BaseTest;
import base.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import step.StepLogin;
import step.StepRegistration;

import java.util.Random;

/**
 * Created by mihaleva on 25.03.2016.
 */
public class RegistrationTest extends BaseTest {

    WebDriver driver = null;
    StepRegistration step = null;
    StepLogin stepLogin = null;

    @Test (dataProvider = "Registration", dataProviderClass = DataProviders.class)
    public void registrationValidData (String name, String lastname, String city, String pass, String mail, String apteka) throws InterruptedException {


        final Random random = new Random();
        String phone = "";
        for(int i = 0; i < 10; i++) {
            phone += String.valueOf(random.nextInt()) ;
        }
        /*
        String name = "Auto авто";
        String lastname = "Test тест";
        String city = "Paris Москва";
        String pass = "qwerty";
        String mail = "qwerty@fg.yu";
        String apteka = "Apt !@#$%^&*()_+=-0/.,;:<> ка () \"fhfhf\" '1263729'";*/
        step.
                openPharm().
                clickRegButton().
                putLastName(lastname).
                putFirstName(name).
                putPhone(phone).
                putMail(mail).
                putCity(city).
                putApteka(apteka).
                putPassword(pass).
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