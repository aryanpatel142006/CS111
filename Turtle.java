import java.awt.Color;

public class Turtle {

    // instance varaibles - attributes
    // location in the enclosure
    private double x;
    private double y;


    // orientation: direction of the turtle's head
    private double orientation; // abgle

    // each turtle will hava a different color
    private Color color;


    //*****Constructors
    // Default constructor

    public Turtle(){
        x = 0;
        y = 0;
        orientation = 0.0;
        color = new Color(0,255,0); // pure greeen
    }

    // many arguments constructor
    public Turtle(double x, double y, double orientation, Color color){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.color = color;
    }

    // ***** accessor methods
    public double getX() { return x; }
    public double getY() { return y; }
    public double getOrientation() { return orientation; }
    public Color getColor() { return color; }

    // accessor methods to update the values
    // Afrter a vet checkup the turtle is put back in the enclosure
    public void setX( double x ) { this.x =x; }
    public void setY( double y ) { this.y =y; }
    public void setOrientation( double orientation ) { this.orientation = orientation; }


    // string representation of a turtle

    public String toString() {
        return "Turtle (" + x +","+y+"} " + orientation + " " + color;
    }


    // move the turtle's head direction to the left by some angle

    public void turnLeft (double angle) {
        orientation+= angle;
    }


    // make turtle tak one step
    public void goForward(double stepSize){
        double oldx = x;
        double oldy = y;

        x+=stepSize * Math.cos(Math.toRadians(orientation));
        y+=stepSize * Math.sin(Math.toRadians(orientation));

        // draw 
        StdDraw.line(oldx, oldy, x, y);

    }


// ***** MAIN *****

public static void main(String[] args) {
    
    Turtle t1 = new Turtle();
    Turtle t2 = new Turtle(8, 12, 45, new Color(255,0,8));

    StdOut.println(t1);
    StdOut.println(t2);

}


}
