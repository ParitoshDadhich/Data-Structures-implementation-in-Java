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

    public static void printArray(ArrayList<Integer> arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        ArrayList<Integer> ans = Solution.longestConsecutiveIncreasingSequence(arr);
        printArray(ans);

    }
}




// BEST QUESTION;


import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
	 	HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        
        for(int i: arr)
            map.put(i, true);
        
        int startValue = -1;
        int maxLength = 0;
        int l = arr.length;
        int startIndex = 0;
        for(int i=0; i<l; i++){
                
            // forward;
            int startIndexValue = i;
            int ele = arr[i];
            int length1 = 0;
            int tempIndex = i;
            while(map.containsKey(ele) && map.get(ele)){
                length1++;
                map.put(ele, false);
                ele++;
                tempIndex++;
            }
            
            //backword
            ele = arr[i] - 1;
            int length2 = 0;
            tempIndex = i;;
            while(map.containsKey(ele) && map.get(ele)){
                length2++;
                map.put(ele, false);
                //System.out.println(ele);
                startIndexValue = arr[tempIndex];
                ele--;
                tempIndex++;
            }
            ele++;
            //startIndexValue = arr[ele];
            //System.out.println(startIndexValue);
            
            if(maxLength < (length1 + length2)){
                maxLength = length1 + length2;
                startValue = ele;
                startIndex = startIndexValue;
            }
            
            else if(maxLength == (length1 + length2)){
                
                if(startIndexValue < startIndex){
                    startValue = ele;
                    startIndex = startIndexValue;
                }
            }
            
        }
        
        output.add(startValue);
        output.add(startValue + maxLength - 1);
        return output;
        
    }
}


