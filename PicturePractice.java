import java.awt.Color; // importing the Color class
// importing a class allows us to instantiate objects of that type


public class PicturePractice {
    public static void main(String[] args) {
        
        // pic is a reference to an object of type Picture
        Picture pic1 = new Picture("pic1.jpg"); // creating a new object
        pic1.show();

        Picture pic2 = new Picture("pic2.jpg");
        pic2.show();

        // display the size of the picture
        StdOut.println("Number of Pixels: " + pic2.height() * pic2.width());

        // convert flo's image into grayscale
        // traverse the entire image and convert each pixel (Color object) to grey

        for (int row = 0; row < pic2.height(); row++){
            for (int col = 0; col < pic2.width(); col++){
                Color originalPixel = pic2.get(col,row); // retrieves the pixel at (col,row)
                Color grayPixel = convertToGray(originalPixel); // created a new object with gray version of OG pixel
                // update the image's pixel
                pic2.set(col,row,grayPixel);
            }
        }
        pic2.show();
    }
    public static Color convertToGray(Color c) {
        
        // Read red, greeen, blue components.

        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();


        // compute luminance - gray color
        double luminance = 0.299 * r + 0.587 * g + 0.114 * b;
        int lum = (int)Math.round(luminance);


        // create a new object of type Color
        Color newColor = new Color(lum,lum,lum);

        // return the new color
        return newColor;
    }
    
}
