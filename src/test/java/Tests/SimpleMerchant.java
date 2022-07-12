package Tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
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

    /**Delete all current behaviours for setup
     *Navigates to new behaviour
     */
    @Before
    public void individualSetUp(){
        triggers.goTo();
        triggers.navigateToAndDeleteBehaviour();
        triggers.navigateToNewBehaviour();
        triggers.triggerXml("www.google.com");
//        triggers.responseTypeList("Default Realex simulation");
//        triggers.saveBehaviour();
//        triggers.navigateToNewBehaviour();
//        triggers.triggerCardNumber("1111222233334444","3ds-verifyenrolled");
//        triggers.responseTypeList("Default Realex simulation");
//        triggers.saveBehaviour();
        triggers.setCustomTextResponse("You failure","I said you failure");
        triggers.saveBehaviour();
    }

    /**Make a user request
     * Fill all the input fields
     */

    @Test
    public void testingTriggerOne(){
        homepage.goTo();
        merchantPage.enterCreditCardNumber("4242424242424242");
        merchantPage.enterFirstName("Saghir");
        merchantPage.enterLastName("Ayub");
        merchantPage.enterExpirationMonth("1");
        merchantPage.enterExpirationYear("2025");
        merchantPage.enterVerificationCode("123");
        merchantPage.enterAmount("1234999");
        merchantPage.selectCurrency();
        merchantPage.submitPurchaseRequest();
    }

    @Test @Ignore
    public void triggersAndResponseTypeExamples(){
//        triggers.triggerAny();
//        triggers.triggerXml("www.google.com");
//        triggers.triggerCardNumber("1111222233334444","3ds-verifyenrolled");
//        triggers.triggerNameOfCardHolder("Saghir Ayub","auth");
//        triggers.triggerPence("99","void");
//        triggers.triggerAuthRequest();
//        triggers.triggerEnrolledRequest();
//        triggers.triggerSigRequest();
//        triggers.triggerVoidRequest();
//        triggers.responseTypeList("Default Realex simulation");
//        triggers.saveBehaviour();
    }


    /** Proceed to checkout - not signed in
     * Pre-Condition - Must have one item in basket && not be signed in
     * Navigate to basket
     * Click proceed to checkout
     * Verify sign in page displayed
     */
    @Test
    public void proceedToCheckoutNotLoggedIn(){

    }

    /** Proceed to checkout - signed in
     * Pre-Condition - Must have one item in basket && be signed in
     * Navigate to basket
     * Click proceed to checkout
     * Delivery Address Page is shown
     * Click proceed to checkout
     * Shipping page is shown
     * Agree to terms of service
     * Click proceed to checkout
     * Payment page is displayed
     * Click pay by bank wire
     * Confirm order
     * Order confirmation page is displayed
     */
    @Test
    public void proceedToCheckoutAndBuyLoggedIn(){

    }



}
