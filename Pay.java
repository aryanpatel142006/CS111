/*
 * Computes the total pay given hours worked and pay rate.
 * 
 * To compile: javac Pay.java
 * TO Execute: java Pay [ARGUMENTS GOES HERE]
 */

public class Pay {
    /*
     * The main method is the entry point of the program.
     * It is where execution starts.
     */
    public static void main (String[] args){
        // Write coede inside the main method
        // hours worked will be in args[0] - first input
        //hours worked is real number: we use the double data type
        //Double.parseDouble() transforms the input as a double
        double hoursWorked = Double.parseDouble(args[0]);

        //pay rate will be in args[1] - second input
        double payRate = Double.parseDouble(args[1]);

        // check for errors

        if ( hoursWorked < 0 || payRate <= 0 ){
            // "" denotes a string(characters together)

            System.out.println("Error");
        }else{
            System.out.println( "Compensation is: " + hoursWorked * payRate );
        }


        //Code goes here

    }
}
