package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Practice2_FidelisCare_Tab {
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

        //navigate to fideliscare.org
        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(2500);

        //click on shop for a plan button
        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();
        Thread.sleep(2500);

        //click on medicaid managed care from shop for a plan drop down using FIND ELEMENTS because there are multiple
        driver.findElements(By.xpath("//*[text()='Medicaid Managed Care']")).get(0).click();

        //click on search under find a doctor card
        driver.findElement(By.xpath("//*[@href='/findadoctor']")).click();
        Thread.sleep(1000);//to wait a bit for new tab to open

        //store new tabs in an array list
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to new tab and it should be at index 1
        driver.switchTo().window(tabs.get(1));

        //click on new search button
        driver.findElement(By.xpath("//*[@class='fal fa-search-plus']")).click();
        Thread.sleep(2000);

        //close the new tab
        driver.close();

        //switch back to the default tab
        driver.switchTo().window(tabs.get(0));

        //then click on providers tab
        driver.findElement(By.xpath("//*[@class='fal fa-stethoscope fa-fw']")).click();

        //quit driver
        Thread.sleep(5000);
        driver.quit();











    }//end of main
}//end of java class
