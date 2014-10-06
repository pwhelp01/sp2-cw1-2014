
package sp2.cw1.pkg2014;

/**
 * Software and Programming II : Coursework 1
 * Due date: 06/10/2014
 * @author Pete Whelpton (pwhelp01 / 12828513)
 */

import java.util.Scanner;


public class Sp2Cw12014 {
    
    final static int ARRSIZE = 100;                                             // Constant containing the size of our arrays 
    final static int SENTINEL = 0;                                              // Sentinel to terminate loops
    
    
    /**
     * Given two arrays of integers 
     * print the values which occur in both arrays, those 
     * which occur only in the first array, and those 
     * which occur only in the second.
     * 
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {
        
        /* Declare and set global variables and constants */ 
        int[] arrOne = new int[ARRSIZE];                                        // First array to store user input
        int[] arrTwo = new int[ARRSIZE];                                        // Second array to store user input
        
        /* Display greeting */
        System.out.println("Software & Programming II: Coursework 1");          // Display assignment title
        System.out.println("---------------------------------------");          // Display underline
        System.out.println();                                                   // Line break
        
        
        /* Populate arrays */
        System.out.println("Please enter values for Array One");                // Tell user we need array one values
        fillArray(arrOne, 1);                                                   // Populate Array One with user input
        System.out.println();                                                   // Like break
        
        System.out.println("Please eneter values for Array Two");               // Tell user we need array two Values
        fillArray(arrTwo, 2);                                                   // Populate Array Two with user input
        System.out.println();                                                   // Line break
        
        
        /* Display results */
        if(arrayIsEmpty(arrOne) && arrayIsEmpty(arrTwo)) {                      // Check both arrays have values, if they are:
        
            System.out.println("Both arrays are empty");                         // Inform user and terminate program

        }
        else{                                                                   // If at least one array has values
            
            if(arrayIsEmpty(arrOne)){                                           // Check if array one is empty, if it is
                System.out.println("Array One is empty");                       // Inform user array is empty 
            }
            else{                                                               // If the array has values:
                System.out.print("Values for Array One: ");                     // Tel l user we are displaying array one elements
                displayElements(arrOne);                                        // Display elements in array one
                System.out.println();                                           // Line break
            }
            
            if(arrayIsEmpty(arrTwo)){                                           // Check if array two is empry, if it is:
                System.out.println("Array Two is empty");                       // Inform user array is empty
            }
            else{                                                               // If the array has values
                System.out.print("Values for Array Two: ");                     // Tell user we are displaying array two elements                  
                displayElements(arrTwo);                                        // Display elemenets in array two
                System.out.println();                                           // Line break
            }
            
            displayCommon(arrOne, arrTwo);                                      // Display common data
            
        }
    }
    
    
    
    /**
    * Accept user input to populate an array with integers.
    * <p>
    * As Java passes array references, this method will not return a value
    * but rather modify the array directly.
    * 
    * @param  arrIn the array to be populated
    * @param  arrNumIn the number of the array (as to be display to the user)
    */
    public static void fillArray(int[] arrIn, int arrNumIn) {
        
        /* Declare variables / object needed */
        int arrPos = 0;                                                         // Counter to store where we are in the array
        int input = -99;                                                        // Variable to store user input, arbitary default value
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
                else if(input != SENTINEL){                                     // If the element is not unique
                    System.out.println("Each element must be unique!");         // Display error message to user
                }
        }
        
    }
    
    
    
    /**
    * Check if a value already exists in a given array
    * <p>
    * Cycles through an array to check if an identical value already exists
    * in that array
    * 
    * @param  arrIn     the array to be checked
    * @param  elementIn the value to check for in the array
    * @return           true if element does not already exist in the array
    */
    public static boolean elementUnique(int[] arrIn, int elementIn) {
        
        /* Set variables */
        boolean rv = true;                                                      // Set return value with default of true
        
        /* Process array for existing values */
        for(int e : arrIn) {                                                    // Cycle through each element in the array
            if(e == elementIn) {                                                // Check if the element exists
                rv = false;                                                     // Element exists in array, so set return value to false
            }
        }
        
        /* Return result */
        return rv;                                                              // Return result to calling function
        
    }
    
    
    
    /**
    * Check if a value already exists in a given array
    * <p>
    * Cycles through an array to check if an identical value already exists
    * in that array
    * 
    * @param  arrIn     the array to be checked
    */
    public static void displayElements(int[] arrIn) {
        
        for(int e : arrIn) {                                                    // Loop through each element in the array
            if(e != 0) {                                                        // Check that the element is not zero
                System.out.print(e + " ");                                      // Then display the element on screen
            }
        }
        
    }
    
    
    
    /**
    * Compare two arrays and display the values that are common to both and
    * the values that are unique to each
    * <p>
    * Cycles through an two arrays comparing them.  The values that are unique,
    * non-unique and the count of unique values are written to the console
    * @param  arrOneIn  first array to be processed
    * @param  arrTwoIn  second array to be processed
    */
    public static void displayCommon(int[] arrOneIn, int[] arrTwoIn) {
        
        /* Declare variables */
        int countCommon = 0;                                                    // Count the number of common elements
        int countArrOneNonCommon = 0;                                           // Count number of non common elements in array one
        int countArrTwoNonCommon = 0;                                           // Count number of non common elements in array two
        int[] arrCommon = new int[ARRSIZE];                                     // Array to hold values common to both arrays
        int[] arrOneNonCommon = new int[ARRSIZE];                               // Array to hold non-common values from array one
        int[] arrTwoNonCommon = new int[ARRSIZE];                               // Array to hold non-common values from array two
        boolean match = false;                                                  // Has a match been found
        
        /* Find common values and unique values in array one */
        for(int e : arrOneIn) {                                                 // Loop through all values in array one
            
            match = false;                                                      // Set match to false as we're check a new value
            
            for(int f : arrTwoIn) {                                             // Compare to all values in array two
                
                if(e == f) {                                                    // If elements match t
                    match = true;                                               // set match to true
                }
                
            }
            
            if(match && elementUnique(arrCommon, e)) {                          // If there was a match and element not already been added to common lis
                arrCommon[countCommon] = e;                                     // add to common list
                countCommon++;                                                  // and increase count of elements in common list
            }
            else {                                                              // If there was not a match
                    arrOneNonCommon[countArrOneNonCommon] = e;                  // add element to non-common list
                    countArrOneNonCommon++;                                     // and increment the counter of non-common elements
                }
 
        }
        
        
        /* Find unique values in array two */
        for(int e : arrTwoIn) {                                                 // Loop through all values in array two
            
            match = false;                                                      // Set match to false as we're checking a new value
            
            for(int f : arrOneIn) {                                             // Compare to all values in array one
                
                if(e == f) {                                                    // If elements match
                    match = true;                                               // set match to true
                }
                
            }
            
            if(!match) {                                                        // If there was not a match
                    arrTwoNonCommon[countArrTwoNonCommon] = e;                  // add element to non-common list
                    countArrTwoNonCommon++;                                     // and increment the counter of non-common elements
                }
 
        }
        
        
        System.out.print("Common data is: ");                                   // Tell user we are displaying array two elements                  
        displayElements(arrCommon);                                             // Display elemenets in array two
        System.out.println(); 
        
        System.out.println("Number of common data is: " + countCommon);         // Display number of common data
        
        System.out.print("Non-common values for array one are: ");              // Tell user we are displaying non-common elements in array one
        displayElements(arrOneNonCommon);                                       // Display non-common elemenets in array one
        System.out.println(); 
        
        System.out.print("Non-common values for array two are: ");              // Tell user we are displaying non-common elements in array one
        displayElements(arrTwoNonCommon);                                       // Display non-common elemenets in array one
        System.out.println(); 
        
    }
    
    
    
    /**
    * Check if an integer array contains any values
    * <p>
    * Cycles through an array to check at least one element has a value
    * other than zero (the default value assigned by Java to arrays of 
    * int datatype)
    * 
    * @param  arrIn     the array to be checked
    * @return           true if array does not have any values other than zero
    */
    public static boolean arrayIsEmpty(int[] arrIn) {
        
        /* Declare return value */
        boolean rv = true;                                                      // Set return value to default of false
        
        /* Check array for values */
        for(int e : arrIn) {                                                    // Loop through each value in the arry
            if(e != 0) {                                                        // If it is not zero,
                rv = false;                                                     // set return value to true
            }
        }
        
        /* Return result */
        return rv;                                                              // Return result to calling function
        
    }
}
