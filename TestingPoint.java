import java.security.PublicKey;

public class TestingPoint {

    /*
     * Client program is the pogram that uses a class
     * Using the Point class in this client
     * 
     */


    public static void main(String[] args) {
        
        Point p1 = new Point();
        Point p2 = new Point(3, 5);
    
        // access the variable x
        // cannot acces x because it is private
        // StdOut.println(p1.x);
        // StdOut.println(p2.x);


        // use accessor methods
        StdOut.println(p1.getX());
        StdOut.println(p2.getY());

        // invokes findSlope method on the p1
        StdOut.println( p1.findSlope(p2) );

        // invoking findMidPoint method on the p2 object
        StdOut.println( p2.findMidPoint(p1));


        // print object
        // When the object is passed to print
        // the toString() is invoked automatically twhen the obj is printed
        // if that method is not there obj memory location is printed

        StdOut.println(p2);



    }
    
}
