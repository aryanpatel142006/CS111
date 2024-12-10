public class Driver {
    /**
     * Navigate to the RURacing directory and compile the files using the following:
     * Compilation: javac -d bin *.java
     * Execution: java -cp bin Driver
     */
    public static void main(String[] args) {
        // Compilation: javac -d bin src/ruracing/Driver.java
        // Execution: java -cp bin ruracing.Driver
        // use -ea option when running, helps verify test cases

        // You will be responsible for implementing the methods in RURacing.java
        // To test your implementation you must create your own test cases
        // and verify that your implementation is correct. All methods will be
        // tested through RURacing.methodName() calls.
        StdOut.print("Enter the track file:- ");
        int[] TrackPts = RURacing.readTrackFile(StdIn.readString());
        // for (int i = 0; i < Track.length; i++){
        //     StdOut.println(Track[i]);
        // }

        char[][] Track = RURacing.createRaceway(TrackPts);
        RURacing.printMap(Track);

        RURacing.racer1(Track);
        StdOut.println(" <------------------------------ THIS IS RACER 2 ------------------------------>");
        RURacing.racer2(Track);
        StdOut.println(" <------------------------------ THIS IS RACER 3 ------------------------------>");
        RURacing.racer3(Track);
        StdOut.println(" <------------------------------ THIS IS RACER 4 ------------------------------>");
        RURacing.racer4(Track);



        
    }
}
