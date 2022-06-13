package Action_Items;

import java.util.ArrayList;

public class actionItem1_forLoop_arrayList {

    /* Using String country & int countryCode with for loop and ArrayList create at least 4 data
     for each variable and iterate through each to print out the i for both variables */

    public static void main(String[] args) {
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Scotland");
        countries.add("Greece");
        countries.add("Japan");
        countries.add("Columbia");

        ArrayList<Integer> countryCode = new ArrayList<Integer>();
        countryCode.add(44);
        countryCode.add(30);
        countryCode.add(81);
        countryCode.add(57);

        for (int i = 0; i < countries.size(); i++){
            System.out.println("My country is " + countries.get(i) + " and my country code is " + countryCode.get(i));

        }//end of for loop

    }//end of main
}//end of java class
