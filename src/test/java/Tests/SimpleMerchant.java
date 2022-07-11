package Tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.SimpleMerchantPage;

import static Tests.TestSuite.driverFactory;

/**
 * Created by jack.forman on 08/11/2016.
 */
public class SimpleMerchant {

    public static WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private SimpleMerchantPage merchantPage = new SimpleMerchantPage(driver);


    @Before
    public void individualSetUp(){
        homepage.goTo();
    }

    /**Make a user request
     * Fill all the input fields
     */

    @Test
    public void testingTriggerOne(){
        homepage.goTo();
        merchantPage.enterCreditCardNumber("1123");
        merchantPage.enterFirstName("Saghir");
        merchantPage.enterLastName("Ayub");
        merchantPage.enterExpirationMonth("1");
        merchantPage.enterExpirationYear("1999");
        merchantPage.enterVerificationCode("123");
        merchantPage.enterAmount("1234999");
        merchantPage.selectCurrency();
    }

    /**Remove item from shopping cart
     * Pre-Condition - Item must be in basket
     * Navigate to basket
     * Click Delete
     * Verify Item is removed from Basket
     * Extension - verify pricing and totals are updated to reflect accurately
     */
    @Test
    public void removeItemFromShoppingBasket(){

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
