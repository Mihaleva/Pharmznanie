package Help;
import base.BaseTest;
import com.sun.jna.platform.win32.WinDef;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mihaleva on 21.03.2016.
 */
 public class Waiter extends BaseTest {

    public static void  wait(WebDriver driver, String xpath, Integer time, Character X) throws InterruptedException {
        switch (X) {
            case 'i':
                new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(By.id(xpath)));
                break;
            case 'x':
                new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                break;
            case 'c':
                new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(By.className(xpath)));
                break;
            case 'n':
                new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(By.name(xpath)));
                break;
        }

    }
}