package step;

import base.BaseSteps;
import org.openqa.selenium.WebDriver;
import pageFactory.LoginPage;
import pageFactory.ProfilePage;
import pageFactory.RegistrationPage;
import pageFactory.RestorePassPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by mihaleva on 25.03.2016.
 */
public class StepRegistration extends BaseSteps {

    LoginPage loginPage = null;
    ProfilePage profilePage = null;
    RestorePassPage restorePassPage = null;
    RegistrationPage registrationPage = null;



    public StepRegistration(WebDriver driver) {

        super(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        restorePassPage = new RestorePassPage(driver);
        registrationPage = new RegistrationPage(driver);
    }


    @Step("Open Pharm")
    public StepRegistration openPharm() {

        super.navigate();
        return this;

    }

    @Step("Open Registration")
    public StepRegistration clickRegButton() throws InterruptedException {

        registrationPage.clickRegButton(driver);
        return this;

    }

    @Step("Put Last Name")
    public StepRegistration putLastName(String text) throws InterruptedException {

        registrationPage.putLastname(driver, text);
        return this;

    }

    @Step("Enter")
    public StepRegistration enter() throws InterruptedException {

        registrationPage.clickEnter(driver);
        return this;

    }

    @Step("put First Name")
    public StepRegistration putFirstName(String text) throws InterruptedException {

        registrationPage.putFirstname(driver, text);
        return this;

    }

    @Step("Put Phone")
    public StepRegistration putPhone(String text) throws InterruptedException {

        registrationPage.putPhone(driver, text);
        return this;

    }


    @Step("Put Mail")
    public StepRegistration putMail(String text) throws InterruptedException {

        registrationPage.putMail(driver, text);
        return this;

    }

    @Step("Put City")
    public StepRegistration putCity(String text) throws InterruptedException {

        registrationPage.putCity(driver, text);
        return this;

    }

    @Step("Put Apteka")
    public StepRegistration putApteka(String text) throws InterruptedException {

        registrationPage.putApteka(driver, text);
        return this;

    }

    @Step("Put Password")
    public StepRegistration putPassword(String text) throws InterruptedException {

        registrationPage.putPass(driver, text);
        return this;

    }



    @Step("Check successful registration")
    public StepRegistration checkRegOk() throws InterruptedException {

        registrationPage.checkRegOk(driver);
        return this;
    }

    @Step("Check null firstname")
    public StepRegistration checkNullFirstNameMessage() throws InterruptedException {

        registrationPage.checkNullFirstName(driver);
        return this;
    }
    @Step("Check null password")
    public StepRegistration checkNullPassMessage() throws InterruptedException {

        registrationPage.checkNullPass(driver);
        return this;
    }

    @Step("Check null lastname")
    public StepRegistration checkNullLastNameMessage() throws InterruptedException {

        registrationPage.checkNullLastName(driver);
        return this;
    }

    @Step("Check null phone")
    public StepRegistration checkNullPhoneMessage() throws InterruptedException {

        registrationPage.checkNullPhone(driver);
        return this;
    }

    @Step("Check max Firstname")
    public StepRegistration checkMaxFirstNameMessage() throws InterruptedException {

        registrationPage.checkMaxFirstName(driver);
        return this;
    }
    @Step("Check max Lastname")
    public StepRegistration checkMaxLastNameMessage() throws InterruptedException {

        registrationPage.checkMaxLastName(driver);
        return this;
    }
    @Step("Check max Apteka")
    public StepRegistration checkMaxAptekaMessage() throws InterruptedException {

        registrationPage.checkMaxApteka(driver);
        return this;
    }
    @Step("Check max Firstname")
    public StepRegistration checkMaxCityMessage() throws InterruptedException {

        registrationPage.checkMaxCity(driver);
        return this;
    }
    @Step("Check max Firstname")
    public StepRegistration checkMaxPassMessage() throws InterruptedException {

        registrationPage.checkMaxPass(driver);
        return this;
    }
    @Step("Check min Firstname")
    public StepRegistration checkMinFirstNameMessage() throws InterruptedException {

        registrationPage.checkMinFirstName(driver);
        return this;
    }
    @Step("Check min Lastname")
    public StepRegistration checkMinLastNameMessage() throws InterruptedException {

        registrationPage.checkMinLastName(driver);
        return this;
    }

    @Step("Check min Password")
    public StepRegistration checkMinPass() throws InterruptedException {

        registrationPage.checkMinPass(driver);
        return this;
    }

    @Step("Check invalid lastname")
    public StepRegistration checkInvalidLastname() throws InterruptedException {

        registrationPage.checkLastnameError(driver);
        return this;
    }
    @Step("Check invalid firstname")
    public StepRegistration checkInvalidFirstname() throws InterruptedException {

        registrationPage.checkFirstnameError(driver);
        return this;
    }
    @Step("Check invalid mail")
    public StepRegistration checkInvalidMail() throws InterruptedException {

        registrationPage.checkMailError(driver);
        return this;
    }

    @Step("Check invalid city")
    public StepRegistration checkInvalidCity() throws InterruptedException {

        registrationPage.checkCityError(driver);
        return this;
    }

}
