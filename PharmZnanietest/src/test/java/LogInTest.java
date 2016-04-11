import base.BaseTest;
import base.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import step.StepLogin;


/**
 * Created by mihaleva on 23.03.2016.
 */
public class LogInTest extends BaseTest {

    WebDriver driver = null;
    StepLogin step = null;


/*
    public class DataProviders {
        @DataProvider(name = "LoginPass")
        public static Object[][] createData1() {
            return new Object[][] {
                    {  "9139875583", "105034" }

            };
        }
    }

*/
    @Test (dataProvider = "LoginPass", dataProviderClass = DataProviders.class)
    public void logInLogOut(String tel, String pass) throws InterruptedException {

        step.
                openPharm().
                clickSignIn().
                putTelephone(tel).
                putPassword(pass).
                clickEnter().
                checkLog().
                logOut();


    }

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
