package Day9_052222;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class P4_USPS_Reusable_Concepts {
    public static void main(String[] args) throws InterruptedException {

        //setting the local driver to reusable setDriver Method
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to USPS.com
        driver.navigate().to("https://www.usps.com");

        //hovering to the quick tools
        Reusable_Actions.mouseHover(driver,"//*[text()='Quick Tools']","Quick Tools");

        //hover to the send tab
        Reusable_Actions.mouseHover(driver,"//*[@id='mail-ship-width']","Send Tab ");

        //click on "Calculate a Price"
        Thread.sleep(1200);
        Reusable_Actions.clickActions(driver,"//*[@class='tool-calc']","Calculate a Price");

        //print out header text info
        String result = Reusable_Actions.getTextAction(driver,"//*[@class='header-usps row']","Header Info");
        System.out.println("My header info is " + result);

        //enter the zip code
        Reusable_Actions.sendKeysAction(driver,"//*[@name='Origin']","11003","Zip Code Search Field");


        //quit driver
        Thread.sleep(2500);
        driver.quit();





    }//end of main
}//end of java class
