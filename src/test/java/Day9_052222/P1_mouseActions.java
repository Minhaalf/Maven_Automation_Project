package Day9_052222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class P1_mouseActions {
    public static void main(String[] args) throws InterruptedException {
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
        //navigate to usps
        driver.navigate().to("https://www.usps.com/");
        Thread.sleep(2000);

        //declare and define mouse actions
        Actions mouseActions = new Actions(driver);

        //hover to send tabs
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();//have to end in .perform to

        //click on tracking using mouse actions
        WebElement trackingButton = driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseActions.moveToElement(trackingButton).click().perform();
        Thread.sleep(2000);

        //type invalid tracking number using send keys with mouseactions
        WebElement trackingSearchField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackingSearchField).click().perform();
        mouseActions.moveToElement(trackingSearchField).sendKeys("11123456789").perform();
            //textarea tag needs to be clicked on before typing in it.






    }//end of main
}//end of java class
