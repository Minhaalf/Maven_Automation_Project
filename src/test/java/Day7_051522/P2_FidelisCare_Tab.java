package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class P2_FidelisCare_Tab {
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
            //navigate to fidelis care and wait for webpage to load
            driver.navigate().to("https://www.fideliscare.org/");
            Thread.sleep(2500);

            //click on shop for a plan
            //we are


    }//end of main
}//end of java class
