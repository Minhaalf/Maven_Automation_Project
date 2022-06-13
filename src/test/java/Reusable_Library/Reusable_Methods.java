package Reusable_Library;

public class Reusable_Methods {
    //create a void method to add two numbers
    public static void addTwoNumbers(int num1, int num2){
        System.out.println("The result of two numbers is " + (num1+num2));

    }//end of addTwoNumbers method


    //create a return method to subtract two numbers
    public static int subtractTwoNumbers(int a, int b){
        int result = a-b;
        System.out.println("The result of two numbers for subtraction is " + (result));
        return result;
    }//end of subtractTwoNumber method

}//end of java class
