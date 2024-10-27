
/*************************************************************************
 *  Compilation:  javac FloorIsLava.java
 *  Execution:    java FloorIsLava n
 *
 *  @author Aryan patel
 *
 **************************************************************************/

public class FloorIsLava {

    public static void main (String[] args ) {


	// WRITE YOUR CODE HERE
        int totalSpaces = Integer.parseInt(args[0]);

        for (int i = 1 ; i <= totalSpaces ; i++){
            if ( i % 2 == 0 ){
                System.out.print( i + " " );
            }  
        }
        
        for (int i = totalSpaces ; i>0 ; i--){
            if ( i % 2 != 0 ){
                System.out.print( i + " " );
            }
        }
    }
}
