
package sp2.cw1.pkg2014;

/**
 * Software and Programming II : Coursework 1
 * Due date: 06/10/2014
 * @author Pete Whelpton (pwhelp01 / 12828513)
 */

import java.util.Scanner;


public class Sp2Cw12014 {

    /**
     * Given two arrays of integers, you are required 
     * to perform some array operations. You have to 
     * print the values which occur in both arrays, those 
     * which occur only in the first array, and those 
     * which occur only in the second.
     * 
     * @param args the command line arguments (not used)
     */
    
    final static int ARRSIZE = 100;                                             // Constant containing the size of our arrays 
    
    
    public static void main(String[] args) {
        
        /* Declare and set global variables and constants */
        
        int[] arrOne = new int[ARRSIZE];                                        // First array to store user input
        int[] arrTwo = new int[ARRSIZE];                                        // Second array to store user input
        
        
        /* Populate arrays */
        fillArray(arrOne, 1);                                                   // Populate Array One
        
        /* Display results */
        displayElements(arrOne);
        
        
    }
    
    
    public static void fillArray(int[] arrIn, int arrNumIn) {
        
        /* Declare variables / object needed */
        final int SENTINEL = 0;                                                 // Sentinel to terminate loop
        int arrPos = 0;                                                         // Counter to store where we are in the array
        int input = -99;                                                        // Variable to store user input
        Scanner in = new Scanner(System.in);                                    // Scanner object to read user input
        
        
        /* Prompt user for input */
        while(input != SENTINEL && arrPos < ARRSIZE) {                          // Keep prompting for user input until sentinel input or we reach max array size
                System.out.print("Enter data for array "
                        + arrNumIn + " (0 to finish): ");                       // Display input prompt
                input = in.nextInt();                                           // Read user input to variable
                if(elementUnique(arrIn, input)) {                               // Check element is unique to array
                    arrIn[arrPos] = input;                                      // It is, so add it
                    arrPos++;                                                   // and update the array counter variable
                }
                else{                                                           // If the element is not unique
                    System.out.println("Each element must be unique!");         // Display error message to user
                }
        }
        
    }
    
    public static boolean elementUnique(int[] arrIn, int elementIn) {
        
        boolean rv = true;
        
        for(int e : arrIn) {
            if(e == elementIn) {
                rv = false;
            }
        }
        
        return rv;
        
    }
    
    public static void displayElements(int[] arrIn) {
        
        for(int e : arrIn) {
            System.out.print(e + " ");
        }
    }
    
}
