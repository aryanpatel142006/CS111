/*
 PIPING
 * 
 * java PopulationAge 4000 | java PopulationAverageAge
 * Output of one program into another
 * 
 * Reads ages from the standard input adn averages them
 * 
 */
public class PopulationAverageAge {
    public static void main(String[] args) {
        
        int sum = 0;
        int count = 0;// number of numbers read from standard input

        // I don't know how many numbers to read
        while (!StdIn.isEmpty()){// reading while StdIn is not empty
            int age = StdIn.readInt();// read one number
            sum+=age;
            count+=1;

        }
        // there are no more numbers to read
        // foublr sbh = sum*1.0/count;
        double avg = (double)sum/count;
        StdOut.println("Average: " + avg);


    }
}
