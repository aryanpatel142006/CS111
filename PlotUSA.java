public class PlotUSA {
    public static void main(String[] args) {

        // reading double values from the standard input
        double ymin = StdIn.readDouble();
        double xmin = StdIn.readDouble();
        double ymax = StdIn.readDouble();
        double xmax = StdIn.readDouble();


        // setting the canvas 

        StdDraw.setXscale(xmin, xmax);
        StdDraw.setYscale(ymin, ymax);

        // Set a pen color
        // RGB: Red Green Blue
        //( , , ) Values range from 0 to 255
        // Black (0,0,0)
        // WHite (255,255,255) , (255, 0,0) Pure Red , (0,255,0) Pure Green, (0,0,255) Pure Blue

        //Set a pen color

        StdDraw.setPenColor(255, 0, 0);

        // Draw one point for each town
        // The towns are in the file with y and x coordinates
        
        // If w edon't know how many lines are in the file
        // use StdIn.isEmpty()
        int c = 0;
        while ( !StdIn.isEmpty()){ // while there are more y,x to read
            double y = StdIn.readDouble();// longitude
            double x  = StdIn.readDouble();// latitude
            StdDraw.point(xmax-x+xmin,y);
            c+=1;
        }
        StdOut.println(c);

    }
}
