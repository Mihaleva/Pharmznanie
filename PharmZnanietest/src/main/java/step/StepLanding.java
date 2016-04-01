package step;

import base.BaseSteps;
import org.openqa.selenium.WebDriver;
import pageFactory.*;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by mihaleva on 31.03.2016.
 */
public class StepLanding  extends BaseSteps {

    LoginPage loginPage = null;
    ProfilePage profilePage = null;
    RestorePassPage restorePassPage = null;
    RegistrationPage registrationPage = null;
    Landing landing = null;



    public StepLanding(WebDriver driver) {

        super(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        restorePassPage = new RestorePassPage(driver);
        registrationPage = new RegistrationPage(driver);
        landing = new Landing(driver);
    }


    @Step("Open Pharm")
    public StepLanding openPharm() {

        super.navigateLan();
        return this;

    }


    @Step("Put Last Name")
    public StepLanding putLastName(String text) throws InterruptedException {

        landing.putLastname(driver, text);
        return this;

    }

    @Step("Enter")
    public StepLanding enter() throws InterruptedException {

        landing.clickEnter(driver);
        return this;

    }

    @Step("put First Name")
    public StepLanding putFirstName(String text) throws InterruptedException {

        landing.putFirstname(driver, text);
        return this;

    }

    @Step("Put Phone")
    public StepLanding putPhone(String text) throws InterruptedException {

        landing.putPhone(driver, text);
        return this;

    }


    @Step("Put Mail")
    public StepLanding putMail(String text) throws InterruptedException {

        landing.putMail(driver, text);
        return this;

    }

    @Step("Put City")
    public StepLanding putCity(String text) throws InterruptedException {

        landing.putCity(driver, text);
        return this;

    }

    @Step("Put Apteka")
    public StepLanding putApteka(String text) throws InterruptedException {

        landing.putApteka(driver, text);
        return this;

    }




    @Step("Check null firstname")
    public StepLanding checkNullFirstNameMessage() throws InterruptedException {

        landing.checkNullFirstName(driver);
        return this;
    }

    @Step("Check null password")
    public StepLanding checkNullPassMessage() throws InterruptedException {

        landing.checkNullPass(driver);
        return this;
    }

    @Step("Check null lastname")
    public StepLanding checkNullLastNameMessage() throws InterruptedException {

        landing.checkNullLastName(driver);
        return this;
    }

    @Step("Check null phone")
    public StepLanding checkNullPhoneMessage() throws InterruptedException {

        landing.checkNullPhone(driver);
        return this;
    }

    @Step("Check max Firstname")
    public StepLanding checkMaxFirstNameMessage() throws InterruptedException {

        landing.checkMaxFirstName(driver);
        return this;
    }
    @Step("Check max Lastname")
    public StepLanding checkMaxLastNameMessage() throws InterruptedException {

        landing.checkMaxLastName(driver);
        return this;
    }
    @Step("Check max Apteka")
    public StepLanding checkMaxAptekaMessage() throws InterruptedException {

        landing.checkMaxApteka(driver);
        return this;
    }
    @Step("Check max Firstname")
    public StepLanding checkMaxCityMessage() throws InterruptedException {

        landing.checkMaxCity(driver);
        return this;
    }
    @Step("Check max Firstname")
    public StepLanding checkMaxPassMessage() throws InterruptedException {

        landing.checkMaxPass(driver);
        return this;
    }
    @Step("Check min Firstname")
    public StepLanding checkMinFirstNameMessage() throws InterruptedException {

        landing.checkMinFirstName(driver);
        return this;
    }
    @Step("Check min Lastname")
    public StepLanding checkMinLastNameMessage() throws InterruptedException {

        landing.checkMinLastName(driver);
        return this;
    }

    @Step("Check min Password")
    public StepLanding checkMinPass() throws InterruptedException {

        landing.checkMinPass(driver);
        return this;
    }

    @Step("Check invalid lastname")
    public StepLanding checkInvalidLastname() throws InterruptedException {

        landing.checkLastnameError(driver);
        return this;
    }
    @Step("Check invalid firstname")
    public StepLanding checkInvalidFirstname() throws InterruptedException {

        landing.checkFirstnameError(driver);
        return this;
    }
    @Step("Check invalid mail")
    public StepLanding checkInvalidMail() throws InterruptedException {

        landing.checkMailError(driver);
        return this;
    }

    @Step("Check invalid city")
    public StepLanding checkInvalidCity() throws InterruptedException {

        landing.checkCityError(driver);
        return this;
    }

    @Step("Check registration")
    public StepLanding checkRegisterOk() throws InterruptedException {

        landing.checkReg(driver);
        return this;
    }

}