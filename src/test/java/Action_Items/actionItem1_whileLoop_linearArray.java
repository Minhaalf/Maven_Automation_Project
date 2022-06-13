package Action_Items;

public class actionItem1_whileLoop_linearArray {
    public static void main(String[] args) {

        /*Using String] region & intil areaCode with while loop and linear array create at least 4
        data for each variable and iterate through each to print out the i for both variables... */

        String[] region = new String[]{"Nassau County", "Queens County", "Suffolk County","Brooklyn"};
        int[] areaCode = new int[] {516, 718, 631, 347};

        //initialize your starting point before calling the while loop
        int i = 0;
        //define the end point in the while loop
        while (i < region.length){

            System.out.println("My region is " +region[i] + " my area code is " + areaCode[i]);

            //define incrementaion
            i = i+1;

        }//end of while loop

    }//end of main
}//end of java class
