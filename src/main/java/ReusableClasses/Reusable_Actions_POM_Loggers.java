package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class Reusable_Actions_POM_Loggers {
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
            getScreenShot(driver,elementName,logger);

        }//end of exception
    }//end of mouse hover method


    //create a click method logger
    public static void clickActions (WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.click();
            logger.log(LogStatus.PASS,"Successfully able to click on element " + elementName);

        }catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " +e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " +e);
            getScreenShot(driver,elementName,logger);

        }//end of exception
    }//end of click method

    //create a sendKeys method logger
    public static void sendKeysAction (WebDriver driver, WebElement xpath,String userValue,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.click();
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully entered uservalue on element" +elementName);

        }catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + " " +e);
            logger.log(LogStatus.FAIL,"Unable to send keys on element " + elementName + " " +e);
            getScreenShot(driver,elementName,logger);

        }//end of exception
    }//end of sendKeys method

    //create a getText method logger
    public static String getTextAction (WebDriver driver, WebElement xpath,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully captured text on element " +elementName);

        }catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " +e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " +e);
            getScreenShot(driver,elementName,logger);

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
    public static String verifyTitleAction (WebDriver driver,ExtentTest logger, String expectedTitle, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        String result = null;
        try {
            String title = driver.getTitle();
            result = title;
            if (title.equals(expectedTitle)) {
                System.out.println("My title matches");
                logger.log(LogStatus.PASS,"My title matches " +expectedTitle +" " +elementName);

            }else{
                System.out.println("Title does not match. Actual title is " + title);
                logger.log(LogStatus.FAIL,"Title does not match. Actual title is " + title + " for " + elementName);

            }//end of conditions

        }catch (Exception e) {
            System.out.println("Unable to capture title on Webpage " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture title on Webpage  " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
        return result;
    }//end of getTitle method


    //create a switch to tabs by index method
    public static void switchTabsByIndexAction (WebDriver driver,ExtentTest logger, int indexNumber) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(indexNumber));
            Thread.sleep(1500);
            logger.log(LogStatus.PASS,"Successfully able to switch tabs ");
        }catch (Exception e){
            System.out.println("Unable to switch tabs " + e);
            logger.log(LogStatus.FAIL,"Unable to switch tabs " + e);


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
            // getScreenShot(driver,elementName,logger);

        }
    }//end of selectByText action

    //create a submit method
    public static void submitAction(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " +elementName + " " + e);
            getScreenShot(driver,elementName,logger);

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
            getScreenShot(driver,elementName,logger);
        }
    }//end of clickAction

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Reports/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method



}//end of java class
