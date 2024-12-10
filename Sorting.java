public class Sorting {

	public static void print(int[] a) {
		for ( int i = 0; i < a.length; i++ ) {
			
			System.out.print(a[i]);
			if ( i != a.length-1 ) 
				System.out.print(",");
		}
		System.out.println();
	}
	public static void selectionSort(int[] a) {

		int n = a.length;
		System.out.println("--Selection");
		// i is the start of the unsorted region
		// all items before i are on their final position
     	for ( int i = 0; i < n; i++ ) {

			// find the smallest value between i and n-1
			int min = i;
            for (int j =  i + 1; j < n;  j++) {
                if (a[j] < a[min] ) 
					min = j;
             }
			 // swap a[i] with a[min]
             int tmp = a[i];
             a[i]  = a[min];
             a[min] = tmp;
			 print(a);
     	}
	}

	public static void insertionSort (int[] a) {
		
		int n = a.length;
      	System.out.println("--Insertion");
		// i marks the beginning of the unsorted region
		for (int i = 1; i < n; i++) {
         
			for (int j = i; j > 0; j--) {

				if ( a[j-1] > a[j] ) {
					// swap a[j-1] with a[j]
					int tmp = a[j-1];
					a[j-1] = a[j];
					a[j] = tmp;
				} else {
					break;
				}
		 	}
			print(a);
		}
	}

    public static void mergesort (int[] a, int lo, int hi) {
		if (lo >= hi) return;
		int middle = (lo+hi)/2;
		mergesort(a, lo, middle);
		mergesort(a, middle+1, hi);
		merge(a, lo, middle, hi);
    }

    public static void merge (int[] a, int l, int m, int r){

	//copy lower half of the array into b
	int[] b = new int[m-l+1];
		for(int i=0; i<=m-l; i++){
			b[i] = a[l+i];
		}

		int i=0,j=m+1,k=l;
		while(i <= m-l && j <= r){
			
			if (a[j] < b[i] ) {
				a[k] = a[j];
				k+=1;
				j+=1;
			} else {
				a[k] = b[i];
				k+=1;
				i+=1;
			}
		}
		while ( i <= m-l ) {
			a[k] = b[i]; k+=1; i+=1;
		}
		while ( j <= r ) {
			a[k] = a[j]; k+=1; j+=1;
		}
    }

	private static int partition(int[] a, int lo, int hi){
	
		int i = lo, j = hi+1;
		while (true) {
		   while ( a[++i] < a[lo] ) {
				if (i == hi) break;
		   }
		   while ( a[lo] < a[--j] ) {
		        if (j == lo) break;
		   }   
		   if (i >= j) break;
		   swap(a, i, j);
		}
		swap(a, lo, j);
		print(a);
		return j;
	} 

	public static void quicksort (int[] a, int lo, int hi) {
		System.out.println("--Quicksort");
		if ( hi <= lo ) return;
		int p = partition(a, lo, hi);
		quicksort(a, lo, p-1);
		quicksort(a, p+1, hi);
	}

	public static void swap (int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	 
    public static void main (String[] args) {
	
	//int[] a = {6, 2, 9, 11, 5, 7, 1, 3};
	int[] a = {11,8,12,9,3,6,4,2};
	insertionSort(a);
	int[] b = {11,8,12,9,3,6,4,2};
	//int[] b = {6, 2, 9, 11, 5, 7, 1, 3};
	selectionSort(b);
	// mergesort(a, 0, a.length-1);
	
	int[] c = {6, 15, 2, 9, 11, 5, 7, 14, 3, 8};
	quicksort(c,0,c.length-1);
	}
}
