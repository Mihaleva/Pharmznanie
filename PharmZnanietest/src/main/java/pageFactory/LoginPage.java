package pageFactory;

import Help.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by mihaleva on 01.03.2016.
 */
public class LoginPage {

    public LoginPage(WebDriver driver) {
//Нужно инициализировать page object.
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[contains(.,'Войти')]")
    WebElement signinButton;

    @FindBy(xpath = ".//a[contains(.,'Регистрация')]")
    WebElement regButton;

    @FindBy(id = "loginform-login")
    private WebElement telephone;

    @FindBy( id="loginform-password")
    private WebElement password;


    @FindBy( xpath = ".//a[contains(.,'Восстановление пароля')]")
    private WebElement restorePassword;

    @FindBy(id="btnLoginUser")
    private WebElement enter;

    @FindBy(xpath=".//div[contains(.,'Некорректный пароль или телефон')]")
    private WebElement errorMassage;

    @FindBy(xpath = ".//a[contains(.,'Выйти')]")
    WebElement logOutButton;

    @FindBy(xpath=".//div[contains(.,'Необходимо заполнить поле Телефон')]")
    private WebElement errorNullMassageTel;

    @FindBy(xpath=".//div[contains(.,'Необходимо заполнить поле Пароль')]")
    private WebElement errorNullMassagePass;




    public void checkNullPass(WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//div[contains(.,'Необходимо заполнить поле Пароль')]", 10, 'x');
        Assert.assertTrue(errorNullMassagePass.isDisplayed());

    }

    public void checkNullTel (WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//div[contains(.,'Необходимо заполнить поле Телефон')]", 90, 'x');
        Assert.assertTrue(errorNullMassageTel.isDisplayed());
    }

    public void clickLogOutButton(WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//a[contains(.,'Выйти')]", 10, 'x');
        Assert.assertTrue(logOutButton.isDisplayed());
        logOutButton.click();
        Waiter.wait(driver, ".//a[contains(.,'Войти')]", 10, 'x');
        Assert.assertTrue(driver.getCurrentUrl().equals("http://front.dev.mgrnix.com:53580/"));
    }



    public void clickSingInButton(WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//a[contains(.,'Войти')]", 10, 'x');
        Assert.assertTrue(signinButton.isDisplayed());
        signinButton.click();
        Thread.sleep(5000);
    }

    public void putTelephone (WebDriver driver, String tel) throws InterruptedException {

        Waiter.wait(driver, "loginform-login", 10, 'i');
        Assert.assertTrue(telephone.isDisplayed());
        telephone.sendKeys(tel);
    }

    public void putPassword (WebDriver driver, String pass) throws InterruptedException {

        Waiter.wait(driver, "loginform-password", 10, 'i');
        Assert.assertTrue(password.isDisplayed());
        password.sendKeys(pass);
    }
    public void clickEnter (WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, "btnLoginUser", 10, 'i');
        Assert.assertTrue(enter.isDisplayed());
        enter.click();
    }

    public void checkEnter (WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, "avatar-wr", 90, 'c');
        Assert.assertTrue(driver.getCurrentUrl().equals("http://front.dev.mgrnix.com:53580/profile"));
    }

    public void checkNotEnter (WebDriver driver) throws InterruptedException {
        Assert.assertTrue(driver.getCurrentUrl().equals("http://front.dev.mgrnix.com:53580/login"));
       // Waiter.wait(driver, ".//div[contains(.,'Некорректный пароль или телефон')]", 90, 'x');
        //Assert.assertTrue(errorMassage.isDisplayed());
    }

    public void checkErrorNullTel (WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//div[contains(.,'Необходимо заполнить поле Телефон')]", 90, 'x');
        Assert.assertTrue(errorNullMassageTel.isDisplayed());
    }

    public void checkErrorNullPass (WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//div[contains(.,'Необходимо заполнить поле Телефон')]", 90, 'x');
        Assert.assertTrue(errorNullMassagePass.isDisplayed());
    }

}
