public class Client {
    public static void main(String[] args) {
        
        // StdOut.print("Enter an integer number: ");
        // int n = StdIn.readInt();

        // // n is the input/parameter to factorial
        // long f = NumProbs.factorial(n);


        // // f contains the value returned by factorial
        // StdOut.println("Value returned by factorial is " + f);

        // // call digits
        // int dig = NumProbs.digits(n);
        // StdOut.println("Number of digits " + dig);

        StdOut.println( NumProbs.minimum(5,3));

        double[ ] mainArray = ArrayFunctions.createDoubleArray(10);
        
        // double result = ArrayFunctions.minimum(mainArray);
        
        // StdOut.printf("%.5f\n", result);

        ArrayFunctions.printArray(mainArray);

        //call printN in file NumProb

        NumProbs.printN(4);

        // iterative number of digits 
        StdOut.println("number of digits: " + NumProbs.recursiveNumberOfDigits(1234444444));

    }


}
