public class Patterns {
    // Pattern Printing exercise
    public static void main(String[] args) {
        // PATTERN 1
        // Solid Rectangle

        // ------> 5
        // * * * * * * |
        // * * * * * * | -> 4
        // * * * * * * | -> 4
        // * * * * * * |
        // ------> 5

        // user input
        int row = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);

        // X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X 

        // outer loop, which manages the number of rows printed
        // for ( int i = 1; i<=row;i++){
        //     // inner loop, whihch manages the numer of columns
        //     for ( int j = 1; j<=col ; j++){
        //         System.out.print("* ");
        //     }
        // System.out.println();
        // }
        
        // X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X 

        // PATTERN 2
        // Hollow Rectangle
        
        // * * * * * 
        // *       *
        // *       *
        // * * * * * 


        // X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X

        //  for (int i = 1; i<=row;i++){
        //     for ( int j = 1; j<=col; j++){
        //         if ((i==1) || (i==row)){
        //             System.out.print("* ");
        //         }else{
        //             if ((j==1) || (j==col)){
        //                 System.out.print("* ");
        //             }else{
        //                 System.out.print("  ");
        //             }
        //         }
        //     }
        //     System.out.println();
        //  }

        // ---------------------------------------------------------------

        // Alternate method
        // tracing the boundry of the shape and only printing *'s where
        // they are in boundreis => when i or j == 1(first row and first column) 
        // or i or j == row or column(last row and last column)


        // for ( int i = 1; i<=row;i++){
        //     for ( int j = 1; j<=col;j++){
        //         if (i==1 || j==1 || i==row || j==col){
        //             System.out.print("* ");
        //         }else{
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }

         // X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X

        // PATTERN 3
        // Half Pyramid

        // * 
        // * *
        // * * *
        // * * * *
        // * * * * *

        for ( int i = 1; i<=row; i++){
            for (int j = 1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }   
}
