package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class actionItem4_WeightWatchers {
    public static void main(String[] args) throws InterruptedException {

        //set up chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        //Declare ChromeOptions by defining new ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set conditions for incognito
        options.addArguments("incognito");
        //set condition for full screen
        options.addArguments("start-fullscreen");
        //set condition for headless
        //options.addArguments("headless");
        //define your webdriver with chrome options
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11003");
        zipCodes.add("11764");
        zipCodes.add("11414");

        for (int i = 0; i < zipCodes.size();i++) {


        //navigate to https://www.weightwatchers.com/us/
        driver.navigate().to("https://www.weightwatchers.com/us/");
        Thread.sleep(1250);

            //click on attend dropdown on top left of the page
            try {
                WebElement attendButton = driver.findElement(By.xpath("//*[@data-e2e-name='attend']"));
                attendButton.click();
                Thread.sleep(1250);

            } catch (Exception e) {
                System.out.println("Unable to click on Attend" +e);
            }//end of "click on Attend" exception

            //click on Unlimited Workshops from the dropdown
            try {
                WebElement unlimitedWorkshops = driver.findElement(By.xpath("//*[@data-e2e-name='Unlimited Workshops']"));
                unlimitedWorkshops.click();
                Thread.sleep(1250);
            } catch (Exception e) {
                System.out.println("Unable to click on 'Unlimited Workshops'" +e);
            }// end of unable to "click on Unlimited Workshops" exception

            //click on the Studio link
            try {
                WebElement studioButton = driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']"));
                studioButton.click();
                Thread.sleep(1250);
            } catch (Exception e) {
                System.out.println("Unable to click on 'Studio' button "+e);
            }//end of Unable to click on 'Studio' button exception

            //clear the field and enter zipcode
            try {
                WebElement searchField = driver.findElement(By.xpath("//*[@class='input input-3TfT5']"));
                searchField.clear();//it is goof practice to clear iput tags in general even if you dont need to.
                searchField.sendKeys(zipCodes.get(i));
                Thread.sleep(1250);
            }catch (Exception e) {
                System.out.println("Unable to enter zipcode on search field" +e);
            }//end of "Unable to enter zipcode on search field" exception

            //click on the search arrow
            try {
                WebElement searchArrow = driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']"));
                searchArrow.click();
                Thread.sleep(2000);
            }catch (Exception e) {
                System.out.println("Unable to click on search arrow" + e);
            }//end of "Unable to click on search arrow" exception

            //click on specific link for studios
            try {
                WebElement studioLink = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(i);
                Thread.sleep(1250);

                if (i==0){
                    studioLink.click();
                    String addressStudio = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    System.out.println("The address for zipcode " +zipCodes.get(i) + " is " +addressStudio );
                    Thread.sleep(1250);

                }if (i==1){
                    studioLink.click();
                    String addressStudio = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    System.out.println("The address for zipcode " +zipCodes.get(i) + " is " +addressStudio );
                    Thread.sleep(1250);

                }if (i==2){
                    studioLink.click();
                    String addressStudio = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    System.out.println("The address for zipcode " +zipCodes.get(i) + " is " +addressStudio );
                    Thread.sleep(1250);

                }//end of conditional statement
            }catch (Exception e) {
                System.out.println("Unable to click on specific link for studios" +e);
            }//end of click on specifc link for studios exception


            //scroll down to the bottom using JavaScriptExecutor and capture table with hours and days and print it
            try {
                //declare the JavascriptExecutor
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                //declare a webelemnt for the table that we are scrolling down to
                WebElement workshopSchedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
                //scroll to the table
                jse.executeScript("arguments[0].scrollIntoView(true);",workshopSchedule);
                Thread.sleep(1000);
                //print the hours and days into a webelement
                System.out.println("The workshop schedule is as follows " + workshopSchedule.getText());



            }catch (Exception e) {
                System.out.println("Unable to print hours and days or unable to scroll down to hours and days table " +e);
            }//end of "Unable to print hours and days exception

        }//end of for loop


        //quit driver
        Thread.sleep(5000);
        driver.quit();
    }//end of main
}//end of java class
