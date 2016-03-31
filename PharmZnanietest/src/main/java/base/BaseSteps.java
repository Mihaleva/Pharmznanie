package base;

import org.openqa.selenium.WebDriver;

/**
 * Created by mihaleva on 03.03.2016.
 */
public class BaseSteps {

    public WebDriver driver = null;

    public BaseSteps(WebDriver driver){

        this.driver = driver;
    }

    String urlYou = "http://front.dev.mgrnix.com:53580/";


    public void navigate() {

        driver.get(urlYou);
    }

    public void kill() {

        driver.close();
    }
}
