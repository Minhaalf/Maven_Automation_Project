package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class actionItem3_bingSearch {
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
        options.addArguments("headless");

        //define the webdriver i am going to use with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        //Setup ArrayList with 5 hobbies
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("photography");
        hobbies.add("traveling");
        hobbies.add("weight lifting");
        hobbies.add("surfing");
        hobbies.add("gardening");

        //Create for loop to iterate through hobbies arraylist automatically
        for (int i=0; i < hobbies.size(); i++) {
            //Navigate to Bing.com
            driver.navigate().to("https://www.bing.com");
            Thread.sleep(2500);

            //enter a keyword on a search field (locate the element [search bar] and send keyword)
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobbies.get(i));

            //submit search on bing search
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();
            Thread.sleep(2500);

            /*capture the search result and print the number */

            //locate the element for search result number and capture the text and put it in to a string to be used easily
            String resultNumber = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

            //Extract only the number of search results from the result using split and print it
            String[] arrayResult = resultNumber.split(" ");
            System.out.println("The number of search results for my hobbie, " + hobbies.get(i) + " is " +arrayResult[0]);




        }//end of for loop

        //Quit driver outside of for loop
        driver.quit();
    }//end of main
}//end of java class
