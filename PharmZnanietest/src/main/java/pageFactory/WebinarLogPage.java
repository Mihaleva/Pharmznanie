package pageFactory;

import Help.Waiter;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by mihaleva on 08.04.2016.
 */
public class WebinarLogPage {

    public WebinarLogPage (WebDriver driver) {
//Нужно инициализировать page object.
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = ".//a[contains(.,'Выйти')]")
    WebElement logOutButton;

    @FindBy(xpath = ".//a[contains(.,'Войти')]")
    WebElement logInButton;

    @FindBy(xpath = ".//a[contains(.,'Смотреть')]")
    WebElement view;

    @FindBy(xpath = ".//*[@class=\"btn btn-lg btn-lbl btn-pink\"]")
    WebElement banner;

    @FindBy(xpath = ".//*[@class=\"btn btn-success\"]")
    WebElement enter;

    @FindBy(xpath = ".//*[@class=\"btn btn-primary\"]")
    WebElement register;



    public void clickView (WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//a[contains(.,'Смотреть')]", 10, 'x');
        Assert.assertTrue(view.isDisplayed());
        view.click();

    }
    public void clickViewAndRegister(WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//a[contains(.,'Смотреть')]", 10, 'x');
        Assert.assertTrue(view.isDisplayed());
        view.click();
        Waiter.wait(driver, ".//*[@class=\"btn btn-lg btn-lbl btn-pink\"]", 10, 'x');
        banner.click();
        Thread.sleep(3000);
        String parentWindowId = driver.getWindowHandle();

        //Clicking Help Button will open Help Page in a new Popup Browser Window
        try {
            //Switch to the Help Popup Browser Window
            driver.switchTo().window("modal-content");

        } catch (NoSuchWindowException e) {
            e.printStackTrace();
        }
        Waiter.wait(driver, ".//*[@class=\"btn btn-primary\"]", 10, 'x');
        register.click();

    }

    public void clickLogOutButton(WebDriver driver) throws InterruptedException {

        Waiter.wait(driver, ".//a[contains(.,'Выйти')]", 10, 'x');
        Assert.assertTrue(logOutButton.isDisplayed());
        logOutButton.click();
        Waiter.wait(driver, ".//a[contains(.,'Войти')]", 10, 'x');
        Assert.assertTrue(driver.getCurrentUrl().equals("http://front.dev.mgrnix.com:53580/"));
    }


}

