public class Square {
    public static void main(String[] args) {
        // read n from the command line arguments
        int n = Integer.parseInt(args[0]);

        for (int r = 0; r<n; r++){
            for ( int i = 0; i < n; i++ ){
                System.out.print("* ");   
            }
            System.out.println();
        }

        
        
    }
}
