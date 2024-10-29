public class Swap {
    public static void swaping(int [] arr, int index1, int index2){
        int n1 = arr[index1];

        arr[index1] = arr[index2];
        arr[index2] = n1;
    
    }

    public static int max(int[] arr){
        // ths will return the maximum integer in the array
        int max = arr[0];
        for ( int i = 1; i<arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args){

        /*
         * creating an array
         */

        int[] a1 = {1,2,3000,4,5,6};

        /*
         * Printing the array
         */

        System.out.print("{");
        for ( int i = 0; i<a1.length; i++){
            System.out.print(a1[i]);
            System.out.print(", ");
        }
        System.out.print("}");


        
        // calling swaping method
        
        swaping(a1,1,5);

        System.out.print("  ->  ");
        /*
         * Printing the updated array
         */

        System.out.print("{");
        for ( int i = 0; i<a1.length; i++){
            System.out.print(a1[i]);
            System.out.print(", ");
        }
        System.out.println("}");




        /*
         * Calling max method
         */


         int maximunVal = max(a1);
         System.out.println(maximunVal);
    }
}
