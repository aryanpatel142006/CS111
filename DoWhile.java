public class DoWhile {
    public static void main(String[] args) {
        /*
         * Practide do-while and while loops
         */

         // while
         int i = 1;
         while ( i <= 5 ){
            System.out.print(i + " ");
            i++;
         }

         // do-while
         // one loop iteration without a check

         i = 9;
         do {
            System.out.print(i + " ");
            i++;
         } while ( i <= 5 );
    }
}