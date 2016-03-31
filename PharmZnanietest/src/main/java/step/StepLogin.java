package step;
import base.BaseSteps;
import org.apache.maven.settings.Profile;
import org.openqa.selenium.WebDriver;
import pageFactory.LoginPage;
import pageFactory.ProfilePage;
import pageFactory.RestorePassPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by mihaleva on 23.03.2016.
 */
public class StepLogin extends BaseSteps{

    LoginPage loginPage = null;
    ProfilePage profilePage = null;
    RestorePassPage restorePassPage = null;
    //YouTubeVideoPage youTubeVideoPage = null;


    public StepLogin (WebDriver driver) {

        super(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        restorePassPage = new RestorePassPage(driver);
    }


    @Step("Open Pharm")
    public StepLogin openPharm() {

        super.navigate();
        return this;

    }

    @Step("Click Sign In")
    public StepLogin clickSignIn() throws InterruptedException {

        loginPage.clickSingInButton(driver);
        return this;
    }


    @Step("Put telephone in field")
    public StepLogin putTelephone(String tel) throws InterruptedException {

        loginPage.putTelephone(driver, tel);
        return this;
    }

    @Step("Put password in field")
    public StepLogin putPassword(String pass) throws InterruptedException {

        loginPage.putPassword(driver, pass);
        return this;
    }

    @Step("Click Enter for authorization")
    public StepLogin clickEnter() throws InterruptedException {

        loginPage.clickEnter(driver);
        return this;
    }

    @Step("Check authorization")
    public StepLogin checkLog() throws InterruptedException {

        loginPage.checkEnter(driver);
        return this;
    }
    @Step("Check not authorization")
    public StepLogin checkNotLog() throws InterruptedException {

        loginPage.checkNotEnter(driver);
        return this;
    }

    @Step("Log Out")
    public StepLogin logOut() throws InterruptedException {

        loginPage.clickLogOutButton(driver);
        return this;
    }
    @Step("Massage error null password")
    public StepLogin checkNullPass() throws InterruptedException {

        loginPage.checkNullPass(driver);
        return this;
    }

    @Step("Massage error null telephon")
    public StepLogin checkNullTel() throws InterruptedException {

        loginPage.checkNullTel(driver);
        return this;
    }

}
