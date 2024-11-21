/*
 * Our CS111 smart array
 * The implementation of a ArrayList like array
 */
public class ArrayListCS111<T> {
 
    // T stands for the data type
    private T[] array;

    // variable that holds the number of items
    private int n;


    ArrayListCS111(){
        // initializes array to size 10
        array = new T[10];
        n =0;
    }

    // add an item to the end of the array
    // the first empty slot in th array
    // Running time: count array accesses (write or read)
    // f(n) = 2n + 1 => term that
    public void add(T item){
        if (n = array.length){
            // array is full; resize
            // create an array double of its original capacity
            T[] nArray = (T[]) new Object[array.length * 2];


            //2. copy everything over
            // there are n items in the array
            // 2 array accesses per iteration => 2n

            for (int i = 0; i<array.length;i++){
                nArray = array[i];
            }

            //2. move array to point to new array
            // there are n items in the array
            array = nArray;

            // What happen s to the old array?
            // The old array is garbage: there are no references to the old array 
            // It will be garbage collected: erased from memory.

        }
        // insert into the array
        array[n] =item;
        n+=1; // increment the number of items
    }

    public boolean contains( T target) {

        // search for target on the first n positions of the array
        // there are only n items in the array

        for ( int i = 0; i<n; i++){
            if ( array[i].equals(target)){
                // found the target in the array
                return true;
            }
        }
        // did not find
        return false;
    }

    /*
     * Removes the target object from the array
     * 
     * Best Case: if we delete n item in the array
     * Worst Case: if we delete the first item which is at index 0
     * 
     * 2n-2+1 = 2n-1 => term that grows faster is 2n => drop the constant => n => 
     * ==> so the complixity of this method is O( )
     */
    
    public boolean remove (T target){
        for ( int i =0; i <n; i++){
            if (target.equals(array[i])){
                // target found
                for ( int j = i; j<n-1; j++){
                    array[j] = array[j+1]; // 1 write + 1 read
                }
                n-=1;
                return true;
            }
        }
        return false; // target not fould
    }

}
