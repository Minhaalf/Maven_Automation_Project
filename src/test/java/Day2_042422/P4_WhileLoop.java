package Day2_042422;

public class P4_WhileLoop {
    public static void main(String[] args) {
        //iterate through zipcode and house number while using linear array and while loop
        String[] zipCodes = new String[]{"11218","11219","11232","11001"};
        int[] houseNumber = new int[]{111,222,333,444};

        //initialize your starting point before calling the while loop
        int i = 0;
        //define the end point in while loop
        while (i < houseNumber.length){
            System.out.println("My zipcode is " + zipCodes[i] + " house number " +houseNumber[i]);

            //incrementing
            i = i +1;
        }//end of while loop

    }//end of main
}//end of java class
