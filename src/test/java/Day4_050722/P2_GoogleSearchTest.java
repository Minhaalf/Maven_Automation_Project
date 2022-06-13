package Day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_GoogleSearchTest {
    public static void main(String[] args) {
        //setup your chromedriver with WebdriverManager
        WebDriverManager.chromedriver().setup();

        //define the webdriver i am going to use
        WebDriver driver = new ChromeDriver();

        //maximize the driver
        driver.manage().window().fullscreen();
        //for windows OS use:
        //driver.manage().window().maximize();

        //go to google home page
        driver.navigate().to("https://www.google.com/");

        //locate the element you are trying to interact with

        //locate element for search field and type 'cars'
        //driver.findElement(By.xpath("//input[@name='q']")).sendKeys("cars");
        //* asterisk means ignoring the class/tag name
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        //submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //capture the google search results and print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println("Result is " + searchResult);

        String[] arrayResult = searchResult.split(" ");
        //to replace ( and ) around the seconds thats coming from arrayList[3] use .replace
        String replaceParenthasis = arrayResult[3].replace("(","").replace(")","");
        System.out.println("My search result number is " + arrayResult[1] +" and my seconds is " + replaceParenthasis);
        //look in to substring to replace parts of string


        // quit the driver
        driver.quit();



    }//end of main
}//end of java class
