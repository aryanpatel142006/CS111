public class Recursion {
    public static int numBunnyEars(int n){
        if ( n == 0 ){
            return 0;
        }

        return 2 + numBunnyEars(n-1);
    }

    public static int Fibbonacci( int n ){
        // base case
        if ( n == 1 || n == 2 ){
            return 1;
        }

        return Fibbonacci(n-1) + Fibbonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(numBunnyEars(11));
        System.out.println(Fibbonacci(10));
    }

}

