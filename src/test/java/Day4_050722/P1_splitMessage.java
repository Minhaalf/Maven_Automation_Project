package Day4_050722;

public class P1_splitMessage {
    public static void main(String[] args) {
        //declare string variable
        String splitMessage = "My name is John";

        //declare an array of string to store the string split
        String[] splitMessageArray = splitMessage.split(" ");

        //print out John to the console
        System.out.println("My first name is " + splitMessageArray[3]);

        //real life example would be splitting a google search at space



    }//end of main
}//end of java
