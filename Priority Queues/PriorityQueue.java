package priorityQueue;

import java.util.*;

public class PriorityQueue {
	private ArrayList<Integer> heap;
	
	public PriorityQueue() {
		heap = new ArrayList<>();
	}
	
	boolean isEmpty() {
		return heap.size() == 0;
	}
	
	int size() {
		return heap.size();
	}
	
	int getMin() {
		return heap.get(0);
	}
	
	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;
		
		// Comparison will be taken place until child data will become less than parent data;
		// the last comparison will be taken place at root;
		while(childIndex > 0) {
			if(heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			} else {
				return;
			}
		}
	}
	
	int removeMin() {
		 
		// element which is being removed
		int temp = heap.get(0);
		// last value of the heap is set to 0th index;
		heap.set(0, heap.get(heap.size()-1));
		// remove a value which is present at index heap.size()-1;
		heap.remove(heap.size()-1);
		
		
		// how we have to perform heapify operation
		// in order to satisfy heap order property;
		
		// we are doing downward heapify
		// initially initialise minIndex with 0, leftChildIndex with 1, rightChildIndex with 2
		
		int index = 0;    // here index indicates the value of an element or node which is being compaired;
		int minIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		
		// we are checking with leftIndex only, agar left hi nahi hoga to right kaise hoga;
		while(leftChildIndex < heap.size()) {
			// now we will be comparing value present at minIndex with its left and right child respectively;
			if(heap.get(leftChildIndex) < heap.get(minIndex))
				minIndex = leftChildIndex;
			
			// first we need to check whether right child exits or not;
			if(rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex))
				minIndex = rightChildIndex;
			
			if(minIndex == index)
				break;
			else {
				// once we get the minIndex then swap it with the value which is present at index;
				int temp1 = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp1);
				
				index = minIndex;
				leftChildIndex = 2 * index + 1;
				rightChildIndex = 2 * index + 2;
			}
		}
		
		return temp;
	}
	
}



 