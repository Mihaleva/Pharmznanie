package pageFactory;

import Help.Waiter;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by mihaleva on 25.03.2016.
 */
public class RestorePassPage {

    public RestorePassPage(WebDriver driver) {
//Нужно инициализировать page object.
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="passwordresetrequestform-username" )
    WebElement telField;

    @FindBy(id ="confirmPhoneNumber" )
    WebElement confirmPhoneNumber;

    @FindBy(xpath=".//a[contains(.,'Восстановление пароля')]")
    private WebElement restorePass;

    @FindBy(xpath = ".//a[contains(.,'Войти')]")
    WebElement signinButton;

    @FindBy(id = "passwordresetrequestform-code")
    WebElement codefield;

    @FindBy(id = "resetFormConfirm")
    WebElement confirmEnter;

    @FindBy(id = "passwordresetrequestform-password")
    WebElement newPass;

    @FindBy(id = "passwordresetrequestform-passwordconfirm")
    WebElement repeatNewPass;


    @FindBy(id = "submitNewPassword")
    WebElement submitNewPassword;

    @FindBy(className = "help-block")
    WebElement errorMassage;


    public void restorePass(WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//a[contains(.,'Восстановление пароля')]", 10, 'x');
        Assert.assertTrue(restorePass.isDisplayed());
        restorePass.click();

    }

    public void putTel(WebDriver driver, String tel) throws InterruptedException {

        Waiter.wait(driver,"passwordresetrequestform-username", 10, 'i');
        Assert.assertTrue(telField.isDisplayed());
        telField.sendKeys(tel);
    }

    public void clickConfirmPhone(WebDriver driver) throws InterruptedException {

        Waiter.wait(driver,"confirmPhoneNumber", 10, 'i');
        Assert.assertTrue(confirmPhoneNumber.isDisplayed());
        confirmPhoneNumber.click();
    }

    public void clickSingInButton(WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//a[contains(.,'Войти')]", 10, 'x');
        Assert.assertTrue(signinButton.isDisplayed());
        signinButton.click();
        Thread.sleep(5000);
    }

    public void codeConfirm (WebDriver driver) throws InterruptedException, IOException {

        //Set<Cookie> cookies = driver.manage().getCookies();
        /*
        Iterator<Cookie> itr = cookies.iterator();
        ArrayList<Cookie> varifyPhone = null;
       while (itr.hasNext()) {
            Cookie cookie = itr.next();
              if (cookie.getName()== "S" )
              {
                  varifyPhone = cookie;
                  break;
              }

        }*/

        String parentWindowId = driver.getWindowHandle();

        //Clicking Help Button will open Help Page in a new Popup Browser Window
        Waiter.wait(driver,"confirmPhoneNumber", 10, 'i');
        Assert.assertTrue(confirmPhoneNumber.isDisplayed());
        confirmPhoneNumber.click();
        try {
            //Switch to the Help Popup Browser Window
            driver.switchTo().window("modal-content");

        } catch (NoSuchWindowException e) {
            e.printStackTrace();
        }

        //Verify the driver context is in Help Popup Browser Window
       // Assert.assertTrue(driver.getTitle().equals("Help"));

        //Close the Help Popup Window
      //  driver.close();

        //Move back to the Parent Browser Window
       // driver.switchTo().window(parentWindowId);

        //Verify the driver context is in Parent Browser Window
       // assertTrue(driver.getTitle().equals("Build my Car - Configuration"));
        Thread.sleep(3000);
       /* Waiter.wait(driver, "passwordresetrequestform-code", 90, 'i');
        Assert.assertTrue(codefield.isDisplayed());
        codefield.sendKeys("");
        confirmEnter.click();
        driver.switchTo().window(parentWindowId);*/
        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie cookie : allCookies) {
            System.out.println(String.format( "%s -> %s" , cookie.getName(), cookie.getValue()));
        }

        URL url = new URL("http://pharmznanie.ru/request-password-reset");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        int responseCode = http.getResponseCode();
        Assert.assertTrue(responseCode == 200);
        System.out.println(responseCode);
       // Thread.sleep(7000);
    }

    public void putPass(WebDriver driver, String newPassword, String repeatNewPassword) throws InterruptedException {

        Waiter.wait(driver, "passwordresetrequestform-password", 10, 'i');
        Assert.assertTrue(newPass.isDisplayed());
        newPass.sendKeys(newPassword);

        Waiter.wait(driver, "passwordresetrequestform-passwordconfirm", 10, 'i');
        Assert.assertTrue(newPass.isDisplayed());
        repeatNewPass.sendKeys(repeatNewPassword);

        submitNewPassword.click();
    }

    public void errorMassage(WebDriver driver) throws InterruptedException {

        Assert.assertTrue(errorMassage.isDisplayed());

    }

}
