package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class P3_Scroll_MortgageCalculator {
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

        //navigate to mortgagecalculator
        driver.navigate().to("https://www.mortgagecalculator.org/");
        Thread.sleep(3000);

        //declare the javascriptexecutor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll to pixel 400 on mortgage calc website
        //jse.executeScript("scroll(0,400)");
        //wait a bit for browser to perform scrolling
        //Thread.sleep(3000);

        //declare a webelement variable that we want to scroll into
        WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));

        //scroll into share this calculation button

        jse.executeScript("arguments[0].scrollIntoView(true);",shareButton);
        Thread.sleep(2000);

        //click on sharebutton
        shareButton.click();
        Thread.sleep(2000);

        //scroll back up
        jse.executeScript("scroll(0,-400)");
        Thread.sleep(2000);

        //quit the driver
        //Thread.sleep(5000);
        driver.quit();


    }//end of main
}//end of java
