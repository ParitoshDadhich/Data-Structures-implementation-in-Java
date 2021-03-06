import java.util.ArrayList;

public class PQ {

	private ArrayList<Integer> heap;

	public PQ() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
    	
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1)/2;
        
        while(childIndex > 0){
            if(heap.get(childIndex) < heap.get(parentIndex)){
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                
                childIndex = parentIndex;
                parentIndex = (childIndex - 1)/2;
            } else
                return;
        }
	}

	int removeMin() throws PriorityQueueException{
		if(heap.isEmpty())
            throw new PriorityQueueException();
        
        int ans = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        
        int index = 0;
        int minIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        
        while(leftChildIndex < heap.size() && rightChildIndex < heap.size()){
            if(heap.get(leftChildIndex) < heap.get(minIndex))
                minIndex = leftChildIndex;
            
            if(heap.get(rightChildIndex) < heap.get(minIndex))
                minIndex = rightChildIndex;
            
            if(minIndex == index)
                break;
            else{
                // once I get the minIndex then I would swap the value at minIndex with the value at value at index;
                int temp = heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp);

                index = minIndex;
                leftChildIndex = 2*minIndex + 1;
                rightChildIndex = 2*minIndex + 2;
            }
            
        }
        
        return ans;
	}
}

class PriorityQueueException extends Exception {

}
