import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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




	public static void main(String[] args) throws IOException {
		int k = Integer.parseInt(br.readLine().trim());
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		while(k > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			ArrayList<Integer> current = new ArrayList<Integer>();
            String[] strNums;
            strNums = br.readLine().split("\\s");
            for(int i = 0; i < n; i++) {
				current.add(Integer.parseInt(strNums[i]));
			}
			input.add(current);
			k--;
		}
        ArrayList<Integer> output = Solution.mergeKSortedArrays(input);
        if (output!=null){
            for(int i : output) {
                System.out.print(i + " ");
            }
        }

	}
}



import java.util.*;

public class Solution {

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
		int n = input.size();
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            int l = input.get(i).size();
            for(int j=0; j<l; j++){
                pq.add(input.get(i).get(j));
            }
        }
        
        n = pq.size();
        for(int i=0; i<n; i++)
            list.add(pq.remove());
        
        
        return list;
	}

}
