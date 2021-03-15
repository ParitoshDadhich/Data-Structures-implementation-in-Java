import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Solution.checkMaxHeap(input));
	}
}



import java.util.*;

public class Solution {

	public static boolean checkMaxHeap(int arr[]) {
		int l = arr.length;
        
        int n = (int)Math.log(l);
        for(int i=0; (2*i+1)<l; i++){
            int leftChild = 2*i+1;
            int rightChild = 2*i+2;
            
            if((arr[i] < arr[leftChild]) || (rightChild<l && arr[i] < arr[rightChild]))
                return false;
        }
        
        return true;
	}
}
