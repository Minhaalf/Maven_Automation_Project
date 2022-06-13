package Action_Items.AmeriSourceBergen_Project;

import Reusable_Library.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class actionItem6_noLoggersTest {
    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    //before suite will set the driver you are using
    @BeforeSuite
    public void setChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of before suite annotation

    //UC1: As a user I want to be able to contact AmerisourceBergen so that I can talk to someone in case I have any issues.
    @Test
    public void contactAmeriSourceBergen() throws InterruptedException {
        //navigate to AmeriSourceBergen.com
        driver.navigate().to("https://www.amerisourcebergen.com/");
        //I should be able to click “Contact Us”
        Reusable_Actions.clickByIndexActions(driver,"//*[contains(text(),'Contact us')]",0,"Contact Us");
        //I should be able to copy AmerisourceBergen's phone number and fax number
        String phoneNumber = Reusable_Actions.getTextAction(driver,"//*[contains(text(),'610.727.7000')]","Phone Number");
        System.out.println("Amerisourcebergens phone number is " +phoneNumber);
        //and wait statement
        Thread.sleep(4000);

        //I should be able to fill out a contact us form
        //enter name
        Reusable_Actions.clickActions(driver,"//*[@class='half-section form-field form-field--text']","NAME");
        /*
        Reusable_Actions.sendKeysAction(driver,"//*[@id='fxb_18404c7d-e0ee-431d-bea9-df6f6578fb9d_Fields_b024cb13-6e6c-46f5-a337-845e37f4cfc9__Value']","Micheal Ferro","Name input Field");
        //enter email
        Reusable_Actions.sendKeysAction(driver,"//*[@id='fxb_18404c7d-e0ee-431d-bea9-df6f6578fb9d_Fields_48a979e5-2a5e-490c-bf79-2c9b3521a5bc__Value']","MichealF@gmail.com","Email input Field");
        //enter phone number
        Reusable_Actions.sendKeysAction(driver,"//*[@id='fxb_18404c7d-e0ee-431d-bea9-df6f6578fb9d_Fields_5e11afd7-956d-4f88-90cb-adfaf7a9fd63__Value']","5167243675","Phone Number input Field");
        //enter my company name
        Reusable_Actions.sendKeysAction(driver,"//*[@id='fxb_18404c7d-e0ee-431d-bea9-df6f6578fb9d_Fields_dd1b2904-3879-4fd0-a1a8-ccf15036a024__Value']","Tech Company","Company Name input Field");
        //Enter subject
        Reusable_Actions.sendKeysAction(driver,"","Interested in your services","Subject input Field");
        //Enter my message
        Reusable_Actions.sendKeysAction(driver,"","Hi my name is Micheal. I would like to see how your company can help me with distribution","Message input Field");
        //select my region from region dropdown menu
        //select my message topic from message topic dropdown

         */




    }




    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of AfterSuite
}
