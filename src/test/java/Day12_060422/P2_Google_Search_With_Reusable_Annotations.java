package Day12_060422;

import ReusableClasses.Reusable_Annotations_Class;
import Reusable_Library.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class P2_Google_Search_With_Reusable_Annotations extends Reusable_Annotations_Class {



    //test case 1: navigate to google and enter a keyword on search field
    @Test(priority = 1)
    public void GoogleSearchForKeyword(){
        driver.navigate().to("https://www.google.com");
        //enter a keyword on the search field
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit the go button
        Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search Button");

    }//end of Test 1
    /*dependsOnMethods used when  following @Test is dependent on previous @Test method. Then If the first test fails,
        the dependent test will get skipped*/
    @Test(dependsOnMethods = "GoogleSearchForKeyword")
    public void CaptureSearchNumber(){
        //capture search result
        String result = Reusable_Actions_Loggers.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Result Text");
        //split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);

    }//end of test 2

}

