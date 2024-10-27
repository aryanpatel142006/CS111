/*
 * Write your program inside the main method to find the order
 * which the bus the student needs to take will arrive
 * according to the assignemnt description. 
 *
 * To compile:
 *        javac BusStop.java
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */
public class bus {

    public static void main(String[] args) {

        // Createing an array to store the bus routes
        char[] buses = new char[args.length - 1];

        // Populate the array with the first n-1 bus routes
        for (int i = 0; i < args.length - 1; i++) {
            buses[i] = args[i].charAt(0);
        }

        // Geting the bus serena is waiting for
        char SerenasBus = args[args.length - 1].charAt(0);

        // Setting Busfound as false 
        Boolean BusFound = false; // we have to print -1 (not found) if bus not found

        for (int i = 0; i < buses.length; i++) {
            if (buses[i] == SerenasBus) {
                System.out.println(i+1); // printing index + 1 (which is the order of the bus.)
                BusFound = true; // Exit loop once found
                break;// Exiting the loop if found the bus
            }
        }

        // Print the result
        if ( BusFound == false ){
            System.out.println(-1);
        }
        
    }
}

