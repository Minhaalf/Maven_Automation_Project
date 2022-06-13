package Day2_042422;

import java.util.ArrayList;

public class P2_ArrayList {
    public static void main(String[] args) {
        //create an ArrayList for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA"); //this is index 0
        countries.add("Bangladesh"); //this is index 1
        countries.add("India");
        countries.add("Canada");
        countries.add("Pakistan");

        //I want to print the 4th value from the list
        System.out.println("My 4th country is " + countries.get(3));

        //I want to print the last country and the third country
        System.out.println("My last country is " +countries.get(4) + " and my third country is " + countries.get(2));


    }//end of main
}//end of public class
