package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by jack.forman on 22/10/2016.
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private static String URL = "http://35.177.167.86:3000/";
   public void goTo(){
        driver.get(URL);
   }


}
