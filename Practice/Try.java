public class Try {
    public static void main(String[] args){
        int x =  Integer.parseInt(args[0]);
        int y =  Integer.parseInt(args[1]);

        if (x<0 || y<0){
            System.out.println("negative Integer");
        }
        if (x>0 && y>0){
            System.out.println("positive Integer");
        }else{
            System.out.println("neither");
        }
    }
}   
