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
        System.out.println(Solution.maxFrequencyNumber(arr));


    }
}




import java.util.*;


public class Solution {

    public static int maxFrequencyNumber(int[] arr){ 
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
        
        for(int i: arr){
            // if(hp.containsKey(i))
            // 	hp.put(i, hp.get(i)+1);
            // else
            //     hp.put(i, 1);
            hp.put(i, hp.getOrDefault(i, 0) +1);
        }
        
        Set<Integer> keys = hp.keySet();
        int maxFreq = 0;
        
        int key = Integer.MIN_VALUE;
        for(int i: arr){
            int temp = hp.get(i);
            if(temp > maxFreq){
                maxFreq = temp;
                key = i;
            }
        }
        
        return key;
    }
}
