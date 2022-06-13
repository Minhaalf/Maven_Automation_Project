package Day11_052922;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class P2_Boolean_With_Checkbox {
    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void setChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of before suite annotation

    @Test
    public void Yahoo_Stay_Signed_In_Checkbox_Verification() throws InterruptedException {
        //navigate to USPS.com
        driver.navigate().to("https://www.yahoo.com");
        //declare explicit wait for the tabs
        WebDriverWait wait = new WebDriverWait(driver,10);
        //click on Sign In
        Reusable_Actions.clickActions(driver,"//*[@class='_yb_1u2yu']","Sign In Button");
        //verify the stay signed in checkbox is selected or not
        boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='checkbox']"))).isSelected();
        //print out if check box is selected
        System.out.println("Is the checkbox selected? " +elementState);


    }//End of TEst

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of AfterSuite
}
