/*
 * Bakery program for the cashier
 * 
 */
public class Cake {//EVERY PROGRAM IN JAVA is coded inside a class
    
    // main method is the entry point of the program

    public static void main(String[] args){
        // WRITE YOUR CODE HERE

        // Reading Cake size
        int cakeSize = Integer.parseInt(args[0]);


        if ( cakeSize <= 0 ){
            System.out.println("Error");
        } else {
            // if the program comes here this means that the cakeSize is greater thatn 0

            if (cakeSize < 6){
                System.out.println("10");
            }else{
                // here cake size is greather than 6
                if (cakeSize <=12){
                    System.out.println("15");
                }else{
                    System.out.println("20");
                }
            }

        }

    }
}
