import java.util.Scanner;
import java.lang.Math;

/**
*
*    @author : Gabriel Lopez
*    @date : 1/22/24
*    This class calculates the sum between num * random and limit * random.
*    The class also contains the main method.
 */
public class CalculateSum {
    /**
     * This is the main method calling sum.
     * And asking for num and limit from the user.
     * @param args
     */
   public static void main (String[] args) {

       Scanner input = new Scanner(System.in);
       //prompt
       System.out.println("Enter a number");
       int num = input.nextInt();

       //prompt
       System.out.println("Enter a limit");
       int limit = input.nextInt();

       //TODO check limit is great than number
       //Continuously prompt user until limit is greater than num
       while(limit <= num) {

           System.out.println("Your limit value should be greater than num");
           System.out.println("Enter a limit");

           limit = input.nextInt();




       }

       //Call sum function
       System.out.println("The sum is: " + sum(num, limit));


   }

    /**
     * This is the sum method that add int values between num * random1 to limit * random2
     * @param num
     * @param limit
     * @return returns the sum
     */
   public static int sum (int num, int limit){


       //Produce random numbers between 3 and 8
       int random1 =  3 + (int) (Math.random() * 6);

       //Produce random number between 8 and 15
       int random2 =  8 + (int) (Math.random() * 8);

       int start = num * random1;
       int end = limit * random2;

       //Variable holds the sum
       int result = 0;

       //Calculate the sum between the start and end boundaries
       for (int i = start; i <= end; i++)
           result = result + i;


       //Return result
       return result;

   }

}
