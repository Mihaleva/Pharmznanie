package pageFactory;

import Help.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by mihaleva on 31.03.2016.
 */
public class Landing {

    public Landing (WebDriver driver) {
//Нужно инициализировать page object.
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "signupform-lastname")
    WebElement lastName;
//
    @FindBy(id = "signupform-firstname")
    WebElement firstName;

    @FindBy(id = "signupform-phone")
    WebElement telephone;

    @FindBy(id = "signupform-email")
    WebElement mail;

    @FindBy(id = "signupform-city")
    WebElement city;

    @FindBy(id = "signupform-company")
    WebElement apteka;

    @FindBy(id = "signupform-password")
    WebElement password;

    @FindBy(id = "btnCreateUser")
    WebElement enterButton;

    @FindBy(xpath = ".//div[contains(.,'Необходимо заполнить поле Фамилия')]")
    WebElement nullLastNameError;

    @FindBy(xpath = ".//div[contains(.,'Необходимо заполнить поле Имя')]")
    WebElement nullFirstNameError;

    @FindBy(xpath = ".//div[contains(.,'Необходимо заполнить поле Телефон')]")
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

    @FindBy(className = "modal-dialog")
    WebElement successPopup;


    public void checkReg (WebDriver driver) throws InterruptedException {
        Waiter.wait(driver, "modal-dialog", 90, 'c');
        Assert.assertTrue(successPopup.isDisplayed());
    }

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


    public void putLastname(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupform-lastname", 10, 'i');
        Assert.assertTrue(lastName.isDisplayed());
        lastName.clear();
        lastName.sendKeys(text);
    }

    public void putFirstname(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupform-firstname", 10, 'i');
        Assert.assertTrue(firstName.isDisplayed());
        firstName.clear();
        firstName.sendKeys(text);
    }

    public void putApteka(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupform-company", 10, 'i');
        Assert.assertTrue(apteka.isDisplayed());
        apteka.clear();
        apteka.sendKeys(text);
        apteka.click();
        telephone.click();
    }

    public void putMail(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupform-email", 10, 'i');
        Assert.assertTrue(mail.isDisplayed());
        mail.clear();
        mail.sendKeys(text);
        mail.click();
    }

    public void putPhone(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupform-phone", 10, 'i');
        Assert.assertTrue(telephone.isDisplayed());
        telephone.clear();
        telephone.sendKeys(text);
    }

    public void putCity(WebDriver driver, String text) throws InterruptedException {

        Waiter.wait(driver, "signupform-city", 10, 'i');
        Assert.assertTrue(city.isDisplayed());
        city.clear();
        city.sendKeys(text);
        city.click();
        mail.click();
        city.click();
        firstName.click();
    }

    public void clickEnter (WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, "btnCreateUser", 10, 'i');
        Assert.assertTrue(enterButton.isDisplayed());
        Thread.sleep(4000);
        enterButton.click();
        Thread.sleep(4000);
//        enterButton.click();
    }

}
