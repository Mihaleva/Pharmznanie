import base.BaseTest;
import base.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import step.StepRegistration;
import step.StepRestorePassword;
import step.StepLogin;

import java.io.IOException;

/**
 * Created by mihaleva on 25.03.2016.
 */
public class RestorePassTest extends BaseTest {

    WebDriver driver = null;
    StepRestorePassword step = null;

    @Test
    public void logInLogOut() throws InterruptedException, IOException {

        step.
                openPharm().
                clickSignIn().
                restorePass().
                putTel("9139875583").
                confirmTel();


    }

    @BeforeTest
    public void bornDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/selenium/chromedriver.exe");
        step = new StepRestorePassword(driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome()));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void killDriver() {

        driver.quit();
    }

}
