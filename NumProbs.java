/*
 * Every java program or library has to be inside a class
 * 
 * NumProbs is a library of functions
 */
public class NumProbs {
    /*
     * factorial is a function
     * Public static are the modifiers
     * int is th ereturn type
     * factorial is the naem
     * int number is the paramenbter
     * 
     */

     public static long factorial(int number){

        long fact = 1;

        for ( int i = 1; i<= number; i++ ){
            // 1 * 2 * 3 * ...... * n
            fact *= i;
        }
        // return the value of the variable fact
        return fact;
     }


    /*
     * Returns the numenr of digits int eh parameter number
     */
    public static int digits (int number){

        if ( number == 0 ){
            // 1 digit
            return 1; // interrupts the program, returns back to the callar
        }
        int nbrDigits = 0;
        while( number > 0 ){
            number /= 10; // removed the rightmost digit
            nbrDigits += 1; // accounted for the rightmost digit
        }

        return nbrDigits;

    }

    /*
     * Returns the smaller value of two integer inputs.
     * 
     * Returns one of the values if both inputs are equal
     */

    public static int minimum (int v1, int v2){
        int min = 0;

        if (v1 < v2){
            min = v1;
        }else{
            min = v2;
        }

        return min;
    }


    // itterative function to print all numbers from 1 to n

    public static void printN(int n) {
        int i = 1;
        while (i <= n){
            StdOut.println(i);
            i++;

        }
    }


    // recursive function to print all numbers from 1 to n

    public static void recursivePrintN(int i, int n){

        StdOut.println(i);
        if ( i < n ){
            recursivePrintN(i+1, n);
        } else{
            return;// stop
        }

        return; // implicit in all functions

    }

    // recursive counting the number of digits

    public static int recursiveNumberOfDigits ( int n ){
        if ( n == 0) return 0; // Base Case
        int count = 1 + recursiveNumberOfDigits(n/10);
        return count;
    }


    public static int findSum(int A[], int i) {
        
        // base caseL i is at the last index of the

        if ( i == A.length-1) {
            return A[i];
        }

        int sum = A[i] + findSum(A, i+1);
        return sum;
    }
}
