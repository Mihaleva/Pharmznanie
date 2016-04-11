package step;

import base.BaseSteps;
import org.openqa.selenium.WebDriver;
import pageFactory.*;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by mihaleva on 08.04.2016.
 */
public class StepWebinar extends BaseSteps {

    WebinarLogPage webPage = null;

    //YouTubeVideoPage youTubeVideoPage = null;


    public StepWebinar(WebDriver driver) {

        super(driver);
        webPage = new WebinarLogPage(driver);
    }


    @Step("click webinar")
    public StepWebinar openWebPage() throws InterruptedException {

        webPage.clickView(driver);
        return this;

    }
/*
    @Step("Click View")
    public StepWebinar clickGo() throws InterruptedException {

        webPage.clickGo(driver);
        return this;
    }

    @Step("Click View")
    public StepWebinar clickSubscribe() throws InterruptedException {

        webPage.clickSubscribe(driver);
        return this;
    }*/
}