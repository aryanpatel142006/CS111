import java.awt.Color;
/*************************************************************************
 *  Compilation:  javac Matryoshka.java
 *  Execution:    java Matryoshka n
 *
 *  @author Pooja Kedia
 *
 *************************************************************************/
public class Matryoshka {
    /**
     * Helper method to draw face on the 'head' structure of the doll
     * 
     * @param  head_x the x-coordinate of the center of doll's head
     * @param  head_y the y-coordinate of the center of doll's head
     * @param  radius the radius of the doll's body
     */
    public static void drawFace(double head_x, double head_y, double radius){
        //DO NOT EDIT
        StdDraw.setPenColor(Color.black);
        StdDraw.filledCircle(head_x+((1.0/5.0)*radius),head_y+((1.0/6.0)*radius),radius*(1.0/10.0));
        StdDraw.filledCircle(head_x-((1.0/5.0)*radius),head_y+((1.0/6.0)*radius),radius*(1.0/10.0));
        StdDraw.line(head_x-((1.0/8.0)*radius), head_y-((1.0/6.0)*radius), head_x+((1.0/8.0)*radius), head_y-((1.0/6.0)*radius));
        StdDraw.arc(head_x,head_y-((1.0/6.0)*radius),((1.0/8.0)*radius),180,360);

    }
    /**
     * Draws a circle as the doll body using the specified x,y and radius values,
     * Draws another circle of 1/2 times the size placed on top of body as the 'head',
     * Calls helper method drawFace with the x,y coordinates that are the center of the 'head' circle and body radius.
     * 
     * @param  x the x-coordinate of the center of doll's body
     * @param  y the y-coordinate of the center of doll's body
     * @param  radius the radius of the doll's body
     */
    public static void drawDoll(double x, double y, double radius){
        //WRITE YOUR CODE HERE
    }

     /**
     * Draws a doll at initially specified position, 
     * draws another doll of 5/7 times the size adjacent to previous doll,
     * terminates when there are no dolls remaining to draw.
     * 
     * @param  x the x-coordinate of the center of doll's body
     * @param  y the y-coordinate of the center of doll's body
     * @param  r the radius of the doll's body
     * @param dolls the number of dolls to be drawn in succession
     */
    public static void stackDolls(double x, double y, double r, int dolls){
        //WRITE YOUR CODE HERE
    }

    /**
     * Takes in an integer command-line argument dolls,
     * which represents the number of dolls to draw,
     * and draws a succession of Matryoshka dolls on a 1 x 1 canvas
     * @param args command-line arguments
     */
    public static void main(String[] args){
        //WRITE YOUR CODE HERE
    }
}
