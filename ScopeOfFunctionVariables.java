public class ScopeOfFunctionVariables {
    public static int f1(int n) {
        n=0;
        return n;
    }

    public static int f2(int n) {
        int value = f1(1);
        return value;
    }

    public static int f3(int n) {
        n *=n;
        return f2(n);
    }


    public static void main(String[] args) {
        
        int n = 5;
        StdOut.println( f3(n));
    }
}
