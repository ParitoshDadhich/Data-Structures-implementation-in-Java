public class Solution {
	
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int m, int n) {
		if(m == 0 || head == null) return null;
        
        LinkedListNode<Integer> temp = head;
        
        while(temp != null){
            int count = 0;
            while(temp != null && count+1 != m){
                temp = temp.next;
                count++;
            }
 			
            LinkedListNode<Integer> node = temp;
            count = 0;
            while(node != null && node.next != null && count != n){
                node = node.next;
                count++;
            }
    
            if(temp!=null && node!=null){
            	temp.next = node.next;
            	temp = node.next;
        	}
        }
        return head;
	}
}
