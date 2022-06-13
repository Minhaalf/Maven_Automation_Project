package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class P1_Select_MortgageCalc {
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

        //navigate to mortgagecalculator.org
        driver.navigate().to("https://www.mortgagecalculator.org/");
        Thread.sleep(2000);

        //select start month from the dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));

        //define select command
        //Select dropDown = new Select(startMonth);

        //select by visible text
       // dropDown.selectByVisibleText("Jun");

        //clicking on dropdown and its value if the dropdown is not under select tag
        startMonth.click();
        //click on the value of the start month
        driver.findElement(By.xpath("//*[text()='Jun']")).click();


        //select loan type from dropdown menu
        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));

        //define the select command
        Select loanTypeDropDown = new Select(loanType);

        //select by visible text
        loanTypeDropDown.selectByVisibleText("FHA");





        //quit driver
        driver.quit();
    }//end of main
}//enf of java class
