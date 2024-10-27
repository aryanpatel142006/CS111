public class Cats {
    public static void main(String[] args) {

        //Write Code
        // The command line arguments come into the program through args and 
        // args[0] is the first argument
        // args[1] is the second argument
        // Integer.parseInt() is interpreting the input as an integer

        int ellenCats; //declare a variable of type integer
        ellenCats = Integer.parseInt(args[0]); // equivalent to READ EllenCats
        
        // READ anaCats
        int anaCats = Integer.parseInt(args[1]); //declaring a variable of type integer

        
        // the boolean expression is within the parenthesis
        // OR is this symbol ||

        if (ellenCats<0 || anaCats<0){ // no ; in if
            //DISPLAY Error
            // use double corts to display a message
            System.out.println("Error");
        }else{

            // COMPUTE sumOfCats AS ellenCats + anaCats
            int sumOfCats = ellenCats + anaCats;

            // DISPLAY sumOfCats
            System.out.println(sumOfCats);

        }//ENDIF

    }
}
