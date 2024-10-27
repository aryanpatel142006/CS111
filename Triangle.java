public class Triangle {
    public static void main(String[] args){
        //WRITE CODE
        // for real numbers use float or double
        double base = Double.parseDouble(args[0]);
        double height = Double.parseDouble(args[1]);

        if (base<= 0 || height <= 0){
            System.out.println( "Error");
        } else {
            double area = base * height / 2;
            System.out.println("Triangle's area is " + area);
        }
    }
}
