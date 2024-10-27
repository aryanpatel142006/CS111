/*
 * Display even number from 1 to 100
 */

public class DisplayEvenLessThanOneHundred {
    public static void main(String[] args){
        // second algorithm on slide 33
        int num = 1;
        while( num <= 100 ){
            // while loop's body
            if ( num % 2 == 0 ){
                // if's body
                System.out.print(num + ", ");
            }
            num++;
        }
        System.out.println();
    }
}
