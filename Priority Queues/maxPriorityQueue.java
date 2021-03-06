import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		PQ pq = new PQ();
		int choice = Integer.parseInt(st.nextToken());
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = Integer.parseInt(st.nextToken());
					pq.insert(element);
					break;
				case 2 : // getMax
					System.out.println(pq.getMax());
					break;
				case 3 : // removeMax
					System.out.println(pq.removeMax());
					break;
				case 4 : // size
					System.out.println(pq.getSize());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice = Integer.parseInt(st.nextToken());
		}
	}

}


////////////////////////////////////  PQ class  ///////////////////

import java.util.*;


public class PQ {
	// Complete this class
    
    private ArrayList<Integer> heap;
    
    PQ(){
        heap = new ArrayList<>();
    }
    
	boolean isEmpty() {
		return heap.size() == 0;
	}

	int getSize() {
		return heap.size();
	}

	int getMax() {
		if(heap.isEmpty())
            return Integer.MIN_VALUE;
        return heap.get(0);
	}

    // upward heapify;
	void insert(int element) {
		heap.add(element);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex - 1)/2;
        
        while(childIndex > 0){
            if(heap.get(childIndex) > heap.get(parentIndex)){
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                
                childIndex = parentIndex;
                parentIndex = (childIndex - 1)/2;
            } else
                return;
        }
	}

    
    // downward heapify;
	int removeMax() {
		if(heap.isEmpty())
            return Integer.MIN_VALUE;
        
        int ans = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        
        int index = 0;
        int maxIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        
        
        while(leftChildIndex < heap.size() && rightChildIndex < heap.size()){
            if(heap.get(maxIndex) < heap.get(leftChildIndex))
                maxIndex = leftChildIndex;
            if(heap.get(maxIndex) < heap.get(rightChildIndex))
                maxIndex = rightChildIndex;
            
            if(maxIndex == index)
                break;
            else{
                // once I get maxIndex then swap
                int temp = heap.get(index);
                heap.set(index, heap.get(maxIndex));
                heap.set(maxIndex, temp);

                index = maxIndex;
                leftChildIndex = 2*index + 1;
                rightChildIndex = 2*index + 2;
            }
        }
        
        return ans;
	}
}
