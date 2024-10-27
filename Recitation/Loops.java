public class Loops{
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        for (int i = 1;i<(n+1);i++){
            System.out.print(i);
            System.out.print(", ");  
        }
        System.out.println();
        
        for (;n>0;n--){
            System.out.print(n);
            System.out.print(", ");
        }

        System.out.println();
   
        int num = Integer.parseInt(args[1]);
        for ( int row = 0 ; row < num ; row++ ){
            for (int col = 0;col<=row;col++){
                System.out.print("* ");
            }
            System.out.println();
        }

        
    }
}