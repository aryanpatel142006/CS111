import java.awt.Color;

public class TurtleSanctuary {

    /***
     * Main function => first things that runs when the class is called
     * @param args Inputs from command line - commandline arguments
     */
    public static void main(String[] args) {
        
        int numberOfTurtles = Integer.parseInt(args[0]);
        int numberOfSteps = Integer.parseInt(args[1]);
        double stepSize = Double.parseDouble(args[2]);

        // allocate Turtles

        Turtle[] turtles = new Turtle[numberOfTurtles];

        // create each Turtle object <=> instantiate objects of type Turtle

        for ( int i = 0; i < turtles.length; i++ ){
             // randomly positionsing the turtles

            double x = StdRandom.uniform(0.0,1.0);
            double y = Math.random();

            // random color turtles
            int r = (int)(Math.random() * 255);
            int g = (int)(Math.random() * 255);
            int b = (int)(Math.random() * 255);
            Color c = new Color(r,g,b);


            // instantiate (create) the object

            turtles[i] = new Turtle(x,y, 0.0, c);    
        }

        //each turtle taking many steps
        for ( int s = 0; s< numberOfSteps; s++){
            // each turtle take ONE step
            for ( int i = 0; i< turtles.length; i++){
                double angle = Math.random() * 361;
                turtles[i].turnLeft(angle);
                turtles[i].goForward(stepSize);
            }
        }
        





        // test



        // //each turtle taking many steps
        // for ( int s = 0; s< numberOfSteps; s++){
        //     // each turtle take ONE step
        //     // random color turtles
        //     int r = (int)(Math.random() * 255);
        //     int g = (int)(Math.random() * 255);
        //     int b = (int)(Math.random() * 255);
        //     Color c = new Color(r,g,b);

        //     for ( int i = 0; i< turtles.length; i++){
        //         double angle = Math.random() * 361;

        //         turtles[i].turnLeft(angle);
        //         turtles[i].goForward(stepSize);
        //     }
        // }
        
    }
}