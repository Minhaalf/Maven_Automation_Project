package AAA_Practice_Items;

public class P11_splitMessage {
    public static void main(String[] args) {
        //declare a string to split
        String splitTestMessage = "My name is Minhaal";
        //declare linear array with new name to store the split of previous String
        String[] splitMessageArray = splitTestMessage.split(" ");
        //Print out "My name is Minhaal" using the new array with correct index #
        System.out.println("My name is " +splitMessageArray[3]);

        //use for loop to print out entire array
        for (int i =0; i< splitMessageArray.length; i++) {
            System.out.println("My linear array value is " +splitMessageArray[i]);
        }//end of for loop



    }//end of main
}//end of java class
