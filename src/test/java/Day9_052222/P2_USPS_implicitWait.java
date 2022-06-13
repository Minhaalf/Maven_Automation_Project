package Day9_052222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class P2_USPS_implicitWait {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        //Set your global implicit wait
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);


        //Navigate to USPS.com
        driver.navigate().to("https://www.usps.com/");
        //declare and name Actions command
        Actions actions = new Actions(driver);
        //Hover to quick tools
        WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        actions.moveToElement(quickTools).perform();

        //click on track a package field
        driver.findElement(By.xpath("//*[text()='Track a Package']")).click();

        //click then type on track a package field
        WebElement packageField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        packageField.click();
        packageField.sendKeys("12233212455322");

        //quit driver
        Thread.sleep(3000);
        driver.quit();

    }//end of main
}//end of java class
