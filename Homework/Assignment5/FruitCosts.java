/**
 * FruitCosts 
 * 
 * 1. This program reads in a list of fruits and their costs from a file (args[0]).
 * 2. Then finds the two lowest cost fruits and prints their names and costs
 * along with the total cost.
 * 
 * @author Srimathi Vadivel
 * @author Sarah Benedicto
 */
public class FruitCosts {
    /**
     * Main function to execute the program
     * 
     * @param args command-line arguments, where args[0] is the file name to read from
     */
    public static void main(String[] args) {

	// Do not remove this line, it opens the file for reading.
	StdIn.setFile(args[0]);
  
	// StdIn.readDouble, StdIn.readString() to read from the file
    String cheapest1 = "NONE";
    String cheapest2 = "NONE";
    double price1 = 100000000;
    double price2 = 100000000;
	// WRITE YOUR CODE HERE
    int num = StdIn.readInt();
    for ( int i = 0; i<num; i++){
        String name = StdIn.readString();
        double price = StdIn.readDouble();

        if (price < price1){
            price2 = price1;
            cheapest2 = cheapest1;
            price1 = price;
            cheapest1 = name;
        }
    }
	
    StdOut.print(cheapest1 + " ");
    StdOut.println(price1);
    StdOut.print(cheapest2 + " ");
    StdOut.println(price2);
    StdOut.print("Total ");
    StdOut.println(price1+price2);
    }
}
