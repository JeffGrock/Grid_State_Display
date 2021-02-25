import java.util.Scanner;
/**
 * Write a description of class JeffGrockowskiProj08 here.
 *
 * @author Jeff Grockowski
 * @version 10/27/2019
 */
public class JeffGrockowskiProj08
{
    
    public static void main(String [] args) {
        
        Scanner input = new Scanner(System.in);
        int n;
        int choice;
        char [][] arr;
        char repeat = 'Y';
        
        System.out.println("This program will print all the possible states of the 3 x 3 matrix of coins(0 - 511).");
        do {
            System.out.print("would like to see another state? (1 for yes 2 for no): ");
            choice = input.nextInt();
            switch (choice) {
                case(1):
                    System.out.println("Enter an integer between 0 and 511 inclusive: ");
                    n = input.nextInt();
                    arr = convert(n);
                    
                    if(arr != null)
                        printArray(arr);
                    else
                        System.out.println("The input is out of range");
                    break;
                case(2):
                    repeat = 'N';
                    break;
                default:
                    System.out.println("invalid entry, please enter 1 or 2");
                    break;
                }
            } while(repeat == 'Y');
            System.out.println("Thank you for using the program!");
    }
    
    /*
     * takes input between 0 and 511, function returns a binary array
     */
    public static char[][] convert(int n){
        if (n < 0 || n > 511)
            return null;
        String s = Integer.toBinaryString(n);
        while (s.length() < 9) {
            s = "0" + s;
        }
        
        char [][] result = new char[3][3];
        for (int i = 0; i < 9; i++){
            if (s.charAt(i) == '0')
                result[i/3][i%3] = 'H';
            else 
                result[i/3][i%3] = 'T';
        }
        return result;
    }
    
    public static void printArray(char[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
   
    }

}
/* Sample run
 * This program will print all the possible states of the 3 x 3 matrix of coins(0 - 511).
would like to see another state? (1 for yes 2 for no): 1
Enter an integer between 0 and 511 inclusive: 
8
H H H 
H H T 
H H H 
would like to see another state? (1 for yes 2 for no): 1
Enter an integer between 0 and 511 inclusive: 
400
T T H 
H T H 
H H H 
would like to see another state? (1 for yes 2 for no): 2
Thank you for using the program!
 * 
 * 
 * 
 */