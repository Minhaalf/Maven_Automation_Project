package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions_Loggers {
    //Set a static time out variable so it can cover all methods
    static int timeOut = 12;
    //reusable function for WebDriver as a return method
    public static WebDriver setDriver(){
        //setup your chromedriver with WebdriverManager
        WebDriverManager.chromedriver().setup();

        //SET UP CHROMEOPTIONS

        //define the chromeoptions
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-fullscreen");
        //options.addArguments("start-maximized") //FOR WINDOWS
        //Setting your driver as headless (running in the Background)
        //options.addArguments("headless");

        //define the webdriver i am going to use with ChromeOptions
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver Method

    //create a mouse hover method logger
    public static void mouseHover (WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully able to hover mouse over " + elementName);


        }catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " +e);
            logger.log(LogStatus.FAIL,"Unable to hover on element " + elementName + " " +e);
        }//end of exception
    }//end of mouse hover method


    //create a click method logger
    public static void clickActions (WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully able to click on element " + elementName);

        }catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " +e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " +e);
        }//end of exception
    }//end of click method

    //create a sendKeys method logger
    public static void sendKeysAction (WebDriver driver, String xpath,String userValue,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully entered uservalue on element" +elementName);

        }catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + " " +e);
            logger.log(LogStatus.FAIL,"Unable to send keys on element " + elementName + " " +e);
        }//end of exception
    }//end of sendKeys method

    //create a getText method logger
    public static String getTextAction (WebDriver driver, String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully captured text on element " +elementName);

        }catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " +e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " +e);
        }//end of exception
        return result;
    }//end of getText method

    //create a click by index method
    public static void clickByIndexActions (WebDriver driver, String xpath, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS,"Successfully able to click on " +elementName);

        }catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " +e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " +e);
        }//end of exception
    }//end of clickByIndexAction

    //create a getTitle method
    public static String verifyTitleAction (WebDriver driver, String expectedTitle, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        String result = null;
        try {
            String title = driver.getTitle();
            result = title;
            if (title.equals(expectedTitle)) {
                System.out.println("My title matches");
            }else{
                System.out.println("Title does not match. Actual title is " + title);
            }//end of conditions

        }catch (Exception e) {
            System.out.println("Unable to capture title on Webpage " + elementName + " " + e);
        }//end of exception
        return result;
    }//end of getTitle method


    //create a switch to tabs by index method
    public static void switchTabsByIndexAction (WebDriver driver, int indexNumber) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(indexNumber));
            Thread.sleep(1500);
        }catch (Exception e){
            System.out.println("Unable to switch");
        }
    }//end of switch to tabs by index


    //create a selectByText action
    public static void selectByText (WebDriver driver,String xPath, ExtentTest logger ,String visibleText) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            WebElement dropDownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
            //define select command
            Select selectDropDown = new Select(dropDownElement);
            //call select command and select by visible text
            selectDropDown.selectByVisibleText(visibleText);
            logger.log(LogStatus.PASS,"Successfully able to select " +visibleText + " from dropdown menu");
        }catch (Exception e){
            System.out.println("Unable to select " +visibleText + " from dropdown menu " +e);
            logger.log(LogStatus.FAIL,"Unable to select " +visibleText + " from dropdown menu " +e);
        }
    }//end of selectByText action

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " +elementName + " " + e);
        }
    }//end of submit

    //create a click method
    public static void clickAction(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
        }
    }//end of clickAction



}//end of java class
