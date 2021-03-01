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
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		System.out.println(Solution.getPairsWithDifferenceK(arr, k));
	}

}



import java.util.*;

public class Solution {

	public static int getPairsWithDifferenceK(int arr[], int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: arr)
            map.put(i, map.getOrDefault(i, 0)+1);
        
        
        int count = 0;
        int l = arr.length;
        for(int i: arr){
            
            int ele1 = i+k;
            int ele2 = i-k;
            
            if(k == 0){
                if(map.containsKey(i) && map.get(i) > 1){
                    int n = map.get(i);
                    count += n*(n-1)/2;
                    map.put(i, 0);
                }
            }  
            else{
                
                if(map.containsKey(ele1)){
                    int n1 = map.get(ele1);
                    int n2 = map.get(i);
                    count += n1*n2;
                } else if(map.containsKey(ele2)){
                    int n1 = map.get(ele2);
                    int n2 = map.get(i);
                    count += n1*n2;
                }
                map.put(i, 0);
            }
            
        }
        
        return count;
	}
}

