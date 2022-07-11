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

    private static final By CHECK_IF_ADD_ADDRESS_AVAILABLE = By.cssSelector(".add-address a");
    public SimpleMerchantPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(){
        waitAndClick(By.cssSelector("div.product-add-to-cart"));
    }


}
