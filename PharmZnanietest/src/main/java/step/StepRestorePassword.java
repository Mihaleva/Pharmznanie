package step;

import base.BaseSteps;
import org.openqa.selenium.WebDriver;
import pageFactory.LoginPage;
import pageFactory.ProfilePage;
import pageFactory.RestorePassPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by mihaleva on 25.03.2016.
 */
public class StepRestorePassword extends BaseSteps {

        LoginPage loginPage = null;
        ProfilePage profilePage = null;
        RestorePassPage restorePassPage = null;
        //YouTubeVideoPage youTubeVideoPage = null;


        public StepRestorePassword(WebDriver driver) {

            super(driver);
            loginPage = new LoginPage(driver);
            profilePage = new ProfilePage(driver);
            restorePassPage = new RestorePassPage(driver);
        }


        @Step("Open Pharm")
        public StepRestorePassword openPharm() {

            super.navigate();
            return this;

        }

        @Step("Click Sign In")
        public StepRestorePassword clickSignIn() throws InterruptedException {

             restorePassPage.clickSingInButton(driver);
             return this;
        }

        @Step("Restore Password")
        public StepRestorePassword restorePass() throws InterruptedException {

            restorePassPage.restorePass(driver);
            return this;
        }

        @Step("Put Telephone")
        public StepRestorePassword putTel(String tel) throws InterruptedException {

           restorePassPage.putTel(driver, tel);
           return this;
        }

        @Step("Confirm Telephone")
        public StepRestorePassword clickConfirmTel() throws InterruptedException {

           restorePassPage.clickConfirmPhone(driver);
           return this;
        }

        @Step("Confirm Telephone")
        public StepRestorePassword confirmTel() throws InterruptedException {
            Thread.sleep(1000);
            restorePassPage.codeConfirm(driver);
            return this;
        }

        @Step("Put new pass")
            public StepRestorePassword putNewPass(String newPass, String repeatNewPass) throws InterruptedException {

              restorePassPage.putPass(driver, newPass, repeatNewPass);
              return this;
        }

        @Step("check error massage")
            public StepRestorePassword checkErrorMassage() throws InterruptedException {

               restorePassPage.errorMassage(driver);
               return this;
        }




}
