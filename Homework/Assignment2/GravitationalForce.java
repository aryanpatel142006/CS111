/*
 * Write your program inside the main method to compute the 
 * Gravitational Force according to the assignment description.
 * 
 * To compile:
 *        javac GravitationalForce.java
 * To execute:
 *        java GravitationalForce 36000.0 1080.0 50.0
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 * F = g * (m1 * m2) / (r * r) where g is 6.6743e-11
 */

public class GravitationalForce {

    public static void main(String[] args) {
       
        // WRITE YOUR CODE HERE
        double m1 = Double.parseDouble(args[0]);
        double m2 = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        double g = 6.6743e-11;
        double f;
        f = g * (m1 * m2) / (r * r);
        System.out.print(f);

    }
}
