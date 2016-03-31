package pageFactory;

import Help.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by mihaleva on 25.03.2016.
 */
public class RegistrationPage {

    public RegistrationPage (WebDriver driver) {
//Нужно инициализировать page object.
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = ".//a[contains(.,'Регистрация')]")
    WebElement regButton;
    
    @FindBy(xpath = ".//a[contains(.,'Выйти')]")
    WebElement logOutButton;

    @FindBy(xpath = ".//a[contains(.,'Войти')]")
    WebElement logInButton;

    @FindBy(id = "signupmvpform-lastname")
    WebElement lastName;

    @FindBy(id = "signupmvpform-firstname")
    WebElement firstName;

    @FindBy(id = "signupmvpform-phone")
    WebElement telephone;

    @FindBy(id = "signupmvpform-email")
    WebElement mail;

    @FindBy(id = "signupmvpform-city")
    WebElement city;

    @FindBy(id = "signupmvpform-company")
    WebElement apteka;

    @FindBy(id = "signupmvpform-password")
    WebElement password;

    @FindBy(id = "btnCreateUser")
    WebElement enterButton;

    @FindBy(xpath = ".//div[contains(.,'Необходимо заполнить поле Фамилия')]")
    WebElement nullLastNameError;

    @FindBy(xpath = ".//div[contains(.,'Необходимо заполнить поле Имя')]")
    WebElement nullFirstNameError;

    @FindBy(xpath = ".//div[contains(.,'Необходимо заполнить «Телефон»')]")
    WebElement nullPhoneError;

    @FindBy(xpath = ".//div[contains(.,'Необходимо заполнить поле Пароль')]")
    WebElement nullPassError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Фамилия должно содержать максимум 60 символов.')]")
    WebElement maxLastNameError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Имя должно содержать максимум 60 символов.')]")
    WebElement maxFirstNameError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Город должно содержать максимум 60 символов.')]")
    WebElement maxCityError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Аптечное предприятие должно содержать максимум 60 символов.')]")
    WebElement maxAptekaError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Пароль должно содержать максимум 30 символов.')]")
    WebElement maxPassError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Фамилия должно содержать минимум 2 символа.')]")
    WebElement minLastNameError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Имя должно содержать минимум 2 символа.')]")
    WebElement minFirstNameError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Пароль должно содержать минимум 6 символа.')]")
    WebElement minPassError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Фамилия невалидно')]")
    WebElement lastnameError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Имя невалидно')]")
    WebElement firstnameError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Email невалидно')]")
    WebElement emailError;

    @FindBy(xpath = ".//div[contains(.,'Значение поля Город невалидно')]")
    WebElement cityError;

    public void checkMailError (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver, ".//div[contains(.,'Значение поля Email невалидно')]", 90, 'x');
        Assert.assertTrue(emailError.isDisplayed());
    }
    public void checkCityError (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver, ".//div[contains(.,'Значение поля Город невалидно')]", 90, 'x');
        Assert.assertTrue(cityError.isDisplayed());
    }
    public void checkLastnameError (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver, ".//div[contains(.,'Значение поля Фамилия невалидно')]", 90, 'x');
        Assert.assertTrue(lastnameError.isDisplayed());
    }
    public void checkFirstnameError (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver,".//div[contains(.,'Значение поля Имя невалидно')]", 90, 'x');
        Assert.assertTrue(firstnameError.isDisplayed());
    }


    public void checkMinPass (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver,".//div[contains(.,'Значение поля Пароль должно содержать минимум 6 символа.')]", 90, 'x');
        Assert.assertTrue(minPassError.isDisplayed());
    }

    public void checkMaxLastName (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver,".//div[contains(.,'Значение поля Фамилия должно содержать максимум 60 символов.')]", 90, 'x');
        Assert.assertTrue(maxLastNameError.isDisplayed());
    }
    public void checkMinLastName (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver,".//div[contains(.,'Значение поля Фамилия должно содержать минимум 2 символа.')]", 90, 'x');
        Assert.assertTrue(minLastNameError.isDisplayed());
    }
    public void checkMinFirstName (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver,".//div[contains(.,'Значение поля Имя должно содержать минимум 2 символа.')]", 90, 'x');
        Assert.assertTrue(minFirstNameError.isDisplayed());
    }
    public void checkMaxFirstName (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver,".//div[contains(.,'Значение поля Имя должно содержать максимум 60 символов.')]", 90, 'x');
        Assert.assertTrue(maxFirstNameError.isDisplayed());
    }
    public void checkMaxCity (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver,".//div[contains(.,'Значение поля Город должно содержать максимум 60 символов.')]", 90, 'x');
        Assert.assertTrue(maxCityError.isDisplayed());
    }
    public void checkMaxApteka (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver,".//div[contains(.,'Значение поля Аптечное предприятие должно содержать максимум 60 символов.')]", 90, 'x');
        Assert.assertTrue(maxAptekaError.isDisplayed());
    }
    public void checkMaxPass (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver,".//div[contains(.,'Значение поля Пароль должно содержать максимум 30 символов.')]", 90, 'x');
        Assert.assertTrue(maxPassError.isDisplayed());
    }
    public void checkNullPass (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver,".//div[contains(.,'Необходимо заполнить поле Пароль')]", 90, 'x');
        Assert.assertTrue(nullPassError.isDisplayed());
    }
    public void checkNullFirstName (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver, ".//div[contains(.,'Необходимо заполнить поле Имя')]", 90, 'x');
        Assert.assertTrue(nullFirstNameError.isDisplayed());
    }
    public void checkNullLastName (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver, ".//div[contains(.,'Необходимо заполнить поле Фамилия')]", 90, 'x');
        Assert.assertTrue(nullLastNameError.isDisplayed());
    }
    public void checkNullPhone (WebDriver driver) throws InterruptedException {
        Assert.assertTrue(nullPhoneError.isDisplayed());
    }

    public void clickLogOutButton(WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//a[contains(.,'Выйти')]", 10, 'x');
        Assert.assertTrue(logOutButton.isDisplayed());
        logOutButton.click();
        Waiter.wait(driver, ".//a[contains(.,'Войти')]", 10, 'x');
        Assert.assertTrue(driver.getCurrentUrl().equals("http://front.dev.mgrnix.com:53580/"));
    }


    public void putLastname(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupmvpform-lastname", 10, 'i');
        Assert.assertTrue(lastName.isDisplayed());
        lastName.clear();
        lastName.sendKeys(text);
    }

    public void clickRegButton(WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//a[contains(.,'Регистрация')]", 10, 'x');
        Assert.assertTrue(regButton.isDisplayed());
        regButton.click();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://front.dev.mgrnix.com:53580/register"));
    }

    public void putFirstname(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupmvpform-firstname", 10, 'i');
        Assert.assertTrue(firstName.isDisplayed());
        firstName.clear();
        firstName.sendKeys(text);
    }

    public void putApteka(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupmvpform-company", 10, 'i');
        Assert.assertTrue(apteka.isDisplayed());
        apteka.clear();
        apteka.sendKeys(text);
        apteka.click();
        telephone.click();
    }

    public void putMail(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupmvpform-email", 10, 'i');
        Assert.assertTrue(mail.isDisplayed());
        mail.clear();
        mail.sendKeys(text);
        mail.click();
    }

    public void putPhone(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupmvpform-phone", 10, 'i');
        Assert.assertTrue(telephone.isDisplayed());
        telephone.clear();
        telephone.sendKeys(text);
    }

    public void putCity(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupmvpform-city", 10, 'i');
        Assert.assertTrue(city.isDisplayed());
        city.clear();
        city.sendKeys(text);
        city.click();
        mail.click();
        city.click();
        firstName.click();
    }

    public void putPass(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupmvpform-password", 10, 'i');
        Assert.assertTrue(password.isDisplayed());
        password.clear();
        password.sendKeys(text);
        mail.click();
    }

    public void clickEnter (WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, "btnCreateUser", 10, 'i');
        Assert.assertTrue(enterButton.isDisplayed());
        Thread.sleep(4000);
        enterButton.click();
        Thread.sleep(4000);
//        enterButton.click();
    }

    public void checkRegOk (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver, ".//a[contains(.,'Выйти')]", 90, 'x');
        Assert.assertTrue(driver.getCurrentUrl().equals("http://front.dev.mgrnix.com:53580/profile"));
    }
}
