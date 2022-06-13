package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Practice3_Exception_MortgageCalc {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgagecalculator.org
        driver.navigate().to("https://www.mortgagecalculator.org/");
        Thread.sleep(2500);

        //handle the exception for home value
        try {
            WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
            homeValue.clear();
            homeValue.sendKeys("450000");

        }catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate home value" + e);

        }//end of home value exception


        //handle the exception for start month
        try {
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
            Select dropDown = new Select(startMonth);
            dropDown.selectByVisibleText("Jun");

        }catch (Exception e){
            //print out the exception
            System.out.println("Unable to locate Start month dropdown" + e);
        }//end of start month exception


        //handle the exception for click on calculate button
        try {
            driver.findElement(By.xpath("//*[@name='cal']")).click();

        }catch (Exception e){
            //print out the exception
            System.out.println("Unable to click on calculate button" + e);
        }//end of click on calculate button exception







        //quit driver
        Thread.sleep(5500);
        driver.quit();









    }//end of main
}//end of java class
