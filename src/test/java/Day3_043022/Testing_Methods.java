package Day3_043022;

import Reusable_Library.Reusable_Methods;

public class Testing_Methods {
    public static void main(String[] args) {
        //call the add two number method and execute it
        Reusable_Methods.addTwoNumbers(20,30);

        //call the return method and store it in a variable to perform something else
        int finalResult = Reusable_Methods.subtractTwoNumbers(50,10);
        int newResult = finalResult + 10;
        System.out.println("New result is " + newResult);


        /*practice to see if void method can return

         int testResult = Reusable_Methods.addTwoNumbers(10,10);

        --does not work because it is not a return method

         */



    }


}//end of java class
