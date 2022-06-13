package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class P2_Mortgage_Calculator {
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

        //navigate to mortgagecalculator website
        driver.navigate().to("https://www.mortgagecalculator.org/");
        Thread.sleep(3000);

        //click, clear and enter new value on Home Value field
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeValue.click();
        homeValue.clear();
        homeValue.sendKeys("450000");

        //Click on % radio button
        driver.findElement(By.xpath("//*[@value='percent']")).click();

        //click, clear and enter new data on down payment field
        WebElement downPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        downPayment.click();
        downPayment.clear();
        downPayment.sendKeys("5");

        Thread.sleep(6000);

        //quit driver
        driver.quit();



    }//end of main
}//end of java class
