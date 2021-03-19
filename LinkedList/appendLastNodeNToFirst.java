public class Solution {

	public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
        if(head == null || n == 0) return head;
        
		int len = length(head);
        
        LinkedListNode<Integer> head1 = null, temp = head;
        int k = len - n;
        
        for(int i=1; i<k; i++)
            temp = temp.next;
        
        if(temp != null){
        	head1 = temp.next;
            temp.next = null;
    	}
        
        temp = head1;
        while(temp != null && temp.next != null)
            temp = temp.next;
        
        if(temp != null)
        	temp.next = head;
        
        return head1;
        
        
	}
    
    private static int length(LinkedListNode<Integer> head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        
        return len;
    }

}
