/**
 * 
 * PIPING
 * 
 * java PopulationAge 4000 | java PopulationAverageAge
 * Output of one program into another
 * 
 * Generates random ages
 */

public class PopulationAge {

    public static void main(String[] args) {
        // read an integer from the command line: number of people in th etown

        int n = Integer.parseInt(args[0]);

        // generate n random numbers and print them out
        for ( int i = 1; i <= n; i++){

            int age = (int)(Math.random()*120);
            StdOut.println(age);
        }

    }
}