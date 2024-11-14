/*************************************************************************
 * Compilation: javac QuadraticKoch.java
 * Execution: java QuadraticKoch n
 *
 * @author Jeremy Hui
 *
 *************************************************************************/
public class QuadraticKoch {

    /**
     * Gets the set of coordinates to draw one segment of the Quadratic Koch Curve.
     * Returns the coordinates in a 2D array of doubles in the following format:
     * {array of x-coordinates,
     * array of y-coordinates}
     * 
     * @param x0 the x-coordinate of one endpoint
     * @param y0 the y-coordinate of one endpoint
     * @param x5 the x-coordinate of the other endpoint
     * @param y5 the y-coordinate of the other endpoint
     * @return the set of coordinates to draw one segment of the Quadratic Koch
     *         Curve
     */
    public static double[][] getCoords(double x0, double y0, double x5, double y5) {
        // WRITE YOUR CODE HERE
        
        if (x0 == x5){
            double dBetweenPoints = (y5-y0)/3; // distance between the each x cordinate
        double[][] coordinates = {{x0, x0, x0 - dBetweenPoints, x0 - dBetweenPoints, x5, x5},
                                {y0 /* index0 */,y0+dBetweenPoints /* index1 */,y0+dBetweenPoints /* index2 */,y0+dBetweenPoints+dBetweenPoints /* index3 */,y0+dBetweenPoints+dBetweenPoints /* index4 */,y5/* index5 */}};
        return coordinates;
        }else {
            double dBetweenPoints = (x5-x0)/3; // distance between the each x cordinate
        // creating a 2D array [2][5] 
        double[][] coordinates = {{x0 /* index0 */,x0+dBetweenPoints /* index1 */,x0+dBetweenPoints /* index2 */,x0+dBetweenPoints+dBetweenPoints /* index3 */,x0+dBetweenPoints+dBetweenPoints /* index4 */,x5/* index5 */},
                                {y0, y0, y0 + dBetweenPoints, y0 + dBetweenPoints, y5, y5}};
                                return coordinates;
        }   
        
        // double[][] coordinates = new double[2][6];
        // double dx = x5 - x0;
        // double dy = y5 - y0;
        // coordinates[0][0] = x0;
        // coordinates[1][0] = y0;
        // coordinates[0][1] = x0 + dx / 4;
        // coordinates[1][1] = y0 + dy / 4;
        // coordinates[0][2] = x0 + dx / 2;
        // coordinates[1][2] = y0 + dy / 2;
        // coordinates[0][3] = x0 + dx * 3 / 4;
        // coordinates[1][3] = y0 + dy * 3 / 4;
        // coordinates[0][4] = x0 + dx;
        // coordinates[1][4] = y0 + dy;


        //return coordinates;
    }

    /**
     * Gets the set of coordinates from getCoords() to draw the snowflake,
     * and calls Koch on two adjacent array indices with n being one less.
     * The method draws a line between the two endpoints if n == 0.
     * 
     * @param x0 the x-coordinate of one endpoint
     * @param y0 the y-coordinate of one endpoint
     * @param x5 the x-coordinate of the other endpoint
     * @param y5 the y-coordinate of the other endpoint
     * @param n  The current order
     */
    public static void koch(double x0, double y0, double x5, double y5, int n) {
        // WRITE YOUR CODE HERE
        // getting coordinates to create a segment of koch from getCoords method
        double[][] coords = getCoords(x0, y0, x5, y5); 
        // //test
        // System.out.println("------- NEW ------");
        // for ( int i = 0; i < 5; i++){
        //     System.out.print(coords[0][i] + " <- x y -> ");
        //     System.out.println(coords[1][i]);

        // }
        // //test

        // base case if n == 0
        if ( n == 0){
            StdDraw.line(x0, y0, x5, y5);
            return;
        }
        koch(coords[0][0], coords[1][0], coords[0][1], coords[1][1], n-1);
        koch(coords[0][1], coords[1][1], coords[0][2], coords[1][2], n-1);
        koch(coords[0][2], coords[1][2], coords[0][3], coords[1][3], n-1);
        koch(coords[0][3], coords[1][3], coords[0][4], coords[1][4], n-1);
        koch(coords[0][4], coords[1][4], coords[0][5], coords[1][5], n-1);
    }

    /**
     * Takes an integer command-line argument n,
     * and draws a Quadratic Koch Curve of order n in a 1 x 1 canvas
     * with an initial square side length of 0.5.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // WRITE YOUR CODE HERE

        int order = Integer.parseInt(args[0]); // taking valuse of order from command line input

        // calling kock 4 times with different coordinates
    
        koch(0.25, 0.25, 0.25, 0.75, order);
        koch(0.25, 0.75, 0.75, 0.75, order);// success
        koch(0.75, 0.75, 0.75, 0.25, order);
        koch(0.75, 0.25 ,0.25, 0.25, order);// success



        // // test
        // koch(0.25, 0.25, 0.25, 0.75, order);
    }
}