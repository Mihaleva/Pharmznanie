import base.BaseTest;
import base.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import step.StepLogin;

/**
 * Created by mihaleva on 23.03.2016.
 */
public class ErrorLogInTest extends BaseTest {

    WebDriver driver = null;
    StepLogin step = null;

    @Test (dataProvider = "ErrorLoginPass", dataProviderClass = DataProviders.class)
    public void logErrorTel(String tel, String pass) throws InterruptedException {
        step.
                openPharm().
                clickSignIn().
                putTelephone(tel).
                putPassword(pass).
                clickEnter().
                checkNotLog();
    }

        /*     step.
                openPharm().
                clickSignIn().
                putTelephone("913987353").
                putPassword("qwertyuiop").
                clickEnter().
                checkNotLog();
    }
    @Test
    public void logErrorPass() throws InterruptedException {

        step.
                openPharm().
                clickSignIn().
                putTelephone("9139875583").
                putPassword("qwertytyu").
                clickEnter().
                checkNotLog();
    }

    @Test
    public void logNullPass() throws InterruptedException {

        step.
                openPharm().
                clickSignIn().
                putTelephone("9139875583").
                putPassword("").
                clickEnter().
                checkNullPass();
    }

    @Test
    public void logNullTel() throws InterruptedException {

        step.
                openPharm().
                clickSignIn().
                putTelephone("").
                putPassword("qwerty").
                clickEnter().
                checkNullTel();
    }

    @Test

    public void logShotTel() throws InterruptedException {

        step.
                openPharm().
                clickSignIn().
                putTelephone("913987558").
                putPassword("qwerty").
                clickEnter().
                checkNotLog();
    }

    @Test

    public void logShotPass() throws InterruptedException {

        step.
                openPharm().
                clickSignIn().
                putTelephone("9139875583").
                putPassword("qwert").
                clickEnter().
                checkNotLog();
    }

*/


    @BeforeTest
    public void bornDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/selenium/chromedriver.exe");
        step = new StepLogin(driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome()));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void killDriver() {

        driver.quit();
    }
}