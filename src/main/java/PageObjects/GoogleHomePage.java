package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;
import java.util.List;

public class GoogleHomePage extends Reusable_Annotations_Class {
    //Declare the ExtentTest for each page object class. logger is local to each PO class
    ExtentTest logger;

    //create a constructor method hat will reference the same name as your class, you can make your
    //page object class methods static when you call it in your test class.
    public GoogleHomePage(WebDriver driver) {
        //page factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor

    //define all the web elements using @find by concept
    @FindBy(xpath = "//*[@name='q']")
    WebElement searchField;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googleSearchButton;
    @FindBy(xpath = "//*[@name='links']")
    List<WebElement> listLinks;

    public void searchUserValue(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver,searchField,userValue,logger,"Search Field");
    }//end of searhc field method

    public void submitOnGoogleSearch(){
        Reusable_Actions_POM_Loggers.submitAction(driver,googleSearchButton,logger,"Google Search Button");
    }//end of google search button



/*
BASE CLASS: Is reference of all of your page object classes.
Constructor: Bridge between the base class and your page object class. It creates a static reference between your
page object class and base class.


 */

}//end of java class
