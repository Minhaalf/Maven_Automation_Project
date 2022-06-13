package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Practice4_Exception_mlCalc {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgagecalculator.org
        driver.navigate().to("https://www.mlcalc.com/");
        Thread.sleep(2500);

        ArrayList<String> pPriceList = new ArrayList<>();
        pPriceList.add("500000");
        pPriceList.add("600000");
        pPriceList.add("700000");

        ArrayList<String> monthList = new ArrayList<>();
        monthList.add("Jun");
        monthList.add("Jul");
        monthList.add("Dec");

        for (int i =0; i< pPriceList.size(); i++) {
            //handle the exception for purchase price
            try {
                WebElement purchasePrice = driver.findElement(By.xpath("//*[@id='ma']"));
                purchasePrice.clear();
                purchasePrice.sendKeys(pPriceList.get(i));

            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate home value" + e);

            }//end of purchase price exception

            //handle exception for click on show advanced options button
            try {
                driver.findElements(By.xpath("//*[@class='href']")).get(0).click();
                Thread.sleep(2500);

            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate show advanced options button " + e);

            }//end of click on show advanced options button exception


            //handle the exception for start month dropdown
            try {
                WebElement startMonth = driver.findElement(By.xpath("//*[@id='fpdd']"));
                Select dropDown = new Select(startMonth);
                dropDown.selectByVisibleText(monthList.get(i));
                Thread.sleep(2500);


            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate Start month dropdown" + e);
            }//end of start month dropdown exception


            //handle the exception for click on calculate button
            try {
                driver.findElements(By.xpath("//*[@value='Calculate']")).get(0).click();
                Thread.sleep(2500);


            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to click on calculate button" + e);
            }//end of click on calculate button exception


            //handle the exception for capturing the monthly payments text
            try {
                WebElement monthlyPayment = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0);
                System.out.println("My monthly payment is " + monthlyPayment.getText());

            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate monthly payment text" + e);
            }//end of click on capturing the monthly payments text exception


        }//end of for loop

        //quit driver
        Thread.sleep(5500);
        driver.quit();
    }//end of main
}//end of java class
