import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        System.out.println(Solution.isBalanced(expression));
    }
}



import java.util.*;

public class Solution {

    public static boolean isBalanced(String exp) {
        Stack<Character> s = new Stack<>();
        
        int l = exp.length();
        for(int i=0; i<l; i++){
            char ch = exp.charAt(i);
            if(ch =='(' || ch =='{' || ch =='[')
                s.push(ch);
            else if(ch == ')' || ch == '}' || ch == ']'){
                if(s.size() == 0)
                    return false;
                
                char exper = s.pop();
                if(exper == '{' && ch == '}')
                    continue;
                else if(exper == '(' && ch == ')')
                    continue;
                else if(exper == '[' && ch == ']')
                    continue;
                else
                    return false;
            }
        }
        
        return s.size()==0 ? true : false;
    }
}
