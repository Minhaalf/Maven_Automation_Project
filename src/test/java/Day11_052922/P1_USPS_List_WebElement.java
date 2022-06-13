package Day11_052922;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class P1_USPS_List_WebElement  {
    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void setChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of before suite annotation

    @Test
        public void USPS_Tabs_Count() throws InterruptedException {
        //navigate to USPS.com
        driver.navigate().to("https://www.usps.com");
        //declare explicit wait for the tabs
        WebDriverWait wait = new WebDriverWait(driver,10);
        //store the navigation tabs as a list to get the count
        List<WebElement> tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'menuheader')]")));
        //print out the tabcount
        System.out.println("My tabs count is " + tabsCount.size());

        //use for loop to click on each tab
        for (int i = 0; i<tabsCount.size(); i++) {
            //redefine tabsCount so that forloop can recognize webelement
            tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'menuheader')]")));
            //click on each tab
            tabsCount.get(i).click();
            Thread.sleep(1000);
        }//end of for loop
    }//End of TEst

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of AfterSuite

}//end of class
