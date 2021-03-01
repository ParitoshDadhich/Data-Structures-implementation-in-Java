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
        System.out.print(Solution.PairSum(arr,arr.length));


    }
}




import java.util.*;

public class Solution {
	public static int PairSum(int[] input, int size) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // inserting elements into map;
        int count = 0;
        for(int i: input)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        for(int i: input){
            
            // when same elements are present
            if(i == 0 && map.get(i) > 0){
                int temp = map.get(i);
                count += temp*(temp-1)/2;
                map.put(i, 0);
            }
            // when elements of different sign are present
            else if(map.containsKey(-i) && map.get(i) > 0){
                count += map.get(i)*map.get(-i);
                map.put(i, 0);
                map.put(-i, 0);
            }
        }
        
        return count;
    } 
}

