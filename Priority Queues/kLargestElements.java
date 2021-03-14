import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = Solution.kLargest(input, k);
		for(int i : output) {
			System.out.println(i);
		}
		
	}
}




import java.util.*;

public class Solution {

	public static ArrayList<Integer> kLargest(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        int l = arr.length;
        for(; i<k; i++)
            pq.add(arr[i]);
        
        for(; i<l; i++){
        	int temp = pq.peek();
            if(arr[i] > temp){
                pq.remove();
            	pq.add(arr[i]);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty())
            list.add(pq.remove());
        
        return list;
		
	}
}
