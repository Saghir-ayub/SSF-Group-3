package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by jack.forman on 22/10/2016.
 */
public class SimpleMerchantPage extends BasePage {

    private static final By CREDIT_CARD_NUMBER = By.id("number");

    private static final By FIRST_NAME = By.id("first_name");

    private static final By LAST_NAME = By.id("last_name");

    private static final By EXPIRY_MONTH = By.id("month");

    private static final By EXPIRY_YEAR = By.id("year");

    private static final By VERIFICATION_CODE = By.id("verification_value");

    private static final By AMOUNT = By.id("amount");

    private static final By CURRENCY = By.cssSelector(".form-control option");

    private static final By PURCHASE_REQUEST = By.cssSelector("[name='commit']");

    private static final By RETURN_INCORRECT_PASSWORD = By.cssSelector("[title='Return with an invalid password']");
    private static final By AUTHENTICATION_SUBMIT_BUTTON = By.cssSelector("#acs-submit");

    public SimpleMerchantPage(WebDriver driver) {
        super(driver);
    }

    public void enterCreditCardNumber(String creditCardNumber){
        findAndType(CREDIT_CARD_NUMBER,creditCardNumber);
    }

    public void enterFirstName(String firstName){
        findAndType(FIRST_NAME,firstName);
    }

    public void enterLastName(String lastName){
        findAndType(LAST_NAME,lastName);
    }

    public void enterExpirationMonth(String expiryMonth){
        findAndType(EXPIRY_MONTH,expiryMonth);
    }

    public void enterExpirationYear(String expiryYear){
        findAndType(EXPIRY_YEAR,expiryYear);
    }

    public void enterVerificationCode(String verificationCode){
        findAndType(VERIFICATION_CODE,verificationCode);
    }

    public void enterAmount(String amount){
        findAndType(AMOUNT,amount);
    }

    public void selectCurrency(int currency012){
        waitAndSubmit(CURRENCY,currency012);
    }

    public void submitPurchaseRequest(){waitAndClick(PURCHASE_REQUEST);}

    public void setReturnIncorrectPassword(){waitAndClick(RETURN_INCORRECT_PASSWORD);}

    public void clickAuthenticationSubmitButton(){
//        WebElement authButton = driver.findElement(AUTHENTICATION_SUBMIT_BUTTON);
//        authButton.click();
        driver.switchTo().frame("acsframe");
        waitAndClick(AUTHENTICATION_SUBMIT_BUTTON);
    }

}
