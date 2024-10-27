public class NestedCircle {
    public static void main(String[] args) {
        StdOut.println("Enter a number!");
        int n = StdIn.readInt();
        double r = 0.5;
        double diff = 0.5/(double)n;
        // StdDraw.circle(x,y,r)
        // center of the grid is 0.5,0.5

        for (int i = 0; i<n;i++){
            StdOut.print(i);
            
            StdDraw.circle(0.5, 0.5, r);
            r = r-diff;
        }
    }
}
