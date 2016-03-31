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
public class ProfilePage {

    public ProfilePage(WebDriver driver) {
//Нужно инициализировать page object.
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[contains(.,'Выйти')]")
    WebElement logOutButton;


    public void clickLogOutButton(WebDriver driver) throws InterruptedException {

        //Waiter.wait(driver, ".//a[contains(.,'Выйти')]", 10, 'x');
        //Assert.assertTrue(logOutButton.isDisplayed());
        logOutButton.click();
        Waiter.wait(driver, ".//a[contains(.,'Войти')]", 10, 'x');
        Assert.assertTrue(driver.getCurrentUrl().equals("http://front.dev.mgrnix.com:53580/"));
    }


}
