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
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		System.out.println(Solution.kthLargest(n, input, k));
	}
}


import java.util.*;

public class Solution {

	public static int kthLargest(int n, int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i=0;
        for(; i<k; i++)
            pq.add(arr[i]);
        
        for(; i<n; i++){
            int ele = pq.peek();
            if(arr[i] > ele){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        
        return pq.peek();
	}
}
