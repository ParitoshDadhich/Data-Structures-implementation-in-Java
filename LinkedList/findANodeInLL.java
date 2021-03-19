public class Solution {

	public static int findNode(LinkedListNode<Integer> head, int n) {
		int ans = -1;
        int count = 0;
        
        while(head != null){
            if(n == head.data){
             	ans = count;
                break;
            }
            
            count++;
            head = head.next;
        }
        
        return ans;
	}
}

