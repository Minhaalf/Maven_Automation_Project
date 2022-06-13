package AAA_Practice_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class P1_ChromeDriver_ChromeOptions_Setup {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with WebdriverManager. Dont forget .setup!!
        WebDriverManager.chromedriver().setup();

        //SET UP CHROMEOPTIONS
        //define the chromeoptions
        ChromeOptions options = new ChromeOptions();

        //set the condition to incognito mode
        //options.addArguments("incognito");

        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-fullscreen");
        //options.addArguments("start-maximized") FOR WINDOWS


        //Setting your driver as headless (running in the Background)
        //options.addArguments("headless");
        //options.addArguments("headless");

        //define the webdriver i am going to use with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        //navigate to dealersocket.com
        driver.navigate().to("https://sso.dealersocket.com/crm/Account/Login");
        Thread.sleep(2000);

        //type username in username field
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("kh7mfaizi");
        Thread.sleep(3000);

        //click continue/submit
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(3000);

        //type password in password field
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Benson123");
        Thread.sleep(3000);

        //click continue/submit
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(3000);








        //hit submit
        //capture search results number and print it

        //declare an array of string to store the string split





        //quit driver
        //driver.quit();





    }//end of main
}//end of java class
