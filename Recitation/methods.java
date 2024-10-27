public class methods {
    public static void main(String[] args) {

        int x = 4;
        int y = 5;
        System.out.println(add(x,y));
        
    }

    public static int add(int a, int b){
        return a+b;
    }
    
    public static int TriangleArea(int base, int height){
        return (base*height)/2;
    }

    public static double CelsiusToFahrenheit(double celsius){
        return celsius*(9/5)+32;
    }

    public static double Speed(double distance, double time){
        if (time != 0){
            return ((double)(distance/time));
        }else{
            System.out.println("ERROR time cannot be zero");
            return 0;
        }

    
    }


    public static double Diameter(double radius){
        return (double)2*radius;
    }

}
