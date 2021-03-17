import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
		String[] strNums;
		strNums = br.readLine().split("\\s");
		
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        Solution.findMedian(arr);


    }
}




import java.util.*;

public class Solution {
	public static void findMedian(int arr[])  {
        
        if(arr.length == 0)
        	return;
            
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        System.out.print(arr[0] + " ");
        maxPq.add(arr[0]);
        
        int l = arr.length;
        for(int i=1; i<l; i++){
            
            // adding elements into the max and min priority queue;
            if(!maxPq.isEmpty() && arr[i] > maxPq.peek())
                minPq.add(arr[i]);
            else
                maxPq.add(arr[i]);
            
            // calculating the size of both queues;
            int maxSize = maxPq.size();
            int minSize = minPq.size();
            
            // absoulte difference between size of both the heaps should be atmost 1;
            if(maxSize>minSize && (maxSize-minSize)>1){
                int ele = maxPq.remove();
                minPq.add(ele);
            } else if(maxSize<minSize && (minSize-maxSize)>1){
                int ele = minPq.remove();
                maxPq.add(ele);
            }
            
            
            // calculating and printing median;
            if(maxPq.size() != 0 || minPq.size() !=0){
                if(i%2 != 0){
                    int ans = (maxPq.peek() + minPq.peek())/2;
                    System.out.print(ans + " ");
                } else{
                    int ans = maxSize>minSize?maxPq.peek():minPq.peek();
                    System.out.print(ans + " ");
                }
            }
            
        }
    }
}
