package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class P4_Exception_MortgageCalculator_PRACTICE {
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

        //navigate to mortgage calculator
        driver.navigate().to("https://www.mlcalc.com/");
        Thread.sleep(2500);

        //handle exception for purchase price
        try {
            WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
            pPrice.clear();
            pPrice.sendKeys("550000");

        }catch (Exception e) {
            //print out exception
            System.out.println("Unable to locate purchase price" + e);
        }//end of purchase price exception

        //handle exception for show advanced options button
        try {
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
            Select dropDown = new Select(startMonth);
            dropDown.selectByVisibleText("Jun");
            startMonth.clear();
            startMonth.sendKeys("550000");

        }catch (Exception e) {
            //print out exception
            System.out.println("Unable to locate start month drop down" + e);
        }//end of show advanced options button exception

        //handle exception for calculate button
        try {
            WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
            homeVal.clear();
            homeVal.sendKeys("550000");

        }catch (Exception e) {
            //print out exception
            System.out.println("Unable to locate home value" + e);
        }//end of calculate exception


    }//end of main
}//end of class
