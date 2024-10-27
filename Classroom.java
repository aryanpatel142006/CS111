public class Classroom {
    public static void main(String[] args) {
        int nbrStudents = StdIn.readInt();
        // student will stand in line before entering class
        String[] inLine = new String[nbrStudents];

        for ( int i = 0; i < inLine.length; i++){
            inLine[i] = StdIn.readString();
        }

        // display array
        for ( int i = 0; i<inLine.length;i++){
            StdOut.println("[" + i + "]" + inLine[i]);
        }
        // what is the size of the classroom?

        StdOut.print("Enter the numbner of rows in the classroom: ");
        int rows = StdIn.readInt();

        StdOut.print("Enter the numbner of columns in the classroom: ");
        int cols = StdIn.readInt();

        // Create the classroom 2D array

        String[][] room = new String[rows][cols];

        // Sit each student from the line into the room
        // room.length is the numbner of rows
        int k =0; // counter for the inLine array


        // only remove a person 
        for (int r = 0; r<room.length; r++){
            for (int c = 0; c<room[r].length; c++){
                if (k<inLine.length){
                    room[r][c] = inLine[k];
                    inLine[k] = null;
                    k+=1;
                }
                

            }
    
        }
        StdOut.println();
        // print the 2D array room row-wise

        for ( int r = 0; r < room.length;r++){
            for (int c = 0; c<room[r].length; c++){
                StdOut.print(room[r][c] + " ");
                StdOut.println();
            }
        }

        StdOut.println();
        k =0;// first position inLine array
        for ( int c = 0; c < room[0].length; c++){
            for ( int r = 0; r< room.length;r++){
                if ( k < inLine.length){
                    inLine[k] = room[r][c];
                    k += 1;
                    room[r][c] = null;
                }
            }
        }

        // print th line

        for ( int i = 0; i < inLine.length; i++){
            StdOut.print(inLine[i] + " ");
        }

    }
}
