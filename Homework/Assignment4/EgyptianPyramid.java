
/**
 * Compilation: javac EgyptianPyramid.java
 * Execution:   java EgyptianPyramid 'size of grid' 'number of initial blocks'
 * 
 * @author Ayla Muminovic
 * @author Kushi Sharma
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 */
public class EgyptianPyramid {
    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    int size = Integer.parseInt(args[0]);
    int TotalBricks = Integer.parseInt(args[1]);

    String[][] array = new String[size][size];

    int startIndex = -1;
    int endIndex = array.length;

    for (int row = (size-1); row >=0 ; row--){
        startIndex+=1;
        endIndex-=1;
        for (int column = 0;  column < size; column++){
            if ((row == (size-1) && (TotalBricks > 0))){
                array[row][column] = "X";
                TotalBricks-=1;
            }else if ( (TotalBricks > 0) && ( (column >= startIndex) && (column <= endIndex) )){
                array[row][column] = "X";
                TotalBricks-=1;
            }else{
                array[row][column] = "=";
            }
            
        }
    }

    for (int i =0; i<array.length ;i++){
        for (int j = 0; j< array[i].length; j++){
            System.out.print(array[i][j]);
        }
        System.out.println();
    }

    System.out.println(TotalBricks + " Bricks Remaining");

    }

    
}
