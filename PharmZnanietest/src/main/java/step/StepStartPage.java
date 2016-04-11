package step;

import base.BaseSteps;
import org.openqa.selenium.WebDriver;
import pageFactory.LoginPage;
import pageFactory.ProfilePage;
import pageFactory.RestorePassPage;
import pageFactory.StartPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by mihaleva on 08.04.2016.
 */
public class StepStartPage extends BaseSteps {

    LoginPage loginPage = null;
    ProfilePage profilePage = null;
    RestorePassPage restorePassPage = null;
    StartPage startPage = null;
    //YouTubeVideoPage youTubeVideoPage = null;


    public StepStartPage(WebDriver driver) {

        super(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        restorePassPage = new RestorePassPage(driver);
        startPage = new StartPage(driver);
    }


    @Step("Open Pharm")
    public StepStartPage openPharm() {

        super.navigate();
        return this;

    }

    @Step("Click View")
    public StepStartPage clickViewAndRegister() throws InterruptedException {

        startPage.clickViewAndRegister(driver);
        return this;
    }

    @Step("Click View")
    public StepStartPage clickViewAndLogIn() throws InterruptedException {

        startPage.clickViewAndEnter(driver);
        return this;
    }
}