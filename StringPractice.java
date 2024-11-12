public class StringPractice {
    
    public static void main(String[] args) {
        
        String s1; // declaring the reference s1 to be of type String
        // s1 can only refer (point to) an object of type string

        // teh keyword new invokes the constructor String() that creates a new objects
        // create a new object we have an instance of the class
        // create a new ducky: we have an instance of the mold (mold is used with sand and water that we use/play with irl)


        s1 = new String("Chocolate Cake");



    String s2 = s1.substring(10);
    String s3 = s1.substring(0, 9);
    String s4 = "Cake";
    StdOut.println(s1);
    StdOut.println(s2);
    StdOut.println(s3);


    // compare two obects: cannot use ==
    // to compare two objects: use equals() method
    // case sensitive

    if ( s2.equals(s4)) {
        StdOut.println("the content of s2 equals the content of s4");
    }

    // references default values are null
    String ss = null; // ss is NOT refering to any object - ss is not pointing to an object
    StdOut.println(ss);


    // show compareTo

    String s6 = "people";
    String s7 = "cats";

    int c = s6.compareTo(s7);

    StdOut.println("CompareTo value: " + c);

    c = s7.compareTo(s6);
    StdOut.println("CompareTo value: " + c);


    // array of Strings is an array of objects type String

    String[] sArray = new String[5]; // array iniatialized with null

    // each array position is a reference to an object of type String

    for ( int i = 0; i < sArray.length ; i++){
        StdOut.println(i + " - " + sArray[i]);
    }


    // literal strings

    String literal = "";


    }
}
