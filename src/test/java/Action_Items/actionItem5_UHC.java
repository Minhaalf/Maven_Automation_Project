package Action_Items;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class actionItem5_UHC {
    public static void main(String[] args) throws InterruptedException {
        //Set up chromedriver and chrome options using reusable methods
        WebDriver driver = Reusable_Actions.setDriver();
        //Set up ArrayList for following firstName, lastName, birthMonth, birthday, birthYear, zipCode, memberld
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Minhaal");
        firstName.add("Laila");
        firstName.add("Ali");

        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Sheikh");
        lastName.add("Faizi");
        lastName.add("Hassan");

        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("June");
        birthMonth.add("July");
        birthMonth.add("August");

        ArrayList<String> birthDay = new ArrayList<>();
        birthDay.add("22");
        birthDay.add("05");
        birthDay.add("15");

        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1995");
        birthYear.add("1994");
        birthYear.add("1996");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11003");
        zipCode.add("11510");
        zipCode.add("11580");

        ArrayList<String> memberID = new ArrayList<>();
        memberID.add("1234567890");
        memberID.add("0987654321");
        memberID.add("1233214566");




        //Declare explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //Navigate to UHC.com
        driver.navigate().to("https://www.uhc.com/");

        //verify that title is "Health insurance plans for individuals & families, employers, medicare | UnitedHealthcare" using Verify Title method
        Reusable_Actions.verifyTitleAction(driver,"Health insurance plans for individuals & families, employers, medicare | UnitedHealthcare","get Title");

        //Click on 'Find a Doctor' link
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Find a doctor']"))).click();
        //Click on Sign in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Sign in menu']"))).click();
        //Click on Medicare Plan?
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Medicare plan?']"))).click();

        //switch tabs using switch tabs action
        Reusable_Actions.switchTabsByIndexAction(driver,1);

        //click on "register now" button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Register Now')]"))).click();

        for (int i = 0; i < zipCode.size();i++){
            //Enter first name //this is where you pass the firstName.get(i)
            Reusable_Actions.sendKeysAction(driver,"//*[@id='firstName']",firstName.get(i),"First Name");
            Thread.sleep(1000);
            //Enter last name //this where you pass the lastName.get(i)
            Reusable_Actions.sendKeysAction(driver,"//*[@id='lastName']",lastName.get(i),"Last name");
            Thread.sleep(1000);

            //Select birth month **his is where you will call your selectByText method to select the dropdown and pass it from arrayList
            Reusable_Actions.selectByText(driver,"//*[@id='dob_month_input']",birthMonth.get(i));
            //Enter birthDay //this is where you pass the get(i) for birth day arraylist
            Reusable_Actions.sendKeysAction(driver,"//*[@id='dob_day']",birthDay.get(i),"Birthday");
            //Enter birth year //this is where you pass the get() for birth year arraylist
            Reusable_Actions.sendKeysAction(driver,"//*[@id='dob_year']",birthYear.get(i),"Birth Year");
            //Enter zipCode //this is where you enter zipCode.get(i)
            Reusable_Actions.sendKeysAction(driver,"//*[@id='zipCode']",zipCode.get(i),"Zip Code");
            //Enter memberld //this is where you pass invalid member id by .get() from your member id arrayList
            Reusable_Actions.sendKeysAction(driver,"//*[@id='memberId']",memberID.get(i),"Member ID");
            //Click on 'Continue' button
            Reusable_Actions.clickActions(driver,"//*[text()='Continue']","Continue Button");
            //capture error message using gettext method
            //Store that reusable method on a String variable on your psvm class and print out that variable for the error
            String result = Reusable_Actions.getTextAction(driver,"//*[@id='plainText_error']","Error Message");
            System.out.println("My error message is: " +result);
        }//end of for loop
        //close the driver
        driver.close();
        //Switch back to default tab bv index o
        Reusable_Actions.switchTabsByIndexAction(driver,0);


        //quit driver
        Thread.sleep(3000);
        driver.quit();

    }//end of main
}//end of java class
