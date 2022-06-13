package AAA_Practice_Items;

import java.util.ArrayList;

public class P5_forLoop {
    public static void main(String[] args) {
        ArrayList<String> birthdayMonths = new ArrayList<>();
        birthdayMonths.add("June");
        birthdayMonths.add("July");
        birthdayMonths.add("August");
        birthdayMonths.add("January");
        birthdayMonths.add("February");

        ArrayList<String> name = new ArrayList<>();
        name.add("Minhaal");
        name.add("Laila");
        name.add("Ibrar");
        name.add("Mudd");
        name.add("Ghazala");
        name.add("Ali");

        ArrayList<String> birthDay = new ArrayList<>();
        birthDay.add("22");
        birthDay.add("05");
        birthDay.add("24");
        birthDay.add("21");
        birthDay.add("28");

        for (int i = 0; i<birthdayMonths.size();i++) {
            System.out.println("My name is " +name.get(i) + " and my birthday is " +birthdayMonths.get(i) + " " +birthDay.get(i) +".");
        }//end of for loop
    }//end of main
}//end of java class
