package Action_Items;

import java.util.ArrayList;

public class actionItem2_Assignment2 {
    public static void main(String[] args) {

        //use arraylist to creaat a dynamic array with all the boroughs minus the boronx
        ArrayList<String> Cities = new ArrayList<>();
        Cities.add("Manhattan");
        Cities.add("Brooklyn");
        Cities.add("Queens");
        Cities.add("Staten Island");

        //use loop and conditional statements to iterate through the array and print only Brooklyn and Manhattan
        for (int i = 0; i < Cities.size(); i++) {
            if (Cities.get(i) == "Manhattan"){
                System.out.println("My City is " + Cities.get(i));
            } else if (Cities.get(i) == "Brooklyn"){
                System.out.println("My city is " + Cities.get(i));
            }//end of conditional

        }//end of for loop

    }//end of main
}//end of java class
