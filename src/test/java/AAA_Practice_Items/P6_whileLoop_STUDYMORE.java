package AAA_Practice_Items;

public class P6_whileLoop_STUDYMORE {
    public static void main(String[] args) {
        //iterate through zipcode and house number while using linear array and while loop
        String[] zipCodes = new String[]{"11003","11510","11580","10003"};
        int [] houseNumber = new int[]{220,2019,639,7};
        //initialize your starting point before calling the while loop
        int i = 0;
        //define the end point in while loop
        while (i<zipCodes.length) {
            System.out.println("My house number is " + houseNumber[i] + " and my zipcode is " + zipCodes[i]);
            //incrementing
            i = i + 1;
        }//end of while loop
    }//end of main
}//end of java class
