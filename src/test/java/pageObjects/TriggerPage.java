package pageObjects;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by jack.forman on 22/10/2016.
 */
public class TriggerPage extends BasePage {

    public TriggerPage(WebDriver driver) {
        super(driver);
    }
    private static String URL = "http://35.177.167.86:8080/#/";

    private static final By ROWS_IN_TRIGGERS = By.cssSelector(".behaviour-row");

    private static final By DELETE_BEHAVIOUR_BUTTON = By.id("delete-behaviour-button");

    private static final By NEW_BEHAVIOUR_BUTTON = By.id("new-behaviour-button");

    private static final By CONFIRM_DELETE_BUTTON = By.cssSelector("[data-bb-handler='confirm']");

    public void goTo(){
        driver.get(URL);
    }

    public void navigateToAndDeleteBehaviour(){
        WebElement waitingElement = wait.until(ExpectedConditions.elementToBeClickable(NEW_BEHAVIOUR_BUTTON));
        List<WebElement> rowsInTriggers = driver.findElements(ROWS_IN_TRIGGERS);
        System.out.println(rowsInTriggers.size());
        for(WebElement rowToBeClicked:rowsInTriggers){
            wait.until(ExpectedConditions.elementToBeClickable(rowToBeClicked)).click();
            waitAndClick(DELETE_BEHAVIOUR_BUTTON);
            waitAndClick(CONFIRM_DELETE_BUTTON);
        }
    }
}
