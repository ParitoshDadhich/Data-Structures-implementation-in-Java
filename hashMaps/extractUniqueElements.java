import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String takeInput() throws IOException {
        String str = br.readLine(); 
        return str;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String str = takeInput();
        System.out.print(Solution.uniqueChar(str));


    }
}


import java.util.HashMap;

public class Solution {

	public static String uniqueChar(String str){
		HashMap<Character, Integer> map = new HashMap<>();
        
        String ans = "";
        int l = str.length();
        for(int i=0; i<l; i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch))
                continue;
            else{
                map.put(ch,1);
                ans += ch;
            }
        }
        
        return ans;
	}
}
