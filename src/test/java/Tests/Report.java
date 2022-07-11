package Tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.ReportPage;
import pageObjects.SimpleMerchantPage;

import static junit.framework.TestCase.assertTrue;
import static Tests.TestSuite.driverFactory;


/**
 * Created by jack.forman on 09/10/2016.
 */


public class Report {

    public static WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private SimpleMerchantPage basketpage = new SimpleMerchantPage(driver);
    private ReportPage reports = new ReportPage(driver);


    /**
     * This should make sure we are on the correct page, i.e. set up each test case so we can be sure that they run
     */
    @Before
    public void individualSetUp(){
        homepage.goTo();
    }

    @Test
    public void registerAlreadyRegistered(){

    }


    @After
    public void individualTearDown(){

    }

    @AfterClass
    public static void mainTearDown(){
        // Uncomment this when just running individual tests in this file.
        //driver.quit();
    }


}

