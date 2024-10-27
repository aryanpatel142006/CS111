public class ReverseDigits {
    public static void main(String[] args){

        // reads
        int num = Integer.parseInt(args[0]);
        int number = num;

        System.out.println("Written with while loop");
        while ( number > 0 ){
            int digit = number % 10;
            System.out.println(digit);

            // remove the last the digit from the number

            number /= 10;// obviously same as number = number / 10
        }
        
        System.out.println("Written with for loop");

        // for ( initialization; test; update)
        // inialization happens before the loop's body executes
        // test happens before the loop's body executes                                                      
        // update happens as the last line in the fore loop

        for ( ;num > 0 ; num/=10 ){
            int digit = num % 10;
            System.out.println(digit);

        }
    }
}
