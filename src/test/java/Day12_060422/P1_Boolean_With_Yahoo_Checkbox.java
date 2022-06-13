package Day12_060422;

import ReusableClasses.Reusable_Annotations_Class;
import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class P1_Boolean_With_Yahoo_Checkbox extends Reusable_Annotations_Class {


    @Test(priority = 1)
    public void Yahoo_Stay_Signed_In_Checkbox_Verification(){
        //navigate to usps
        driver.navigate().to("https://www.yahoo.com");
        //click on Sign in
        Reusable_Actions_Loggers.clickActions(driver,"//*[text()='Sign in']",logger,"Sign In");
        //verify the stay signed in checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver,10);
        boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        if(elementState){
            logger.log(LogStatus.PASS,"Checkbox is selected as expected");
        } else {
            logger.log(LogStatus.FAIL,"Checkbox is not selected");
        }
    }//end of test

    @Test(priority = 2)
    public void NavigateToYahooHome(){
        //navigate to yahoo
        logger.log(LogStatus.INFO,"Navigating to Home page");
        driver.navigate().to("https://www.yahoo.com");

    }//end of test 2


}
