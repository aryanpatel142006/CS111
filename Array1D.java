public class Array1D {
    // Towne where it contain spopulation number of people
    public static void main(String[] args) {
        // 1 dimentional array
        int population = Integer.parseInt(args[0]);
        int[] age = new int[population];

        //populate the array
        // index 0 is the first index of ANY array

        for ( int i = 0; i < age.length; i++ ){
            age[i] = (int)(Math.random() * 121);
        }

        // find and display the average town's age

        int sumOfAllAges = 0;
        for ( int i = 0 ; i < age.length; i++){
            sumOfAllAges += age[i]; // sumOfAllAges = sumOfAllAges + age[i]
            System.out.print(age[i] + ", ");
        }
        System.out.println();
        System.out.println("Average town's age = " + sumOfAllAges*1.0/age.length);

        // How to copy an array?
        /*
         * declare another variable
         * create a new array of the same size
         * copy one item at a time
         */

        int[] copyOfAge = new int[age.length];
        for ( int i = 0; i < age.length; i++){
            copyOfAge[i] = age[i];
        }


    }
}
