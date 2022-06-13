package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class P1_ChromeOptions_GoogleSearch {
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
        //options.addArguments("start-maximized") FOR WINDOWS
        //Setting your driver as headless (running in the Background)
        //options.addArguments("headless");

        //define the webdriver i am going to use with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        //go to google home page
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(3000);

        //locate the element you are trying to interact with

        //locate element for search field and type 'cars'
        //driver.findElement(By.xpath("//input[@name='q']")).sendKeys("cars");
        //* asterisk means ignoring the class/tag name
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");


        //submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        Thread.sleep(3000);


        //capture the google search results and print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println("Result is " + searchResult);

        String[] arrayResult = searchResult.split(" ");
        //to replace ( and ) around the seconds thats coming from arrayList[3] use .replace
        String replaceParenthasis = arrayResult[3].replace("(","").replace(")","");
        System.out.println("My number of search results is " + arrayResult[1] +" and my seconds is " + replaceParenthasis);
        //look in to substring to replace parts of string


        // quit the driver
        driver.quit();

    }//end of main
}//end of java class
