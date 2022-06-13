package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class P1_FindElementsExample {
    public static void main(String[] args) throws InterruptedException {
        //go to Bing.com and click on second element from the links

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


        driver.navigate().to("https://www.bing.com/");
        Thread.sleep(2000);

        //click on Images using class property with index of 1
        //to ignore white space in the property value we can use contains command in xpath
        //we use comma because equal calls the exact value of the property, common only looks for an array of content
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();



    }//end of main
}//end of java class
