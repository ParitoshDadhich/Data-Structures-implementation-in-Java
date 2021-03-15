package priorityQueue;


// INSERTION AND REMOVAL OF ELEMENTS IN A HEAP IS HEAP-SORT;
// TIME O(nlogn);
// SPACE O(n);      // we are using an extra arrayList in order to store elements internally
import java.util.*;
import java.util.PriorityQueue;

class MinPQComparator implements Comparator<Integer>{

	public int compare(Integer o1, Integer o2) {
		if(o1 < o2)
			return -1;
		else if(o1 > o2)
			return 1;
		return 0;
	}
	
}

class MaxPQComparator implements Comparator<Integer>{
	public int compare(Integer o1, Integer o2) {
		if(o1 > o2)
			return -1;
		else if(o1 < o2)
			return 1;
		return 0;
	}
}

class StringLengthComparator implements Comparator<String>{
	// in this comparator we are comparing on the basis of string length;
	
	@Override
	public int compare(String o1, String o2) {
		if(o1.length() < o2.length())
			return -1;
		else if(o1.length() > o2.length())
			return 1;
		return 0;
	}
	
}

public class PriorityQueueUse {

	public static void main(String[] args) {
		
		String arr[] = {"this", "at", "a", "their", "queues"};
		StringLengthComparator slc = new StringLengthComparator();
		PriorityQueue<String> pq = new PriorityQueue<>(slc);
		
		for(String str: arr)
			pq.add(str);
		while(!pq.isEmpty())
			System.out.print(pq.remove() + " ");
		
			// PQ FOR AN ARRAY
		/*
		MinPQComparator minComparator = new MinPQComparator();
		MaxPQComparator maxComparator = new MaxPQComparator();
		//PriorityQueue<Integer> pq = new PriorityQueue<>(maxComparator);
		                 // OR;
		// ALSO WORKS SAME AS LIKE MAX PQ;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int arr[] = {5,1,9,2,0};
		*/
		
		
		/*
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
		
		*/
		/*
		 * PQ for an array;
		for(int i: arr)
			pq.add(i);
		
		while(!pq.isEmpty())
			System.out.print(pq.remove() + " ");
		System.out.println();
		*/
	}

	 
	
}
