/*
 * Library to manipulate arrays
 */

public class ArrayFunctions {

    // Returns the smallest value in the array
    public static double minimum (double[] array){

        double min = array[0]; // take the minimum value to be the first item

        // iterate starting at the second item
        
        for ( int i =1; i<array.length; i++){
            if ( min > array[i]){
                min = array[i]; // found a new minimum
            }
        }
        return min;
    }

    public static double[] createDoubleArray(int n){
        // creat an array

        double[] array = new double[n];

        //initialize the array with random values


        for (int i= 0; i< array.length; i++){
            array[i] = Math.random();
        }

        //return the array that was created

        return array;
    }

    public static void printArray(double[] inputArray){
        // inputArray variable (reference to an array)
        // A reference contains the location of the array in memory
        StdOut.println("printing the Array");

        for ( int i = 0; i < inputArray.length; i++){
            StdOut.println(i + " - " + inputArray[0]);
        }
    }
    
}
