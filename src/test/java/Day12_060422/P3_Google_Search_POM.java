package Day12_060422;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Annotations_Class;
import org.testng.annotations.Test;

public class P3_Google_Search_POM  extends Reusable_Annotations_Class {
    @Test
    public void SearchForAKeywordOnGoogleHome() {
        driver.navigate().to("https://www.google.com");
        BaseClass.googleHomePage().searchUserValue("BMW");
        BaseClass.googleHomePage().submitOnGoogleSearch();
    }//end of test 1

    @Test (dependsOnMethods = "SearchForAKeywordOnGoogleHome")
    public void CaptureSearchNumberFromGoogle() {
        BaseClass.googleSearchResultPage().CaptureSearchNumberAndPrintIt();

    }//end of test 2

/*SUMON: Page object is a design pattern or framework that allows you to organize all
webelements for a specific page into one class. For each page you will have a separate java
class for page object. Page object you define all of your webelements and you create user methods
based on the elements you are interacting with. You will have a constructor which is like a helper/bridge
class between your base class and your page object class to make all of your methods static. Finally, you
are able to call your page object class to your test class based on the new name that is referencing to
your actual page object class.

POM: It allows you to organize your classes per page with all the webelements included that you are interacting
with for the individual page. You have a constructor which is a helper that allows you to make your methods
static on your base class because your methods are not static on page object class. Finally, on your test class
you can call those methods from each page object class by making your page object class static on your base class.

Method OverLoad: You having same method that you are calling
Method OverWrite: 1:07 hr in class video
 */

}//end of java class
