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

    String url = "http://front.dev.mgrnix.com:53580/";
    String urlLan = "http://pharmznanie.ru/";



    public void navigate() {

        driver.get(url);
    }
    public void navigateLan() {

        driver.get(urlLan);
    }

    public void kill() {

        driver.close();
    }
}
