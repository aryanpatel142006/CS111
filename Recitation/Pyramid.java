public class Pyramid {
    public static void main(String[] args) {
        int x = 4;
        for (int row = 1 ; row <= x; row++){
            int y = 4;
            for (int spaces = (y/2) ; spaces>0 ; spaces--){
                System.out.print("*" + spaces);
                System.out.print("!");
            }
            y--;
            for (int numbers = row ; numbers>0 ; numbers--){
                System.out.print(row + " ");
            }
            System.out.println();
        }

    }
}
