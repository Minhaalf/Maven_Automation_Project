package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Practice1_Select_MortgageCalculator {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdriver manager
        WebDriverManager.chromedriver().setup();

        //set up chrome options
        ChromeOptions options = new ChromeOptions();

        //Add incognito
        options.addArguments("incognito");
        //Add option for full screen
        options.addArguments("start-fullscreen");
        //add headless
        //options.addArguments("headless");

        //define webdriver that I will use with chrome options
        WebDriver driver = new ChromeDriver(options);


        //navigate to mortgagecalculator.org
        driver.navigate().to("https://www.mortgagecalculator.org/");
        Thread.sleep(2500);

        //select start month from the dropdown menu
/*
        //store locator as webelement
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //define select command
        Select dropDown = new Select(startMonth);
        //select by visible text
        dropDown.selectByVisibleText("Jun");
*/
        //clicking on dropdown and its value if the dropdown is not under select tag
        //store locator as a webelement
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //click on the drop down menu using previosly stored webelement for dropdown
        startMonth.click();
        //click on the value of the start month
        driver.findElement(By.xpath("//*[text()='Jun']")).click();




        //store locator as web element
        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));
        //define select command
        Select loanDropDown = new Select(loanType);
        //call select command and select by visible text
        loanDropDown.selectByVisibleText("FHA");


        //quit driver
        Thread.sleep(8000);
        driver.quit();




    }//end of main
}//end of java class
