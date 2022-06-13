package Day10_052822;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class P2_TestNG_ForLoop {
    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver () {
        driver = Reusable_Actions.setDriver();
    }//end of before suit annotation

    //test case 1: navigate to google and enter a keyword on search field
    //test case 1: navigate to google and enter a keyword on search field
    @Test
    public void SearchForKeyword(){
        ArrayList<String> cars = new ArrayList();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Tesla");
        for(int i = 0; i<cars.size();i++) {
            driver.navigate().to("https://www.google.com");
            //enter a keyword on search field
            Reusable_Actions.sendKeysAction(driver, "//*[@name='q']", cars.get(i), "Search Field");
            //submit the go button
            Reusable_Actions.submitAction(driver, "//*[@name='btnK']", "Google Search Button");
            //capture search result
            String result = Reusable_Actions.getTextAction(driver, "//*[@id='result-stats']", "Search Result Text");
            //split the result by single space and print out the search number
            String[] arrayResult = result.split(" ");
            System.out.println("Search number for " + cars.get(i) + " is " + arrayResult[1]);
        }//end of loop
    }//end of test

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite
}
