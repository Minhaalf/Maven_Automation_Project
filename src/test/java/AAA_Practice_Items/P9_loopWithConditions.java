package AAA_Practice_Items;

import java.util.ArrayList;

public class P9_loopWithConditions {
    public static void main(String[] args) {
        //create an array with fruits and print only when fruit is apple or orange
        ArrayList<String> fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Orange");
        fruitList.add("Banana");
        fruitList.add("Grape");
        fruitList.add("Kiwi");

        for (int i = 0; i< fruitList.size(); i++) {
            if (fruitList.get(i) == "Apple" || fruitList.get(i) == "Orange")
                System.out.println("My favorite fruit is " +fruitList.get(i));
        }//end of for loop



    }//end of main
}//end of public class
