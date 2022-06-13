package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class P2_HotelsActionItem {
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

        //create ArrayList for 3 destinations
        ArrayList<String> cityName = new ArrayList<>();
        cityName.add("Los Angeles");
        cityName.add("Miami");
        cityName.add("Chicago");


        ArrayList<String> checkInDate = new ArrayList<>();
        checkInDate.add("Jun 1 2022");
        checkInDate.add("Jun 9 2022");
        checkInDate.add("Jun 17 2022");

        ArrayList<String> checkOutDate  = new ArrayList<>();
        checkOutDate.add("Jun 8 2022");
        checkOutDate.add("Jun 16 2022");
        checkOutDate.add("Jun 24 2022");

        ArrayList<String> travlerNumber = new ArrayList<>();
        travlerNumber.add("2");
        travlerNumber.add("4");
        travlerNumber.add("6");

//sumon Example:
        //WebElement intitalDate = by.xpath("//*[aria-label='+startDate.get(i)+')]")

        //navigate to hotels.com
        driver.navigate().to("https://www.hotels.com/");
        Thread.sleep(1000);

        //type in city name into search field
        try {
            WebElement goingTo = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
            goingTo.click();
            Thread.sleep(1000);

            WebElement searchInPut = driver.findElement(By.xpath("//*[@id='location-field-destination']"));
            searchInPut.clear();
            searchInPut.sendKeys("Los Angeles");
            Thread.sleep(1500);

        } catch (Exception e){
            System.out.println("Unable to locate search bar " + e);
        }//end of "Unable to locate search bar " exception

        //click on los Angeles from drop down
        try {
            WebElement cityDD = driver.findElement(By.xpath("//*[@aria-label='Los Angeles']"));
            cityDD.click();
            Thread.sleep(1000);

        }catch (Exception e) {
            System.out.println("Unable to click on los Angeles from drop down " + e);

        }//end of "Unable to click on los Angeles from drop down" Exception


        //click on check in date button
        try {
            WebElement checkInButton = driver.findElement(By.xpath("//*[@aria-label='Check-in June 4, 2022']"));
            checkInButton.click();
            Thread.sleep(1000);

        }catch (Exception e) {
            System.out.println("Unable to click on check in date button " + e);

        }//end of "Unable to click on check in date button" Exception


        //enter in Check In date
        try {
            WebElement checkIn = driver.findElement(By.xpath("//*[@aria-label='Jun 1, 2022']"));
            checkIn.click();
            Thread.sleep(1500);

        }catch (Exception e) {
            System.out.println("Unable to click Check in date " + e);

        }//end of "Unable to enter Check in date" Exception


        //enter  check Out date button
        try {
            WebElement checkOut = driver.findElement(By.xpath("//*[@aria-label='Jun 8, 2022']"));
            checkOut.click();
            Thread.sleep(1000);

        }catch (Exception e) {
            System.out.println("Unable to click on check out date button " + e);

        }//end of "Unable to click on check out date button" Exception

        //click on done button
        try {
            WebElement doneButton = driver.findElements(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary uitk-layout-flex-item uitk-layout-flex-item-flex-shrink-0 dialog-done']")).get(0);
            doneButton.click();
            Thread.sleep(1000);

        }catch (Exception e) {
            System.out.println("Unable to click on done button " + e);

        }//end of "Unable to click on done button" Exception

        //click on travelers dropdown
        try {
            WebElement travelersDD = driver.findElements(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).get(1);
            travelersDD.click();
            Thread.sleep(1000);

        }catch (Exception e) {
            System.out.println("Unable to click on travelers dropdown " + e);

        }//end of "Unable to click on done button" Exception

        //click on "add another room" button
        try {
            WebElement roomButton = driver.findElement(By.xpath("//*[text()='Add another room']"));
            roomButton.click();
            Thread.sleep(1000);

        }catch (Exception e) {
            System.out.println("Unable to click on 'add another room' button " + e);

        }//end of "Unable to click on "add another room" button" Exception

        //click on "plus" button on adults menu
        try {
            WebElement plusButton = driver.findElement(By.xpath("//*[@aria-label='Increase adults in room 1']"));
            plusButton.click();
            Thread.sleep(1000);

        }catch (Exception e) {
            System.out.println("Unable to click on 'plus' on adults menubutton " + e);

        }//end of "Unable to click on "plus" button on adults menu Exception


        //click on "search" button
        try {
            WebElement searchButton = driver.findElement(By.xpath("//*[@class='uitk-button uitk-button-large uitk-button-fullWidth uitk-button-has-text uitk-button-primary']"));
            searchButton.click();
            Thread.sleep(1000);
            searchButton.click();
            Thread.sleep(3500);

        }catch (Exception e) {
            System.out.println("Unable to click on 'search' " + e);

        }//end of "Unable to click on "search" button Exception

        //click on first search result
        try {
            WebElement firstLink = driver.findElements(By.xpath("//*[@class='listing__link uitk-card-link']")).get(0);
            firstLink.click();
            Thread.sleep(1500);

        }catch (Exception e) {
            System.out.println("Unable to click on first search result " + e);

        }//end of "Unable to click on first search result " Exception










        //quit driver
        Thread.sleep(3000);
        driver.quit();




    }//end of main
}//end of java
