/*
 * Displays even if input number is eve, or displays odd if input number is odd.
 */
public class EvenOdd {
    /*
     * Pre-condition: the input is integer
     */
    public static void main(String[] args) {
        
        // read number through args[0]
        int number = Integer.parseInt(args[0])

        // use  == for comparison
        // use = for assignment

        if ( number % 2 == 0){ // DO NOT use ; here
            System.out.println("even");
        }else{
            System.out.println("odd");
        }
    }
}
