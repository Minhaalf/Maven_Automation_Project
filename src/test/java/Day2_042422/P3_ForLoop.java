package Day2_042422;

import java.util.ArrayList;

public class P3_ForLoop {
    public static void main(String[] args) {
        //create an arraylist for cities and loop through all the values using for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Bronx");
        cities.add("Long Island");
        cities.add("Staten Island");

        //for (START POINT; END POINT; How many you are moving up) {....
        for (int i = 0; i < cities.size(); i++){
            System.out.println("i is now" + i);
            System.out.println("My city is " + cities.get(i));
        }


    }//end of main
}//end of java class
