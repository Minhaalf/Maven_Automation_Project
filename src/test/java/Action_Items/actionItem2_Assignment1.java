package Action_Items;

public class actionItem2_Assignment1 {
    public static void main(String[] args) {
        //declare the integer variable grade
        int grade = 50;
        //use conditional statements to print Grade range From A - F depending on the grade variable

        if (grade >= 90 && grade <=100){
            System.out.println("Grade is A");
        } else if (grade >= 80 && grade <90) {
            System.out.println("Grade is B");
        }else if (grade >= 70 && grade <80){
            System.out.println("Grade is C");
        }else if (grade >= 60 && grade <70){
            System.out.println("Grade is D");
        }else if (grade <60){
            System.out.println("Grade is F");
        }//end of conditional statement

    }//end of main method
}//end of java class
