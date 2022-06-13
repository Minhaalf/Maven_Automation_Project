package AAA_Practice_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P13_chromeOptions_googleSearch {
    public static void main(String[] args) {
        //set up chromediver with chromeoptions
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);

        //declare implicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //navigate to google.com
        driver.navigate().to("https://www.google.com");

        //locate element for search field and type 'cars'
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q']"))).sendKeys("cars");
        //submit on google search button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='btnK']"))).submit();
        //capture the number of google results and print only the number
        String results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='result-stats']"))).getText();
        String[] resultSplitArray = results.split(" ");
        System.out.println("The number of search results for 'cars' is " +resultSplitArray[1]);

        //quit driver
        driver.quit();




    }//end of main
}//end of java class
