public class Solution {


	public static int findNodeRec(LinkedListNode<Integer> head, int n) {
    	return helper(head, n, 0);
	}
    
    private static int helper(LinkedListNode<Integer> head, int n, int sI){
        if(head == null) return -1;
        
        if(head.data == n)
            return sI;
        
        int ans = helper(head.next, n, sI+1);
        
        return ans;
    }

}
