import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Runner {

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
		System.out.println(Solution.buyTicket(input, k));
	}
}


import java.util.*;

public class Solution {
	
	public static int buyTicket(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i: arr){
            queue.add(i);
            pq.add(i);
        }
        
        int time = 0;
        while(!pq.isEmpty()){
            if(queue.peek().equals(pq.peek())){       
                if(k==0)
                    return time+1;
                else{
                    pq.poll();
                    queue.poll();
                    time++;
                    k--;
                }     
            } else{
                queue.add(queue.peek());
                queue.poll();
                
                if(k == 0)
                    k = queue.size()-1;
                else
                    k--;
            }
        }
        return time;
	}
}

