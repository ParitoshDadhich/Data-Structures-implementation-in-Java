package priorityQueue;


// INSERTION AND REMOVAL OF ELEMENTS IN A HEAP IS HEAP-SORT;
// TIME O(nlogn);
// SPACE O(n);      // we are using an extra arrayList in order to store elements internally

public class PriorityQueueUse {

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		int arr[] = {5,1,9,2,0};
		
		// insertion of each element takes logn time
		// insertion of n elements will be nlogn;
		// TIME: O(nlogn);
		for(int i=0; i<arr.length; i++)
			pq.insert(arr[i]);
		
		// removal of an element takes logn time
		// removal of n elements takes nlogn time;
		// TIME: o(nlogn);
		while(!pq.isEmpty()) 
			System.out.print(pq.removeMin() + " ");
		
		
		System.out.println();
	}

}
