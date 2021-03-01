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
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {
            int[] arr1 = takeInput();
            int[] arr2 = takeInput();
            Solution.intersection(arr1, arr2);
            System.out.println();

            t -= 1;
        }
    }
}





import java.util.*;

public class Solution{
	
	public static void intersection(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: arr1)
           map.put(i, map.getOrDefault(i, 0)+1);
        
        for(int i: arr2){
            if(map.containsKey(i)){
                System.out.print(i + " ");
                map.put(i, map.get(i)-1);
                if(map.get(i) == 0)
                    map.remove(i);
            }
        }
        
    }
}
