package Day11_052922;

import Reusable_Library.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class P3_Google_Search_HTML_Report {
    //declare the Local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void SetChromeDriver () {
        driver = Reusable_Actions.setDriver();
        //define the path to the reports
        reports = new ExtentReports("/Users/minhaalf/Desktop/Spring Automation Project/Maven_Automation_Project/src/main/java/HTML_Reports/Automation.html",true);
    }//end of before suit annotation

    //test case 1: navigate to google and enter a keyword on search field
    @Test(priority = 1)
    public void SearchForKeyword(){
        logger = reports.startTest("Search for a keyword");
        driver.navigate().to("https://www.google.com");
        //enter a keyword on the search field
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit the go button
        Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Seahc Button");
        //end the logger per test
        reports.endTest(logger);
    }//end of Test 1
    /*dependsOnMethods used when  following @Test is dependent on previous @Test method. Then If the first test fails,
        the dependent test will get skipped*/
    @Test(dependsOnMethods = "SearchForKeyword")
    public void CaptureSearchNumber(){
        logger = reports.startTest("Capture the search number");
        //capture search result
        String result = Reusable_Actions_Loggers.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Result Text");
        //split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
        logger.log(LogStatus.INFO,"Search number is " + arrayResult[1]);
        //end the logger per test
        reports.endTest(logger);
    }//end of test 2
///Users/minhaalf/Desktop/Spring Automation Project/Maven_Automation_Project/src/main/java/HTML_Reports
    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of after suite
}
