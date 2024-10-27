public class Array {
    public static void main(String[] args) {
        int arrsize = Integer.parseInt(args[0]);
        int index0 = Integer.parseInt(args[1]);
        // Declaring the array
        int[] array = new int[arrsize];
        array[0] = index0;
        //populating the array
        for (int i = 1 ; i < arrsize ; i++){
            array[i] = array[i-1] * 2;
        }
        //Printing the array
        for (int i = 0; i<arrsize;i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}
