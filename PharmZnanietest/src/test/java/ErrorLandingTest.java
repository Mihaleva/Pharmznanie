import base.BaseTest;
import base.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import step.StepLanding;
import step.StepLogin;
import step.StepRegistration;

/**
 * Created by mihaleva on 01.04.2016.
 */
public class ErrorLandingTest extends BaseTest {

    WebDriver driver = null;
    StepLanding step = null;

      @Test
      public void NullField() throws InterruptedException {

          step.
                  openPharm().
                  putLastName("").
                  putFirstName("").
                  putPhone("").
                  putCity("").
                  putMail("").
                  putApteka("").
                  checkNullFirstNameMessage().
                  checkNullLastNameMessage().
                  checkNullPhoneMessage();

      }

     @Test
      public void ErrorLengthMaxField() throws InterruptedException {

          step.
                  openPharm().
                  putLastName("алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр").
                  putFirstName("алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр").
                  putCity("алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр").
                  putApteka("алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр").
                  putMail("").
                  checkMaxAptekaMessage().
                  checkMaxCityMessage().
                  checkMaxFirstNameMessage().
                  checkMaxLastNameMessage();

      }
     @Test
       public void ErrorLengthMinField() throws InterruptedException {

           step.
                   openPharm().
                   putLastName("а").
                   putFirstName("а").
                   putMail("").
                   checkMinFirstNameMessage().
                   checkMinLastNameMessage();

           Thread.sleep(1000);
       }

        @Test
     public void ErrorInvalidField() throws InterruptedException {

         step.
                 openPharm().
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
        step = new StepLanding(driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome()));

        driver.manage().window().maximize();
    }

    @AfterTest
    public void killDriver() {

        driver.quit();
    }

}