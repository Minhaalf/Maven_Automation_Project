package Reusable_Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions {
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

    //create a mouse hover method
    public static void mouseHover (WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();


        }catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " +e);
        }//end of exception
    }//end of mouse hover method


    //create a click method
    public static void clickActions (WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();

        }catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " +e);
        }//end of exception
    }//end of click method

    //create a sendKeys method
    public static void sendKeysAction (WebDriver driver, String xpath,String userValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            Thread.sleep(1200);
            element.clear();
            Thread.sleep(1200);
            element.sendKeys(userValue);

        }catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + " " +e);
        }//end of exception
    }//end of sendKeys method

    //create a getText method
    public static String getTextAction (WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();

        }catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " +e);
        }//end of exception
        return result;
    }//end of getText method

    //create a click by index method
    public static void clickByIndexActions (WebDriver driver, String xpath, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();

        }catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " +e);
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
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(indexNumber));
        Thread.sleep(1500);
    }//end of switch to tabs by index


    //create a selectByText action
    public static void selectByText (WebDriver driver,String xPath ,String visibleText) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        WebElement dropDownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        //define select command
        Select selectDropDown = new Select(dropDownElement);
        //call select command and select by visible text
        selectDropDown.selectByVisibleText(visibleText);
    }//end of selectByText action

    //create a submit method
    public static void submitAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit




    //store locator as web element




}//end of java class
