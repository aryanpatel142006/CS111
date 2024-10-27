public class IfElse {
    public static void main(String[] args) {
        int a = 10;
        // // Does the indentation matter or only the starting and ending curly braces matter?
        // if ( a%2 == 0 ) {System.out.println("EVEN");
        //     System.out.println("LOL");}

        /* 
         * Printing the sum of n numbers
         */

         int n = Integer.parseInt(args[0]);
        int sum = 0;
         for (int i = 1; i<=n ; i++){
            System.out.print(i + " ");
            sum+=i;
         }
         System.out.println();
         System.out.println("Sum of all the Integers till " + n + " is => " +sum);
    }
}