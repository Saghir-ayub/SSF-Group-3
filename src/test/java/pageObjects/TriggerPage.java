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
    private static String URL = "http://13.40.142.158:8080/#/";

    private static final By ROWS_IN_TRIGGERS = By.cssSelector(".behaviour-row");

    private static final By DELETE_BEHAVIOUR_BUTTON = By.id("delete-behaviour-button");

    private static final By NEW_BEHAVIOUR_BUTTON = By.id("new-behaviour-button");

    private static final By CONFIRM_DELETE_BUTTON = By.cssSelector("[data-bb-handler='confirm']");

    private static final By ANY_TRIGGER = By.cssSelector("[label='Any']");
    private static final By XML_TRIGGER = By.cssSelector("[label='XML: XPath']");
    private static final By XML_INPUT = By.cssSelector("[name='xpath']");
    private static final By CARD_NUMBER_TRIGGER = By.cssSelector("[label='Realex: Card number']");
    private static final By CARD_NUMBER_INPUT = By.cssSelector("[name='number']");
    private static final By TYPE_OF_REQUEST_INPUT = By.cssSelector("[name='requestType'] option");
    private static final By NAME_OF_CARD_HOLDER_TRIGGER = By.cssSelector("[label='Realex: Name of card holder']");
    private static final By NAME_OF_CARD_HOLDER_INPUT = By.cssSelector("[name='name']");
    private static final By PENCE_TRIGGER = By.cssSelector("[label='Realex: Pence']");
    private static final By PENCE_AMOUNT = By.cssSelector("[name='pence']");
    private static final By AUTH_REQUEST_TRIGGER = By.cssSelector("[label='Realex: Is an Auth request']");
    private static final By ENROLLED_REQUEST_TRIGGER = By.cssSelector("[label='Realex: Is a Verify Enrolled request']");
    private static final By SIG_REQUEST_TRIGGER = By.cssSelector("[label='Realex: Is a Verify Sig request']");
    private static final By VOID_REQUEST_TRIGGER = By.cssSelector("[label='Realex: Is a void request']");

    private static final By RESPONSE_TYPE_LIST = By.cssSelector("[name='responseForm'] option");

    private static final By CUSTOM_TEXT_RESPONSE = By.cssSelector("[label='Custom text response']");

    private static final By DESCRIPTION_OF_RESPONSE = By.cssSelector("[name='description']");

    private static final By RESPONSE_TO_CLIENT = By.cssSelector("[name='response']");
    private static final By SAVE_BEHAVIOUR = By.id("save-button");


    public void goTo(){
        driver.get(URL);
    }

    public void navigateToAndDeleteBehaviour(){
        wait.until(ExpectedConditions.elementToBeClickable(NEW_BEHAVIOUR_BUTTON));
        List<WebElement> rowsInTriggers = driver.findElements(ROWS_IN_TRIGGERS);
        System.out.println(rowsInTriggers.size());
        for(WebElement rowToBeClicked:rowsInTriggers){
            wait.until(ExpectedConditions.elementToBeClickable(rowToBeClicked)).click();
            waitAndClick(DELETE_BEHAVIOUR_BUTTON);
            waitAndClick(CONFIRM_DELETE_BUTTON);
        }
    }

    public void navigateToNewBehaviour(){waitAndClick(NEW_BEHAVIOUR_BUTTON);}

    public void triggerAny(){waitAndClick(ANY_TRIGGER);}
    public void triggerXml(String XPath){
        waitAndClick(XML_TRIGGER);
        findAndType(XML_INPUT,XPath);
    }
    public void triggerCardNumber(String cardNumber,String typeOfRequest){
        waitAndClick(CARD_NUMBER_TRIGGER);
        findAndType(CARD_NUMBER_INPUT,cardNumber);
        typeOfRequest(typeOfRequest);
    }
    public void triggerNameOfCardHolder(String nameOfCardHolder, String typeOfRequest){
        waitAndClick(NAME_OF_CARD_HOLDER_TRIGGER);
        findAndType(NAME_OF_CARD_HOLDER_INPUT,nameOfCardHolder);
        typeOfRequest(typeOfRequest);

    }
    public void triggerPence(String penceAmount,String typeOfRequest){
        waitAndClick(PENCE_TRIGGER);
        findAndType(PENCE_AMOUNT,penceAmount);
        typeOfRequest(typeOfRequest);
    }
    public void triggerAuthRequest(){waitAndClick(AUTH_REQUEST_TRIGGER);}
    public void triggerEnrolledRequest(){waitAndClick(ENROLLED_REQUEST_TRIGGER);}
    public void triggerSigRequest(){waitAndClick(SIG_REQUEST_TRIGGER);}
    public void triggerVoidRequest(){waitAndClick(VOID_REQUEST_TRIGGER);}

    public void typeOfRequest(String typeOfRequest){
        List<WebElement> typesOfRequests = driver.findElements(TYPE_OF_REQUEST_INPUT);
        for(WebElement request:typesOfRequests){
            if (request.getText().equals(typeOfRequest)){
                request.click();
            }
        }
    }

    public void responseTypeList(String responseChoice){
        wait.until(ExpectedConditions.elementToBeClickable(SAVE_BEHAVIOUR));
        List<WebElement> listOfResponseTypes = driver.findElements(RESPONSE_TYPE_LIST);
        for(WebElement response:listOfResponseTypes){
            if(response.getText().equals(responseChoice)){
                response.click();
                break;
            }
        }
    }

    public void setCustomTextResponse(String description, String response){
        waitAndClick(CUSTOM_TEXT_RESPONSE);
        findAndType(DESCRIPTION_OF_RESPONSE,description);
        findAndType(RESPONSE_TO_CLIENT,response);
    }
    public void saveBehaviour(){waitAndClick(SAVE_BEHAVIOUR);}

}
