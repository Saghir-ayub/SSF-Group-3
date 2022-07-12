package Tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.ReportPage;
import pageObjects.SimpleMerchantPage;
import pageObjects.TriggerPage;

import static Tests.TestSuite.driverFactory;

/**
 * Created by jack.forman on 08/11/2016.
 */
public class SimpleMerchant {

    public static WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private SimpleMerchantPage merchantPage = new SimpleMerchantPage(driver);
    private TriggerPage triggers = new TriggerPage(driver);

    private ReportPage reports = new ReportPage(driver);

    /**Delete all current behaviours for setup
     *Navigates to new behaviour
     */
    @Before
    public void individualSetUp(){
        triggers.goTo();
        triggers.navigateToAndDeleteBehaviour();
        triggers.navigateToNewBehaviour();
    }

    /**Make a user request
     * Fill all the input fields
     */

    @Test
    public void CardNotEnrolledThenAuthSuccess(){
        triggers.triggerCardNumber("4242424242424242","3ds-verifyenrolled");
        triggers.responseTypeList("RealMpi VerifyEnrolled: Verify Enrolled always successful");
        triggers.saveBehaviour();
        triggers.navigateToNewBehaviour();
        triggers.triggerCardNumber("4242424242424242","3ds-verifysig");
        triggers.responseTypeList("Realex: Always successful");
        triggers.saveBehaviour();
        triggers.navigateToNewBehaviour();
        triggers.triggerCardNumber("4242424242424242","auth");
        triggers.responseTypeList("RealMpi VerifySig: Successful authentication");
        triggers.saveBehaviour();
        homepage.goTo();
        merchantPage.enterCreditCardNumber("4242424242424242");
        merchantPage.enterFirstName("Saghir");
        merchantPage.enterLastName("Ayub");
        merchantPage.enterExpirationMonth("1");
        merchantPage.enterExpirationYear("2025");
        merchantPage.enterVerificationCode("123");
        merchantPage.enterAmount("1234999");
        merchantPage.selectCurrency(1);
        merchantPage.submitPurchaseRequest();
        merchantPage.clickAuthenticationSubmitButton();
        reports.checkIfSuccess();
    }

    @Test
    public void CardNotEnrolledThenAuthFail(){
        triggers.triggerCardNumber("4242424242424242","3ds-verifyenrolled");
        triggers.responseTypeList("RealMpi VerifyEnrolled: Verify Enrolled always successful");
        triggers.saveBehaviour();
        triggers.navigateToNewBehaviour();
        triggers.triggerCardNumber("4242424242424242","3ds-verifysig");
        triggers.responseTypeList("RealMpi VerifySig: Authentication Unavailable");
        triggers.saveBehaviour();
        triggers.navigateToNewBehaviour();
        triggers.triggerCardNumber("4242424242424242","auth");
        triggers.responseTypeList("RealMpi VerifySig: Successful authentication");
        triggers.saveBehaviour();
        homepage.goTo();
        merchantPage.enterCreditCardNumber("4242424242424242");
        merchantPage.enterFirstName("Saghir");
        merchantPage.enterLastName("Ayub");
        merchantPage.enterExpirationMonth("1");
        merchantPage.enterExpirationYear("2025");
        merchantPage.enterVerificationCode("123");
        merchantPage.enterAmount("1234999");
        merchantPage.selectCurrency(1);
        merchantPage.submitPurchaseRequest();
        merchantPage.clickAuthenticationSubmitButton();
        reports.checkIfFail();
    }



    @Test @Ignore
    public void triggerNameOfCardHolderCheck(){
        triggers.triggerNameOfCardHolder("Thai","any");
        triggers.responseTypeList("Default Realex simulation");
        triggers.saveBehaviour();
        homepage.goTo();
        merchantPage.enterCreditCardNumber("4242424242424242");
        merchantPage.enterFirstName("Thai");
        merchantPage.enterLastName("Lee");
        merchantPage.enterExpirationMonth("1");
        merchantPage.enterExpirationYear("2025");
        merchantPage.enterVerificationCode("123");
        merchantPage.enterAmount("1234999");
        merchantPage.selectCurrency(1);
        merchantPage.submitPurchaseRequest();
        reports.checkIfSuccess();
    }

    @Test
    public void triggerPenceCheck(){
        triggers.triggerPence("30","any");
        triggers.responseTypeList("Default Realex simulation");
        triggers.saveBehaviour();
        homepage.goTo();
        merchantPage.enterCreditCardNumber("4242424242424242");
        merchantPage.enterFirstName("Thai");
        merchantPage.enterLastName("Lee");
        merchantPage.enterExpirationMonth("1");
        merchantPage.enterExpirationYear("2025");
        merchantPage.enterVerificationCode("123");
        merchantPage.enterAmount("30");
        merchantPage.selectCurrency(0);
        merchantPage.submitPurchaseRequest();
        merchantPage.clickAuthenticationSubmitButton();
        reports.checkIfSuccess();
    }



}
