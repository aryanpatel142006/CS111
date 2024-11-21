import java.util.ArrayList;
/*
 * How to use an Array List
 * 
 * They are called smart Arrays
 */
public class ArrayListPractice {
    public static void main(String[] args) {
        
        // create an array
        ArrayList<String> songs = ArrayList<String>();

        // insert an intem
        songs.add("YMCA"); // added to index 0
        songs.add("runaway"); // added to index 1
        songs.add("hey delilah");
        songs.add("i will always love you");
        songs.add("my heart will go on");
        songs.add("let it go");
        songs.add("shake it off");
        songs.add("take on me");
        songs.add("bye bye bye");
        songs.add("hello");
        // at this moment the array is full

        songs.add(" bad blood"); // the array is resizerd to double its size => sinze 10 to 20

        boolean result2 = songs111.contains("bad guy");        
        
        StdOut.println("Does the array contain 'bad guy'?" + songs111.contains("let it go"));

        StdOut.println("Does the array contain 'bad guy'?" + result2);



        
    }  
}
