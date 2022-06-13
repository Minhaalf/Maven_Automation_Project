package AAA_Practice_Items;

import java.util.ArrayList;

public class P4_arrayList {
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

            System.out.println("My name is " +name.get(0) + " and my birthday is " +birthdayMonths.get(0) + " " +birthDay.get(0));
    }//end of main
}//end of java class
