package Day3_043022;

public class P2_Multiple_Conditional_Statements {
    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        int c = 3;

        //if a + b is less than c then print the result
        //i f a+b is greater than c then print the result
        //finally print a+b is equal to c

        if (a+b < c){
            System.out.println("a & b is less than c");
        }else if (a+b > c){
            System.out.println("a & b is greater than c");
        }else {
            System.out.println("a & b is equal to c");
        }//end of conditions

        //declare additional variables
        int d =4;
        int e = 5;
        int f = 6;
        //or operator with if statement
        //|| is used for or operator -- only one of the conditions have to be true
        //&& is used for and operator -- both conditions need to be true
        if (d < e && f < e) {
            System.out.println("d is less than e or f is less than e");
        } else {
            System.out.println("condtion is not true");
        }

    }//end of main
}//end of java class
