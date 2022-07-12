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

public class ReportPage extends BasePage{

    public ReportPage(WebDriver driver) {
        super(driver);
    }

    private static String URL = "http://13.40.142.158:8080/#/reports/";

    private static By ALL_REPORT_VALUES = By.cssSelector(".hljs-value");

    private static By AFTER_BUTTON = By.cssSelector("#page-wrapper > div > div > div > div.row-fluid.ng-scope > div.col-lg-1.v-align.min-widget-md > p > label:nth-child(2)");

    private static By MINUTES_DOWN = By.cssSelector("[ng-click='decrementMinutes()'] .glyphicon-chevron-down");

    private static By VIEW_SUBMIT_REPORT = By.cssSelector("[ng-click='submit()']");

    private static By COUNT_NUMBER_OF_REPORTS = By.cssSelector("#reports tr");

    private static By RESULTS_HEADER = By.id("checkout-screen-header");

    private static By SUCCESS_CONFIRMATION = By.id("#message");
    public void goTo(){
        driver.get(URL);
    }

    public void countInstancesOfString(String valueCheck, int countExpected){
        int countOfValue=0;
        List<WebElement> allReports = driver.findElements(ALL_REPORT_VALUES);
        for (WebElement reportValue:allReports){
            System.out.println(reportValue.getText());
            if(reportValue.getText().equals(valueCheck)){
                countOfValue += 1;
            }
        }
        System.out.println(countOfValue);
        Assert.assertEquals(countExpected,countOfValue);
    }

    public void setReportConditions(){
        waitAndClick(AFTER_BUTTON);
        for(int i=0;i<3;i++){
            waitAndClick(MINUTES_DOWN);
        }
        waitAndClick(VIEW_SUBMIT_REPORT);
    }

    public void countNumberOfReports(long expectedCount){
        driver.navigate().refresh();
        List<WebElement> allReports = driver.findElements(COUNT_NUMBER_OF_REPORTS);
        Assert.assertEquals(expectedCount,allReports.size());
    }

    public void checkIfSuccess(){
        WebElement resultsBox = driver.findElement(RESULTS_HEADER);
        Assert.assertEquals("Result: Success",resultsBox.getText());
    }

    public void checkIfFail(){
        WebElement resultsBox = driver.findElement(RESULTS_HEADER);
        Assert.assertEquals("Result: Failure",resultsBox.getText());
    }
}
