/*
 * This class contains the specification of an object of type Point.
 * This is the blueprint for what the object contains (instance variables) 
 * and which operations (methods) can be performed on the object.
 */
public class Point {
    
    /*** Instance variables */
    // the private modifier hides x from the client
    private double x;// this.x
    private double y;// this.x

    /*** Constructors */

    // Default Constructor - no arguments
    public Point() {
        x =0;
        y = 0;
    }

    // Constructor
    // the keyword this means THIS OBJECT
    // this.x => refers to the instance variable x
    public Point(double x, double y) { // arguments have the same variable name as the instance varaibles
      this.x =x;
      this.y = y; 
    }

    /*** Methods */
    // Accessor method for instance variable x
    public double getX( ) {
      return x;
    }

    // Accessor method for instance variable y
    public double getY( ) {
        return y;
    }

    // Finds the slope between this object and other object
    public double findSlope(Point other) {
        // p1.findSlope(p2)
        // the valuse of x and y refer to the object thgat is being called
        // other refers to p2
        return ((y - other.getY())/(x - other.getX()));
    }
    
    // finds the midpoint between this object and other object 
    public Point findMidPoint (Point other){
        double midX = (x + other.getX())/2;
        double midY = (y + other.getY())/2;
        return new Point(midX, midY);
    }

    public boolean equals(Object obj)  {
        // check that obj is of type point
        if (obj instanceof Point) {
           Point p = (Point) obj;
           return (this.x == p.x && this.y == p.y);// cast obj as a Point
       } else {
           return false;  
       }
    }

    public String toString() {
        return (   "("+ this.x + ", " + this.y + ")" );
    }

    /*** Client */
    public static void main(String[] args) {
        
        Point p1 = new Point(3,4);
      Point p2 = new Point();
      Point p3 = new Point (3,4);
      System.out.println("p1 = " + p1);
      System.out.println("p2 = " + p2);
      System.out.println("p3 = " + p3);

      Point midpoint = p1.findMidPoint ( p2 ) ;
      System.out.println(midpoint + " is the midpoint between " + p1 + " and " + p2);

      System.out.println(p2.findSlope (p1) + " is the slope between " + p2 + " and " + p1);
      System.out.println ( p1.equals ( p3) );
      System.out.println ( p1 == p3 ); 

    }
}
