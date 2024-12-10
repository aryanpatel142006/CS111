public class Searching {
    
    /*
     * Sequential Search or Linear Search
     * 
     * Worst-case running time for success: target is at the last position. f(n) = n => O(n)
     * Best-case running time for success: target is at the first position. f(n) = 1 => O(1)
     * Running time for failure: f(n) = n => O(n)
     * 
     * 
     * @param target the search item
     * @param a the array
     * @return array index on a successuful search, or -1 if target is not found.
     */

    // Doesn't need Array to be sorted
    public static int sequentialSearch (Integer target, Integer[] a) {

        for (int i = 0; i < a.length; i++ ) {
            if ( a[i].compareTo(target) == 0 ) { // count compare towards running time
                // found target
                return i; // return the index where target is located
            }
        }
        return -1; // target wasn't found
    }

    /*
     * Iterative Binary Search
     * Searches for @target at array @a from indices [lo, hi)
     * Returns the index of @target of -1 is not found.
     */
    public static int iBinarySearch (Integer target, Integer [] a) 
    {
        //System.out.print(indent + "search("+key+",a,"+lo+","+hi+"); ");
        int hi = a.length; // hi is not included in the search
        int lo = 0; // lo is included
        String indent = "";

        while ( hi > lo ) {
   
            int mid = lo + (hi - lo) / 2; // compute the middle point
            System.out.println(indent + "(" + lo + "," + mid + "," + hi + ")");
            
            // compareTo returns < 0 if a[mid]<target, >0 if a[mid]>target, =0 if a[mid]==target
            int cmp = a[mid].compareTo(target); // count this comparison (one array access)

            if (cmp == 0 ){
                System.out.println(indent+"found at: " + mid);
                return mid;
            } else if (cmp > 0) {
                hi = mid; // target is smaller than a[mid]
                indent += "\t";
            } else {
                lo = mid + 1; // target is greater than a[mid]
                indent += "\t";
            } 
        }
        return -1; // target not found
    }

    /*
     * Recursive Binary Search
     * Searches for @target at array @a from indices [lo, hi)
     * Returns the index of @target of -1 is not found.
     */
    public static int rBinarySearch (Integer target, Integer [] a, int lo, int hi, String indent) 
    {
        System.out.print(indent + "search("+target+",a,"+lo+","+hi+"); ");
        if (hi <= lo) return -1; // key is not present in array a
   
        int mid = lo + (hi - lo) / 2;
        System.out.println(indent + "(" + lo + "," + mid + "," + hi + ")");
        
        int cmp = a[mid].compareTo(target); // count this comparison (one array access) OR the number of calls to the method

        if (cmp == 0 ){
            System.out.println(indent+"found at: " + mid);
	        return mid;
        } else if (cmp > 0) {
            // target is smaller than a[mid]
            return rBinarySearch(target, a, lo, mid, indent+"\t");
        } else {
            // target is greater than a[mid]
            return rBinarySearch(target, a, mid+1, hi, indent+"\t");
        } 
    }

    public static void main (String[] args) {

        Integer[] array = {5, 8, 15, 18, 22, 24, 54, 68, 87, 88, 91, 105};
    }
}
