public class CatsStdIn {
    public static void main(String[] args) {
        // Use StdIn instead of command line arguments
        System.out.print("Enter number of lines ellen has:- ");
        int ellenCats;
        ellenCats = StdIn.readInt();

        while( ellenCats < 0){
            System.out.print("Enter a positive number of cats:- ");
            ellenCats = StdIn.readInt();
        }

        System.out.print("Enter number of cats ellen has:- ");
        int anaCats = StdIn.readInt();

        while( anaCats < 0){
            System.out.print("Enter a positive number of cats:- ");
            anaCats = StdIn.readInt();
        }

        if (ellenCats <0 || anaCats < 0){
            System.out.println("ERROR");
        }else{
            System.out.println("Total number of cats are:- " + (ellenCats+anaCats));
        }
    }
}
