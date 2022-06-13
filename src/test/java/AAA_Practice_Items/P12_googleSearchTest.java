package AAA_Practice_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P12_googleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        //setup chrome driver using chromeoptions
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);

        //declare explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //navigate to google.com
        driver.navigate().to("https://www.google.com");

        //search for cars using send keys
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q']"))).sendKeys("cars");

        //click on submit on the search arrow
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='btnK']"))).submit();

        //capture the searchResults as a string
        String searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='result-stats']"))).getText();

        //split the search results and only print the number
        String[] splitResult = searchResult.split(" ");

        System.out.println("The number of search results is " + splitResult[1]);


        //quit driver
        Thread.sleep(2500);
        driver.quit();


    }//end of main
}//end of java class
