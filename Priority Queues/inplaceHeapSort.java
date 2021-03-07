import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Solution.inplaceHeapSort(input);
		for (int i : input) {
			System.out.print(i + " ");
		}
	}

}



///////////////////////////////  Solution Class //////////////////////////////////


public class Solution {

	public static void inplaceHeapSort(int arr[]) {
	 	int l = arr.length;
        
        // making a heap array;
        for(int i=0; i<l; i++)
            convertArrToHeap(arr, i);
        
        // heap to an array in sorted array in decending order;
        
        for(int i=0; i<l; i++)
            arr[l-i-1] = removeMin(arr, l-i-1);
        
	}
    
    
    private static int removeMin(int arr[], int heapSize){
        int ans = arr[0];
        arr[0] = arr[heapSize];
        int index = 0;
        int minIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        
        // we are comparing with leftChildIndex because if leftChild exists then only rightChild can exist;
        while(leftChildIndex < heapSize){
            if(arr[minIndex] > arr[leftChildIndex])
                minIndex = leftChildIndex;
            
            // first checking whether rightChild exists or not;
            if(rightChildIndex < heapSize && arr[minIndex] > arr[rightChildIndex])
                minIndex = rightChildIndex;
            
           
           if(index == minIndex)
               break;  
            else{
                int temp = arr[minIndex];
                arr[minIndex] = arr[index];
                arr[index] = temp;

                index = minIndex;
                leftChildIndex = 2*index+1;
                rightChildIndex = 2*index+2;
            }
        }
        
        return ans;
    }
    
    private static void convertArrToHeap(int arr[], int childIndex){
        int parentIndex = (childIndex - 1)/2;
        
        // comparing and  swaping value at parentIndex with childIndex;
        while(childIndex > 0){
            if(arr[childIndex] < arr[parentIndex]){
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                
                childIndex = parentIndex;
                parentIndex = (childIndex - 1)/2;
            }else
                return; 
        }
    }
}
