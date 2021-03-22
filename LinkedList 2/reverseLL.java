 
public class Solution {

	public static LinkedListNode<Integer> reverse_I(LinkedListNode<Integer> head){
        if(head == null || head.next == null) return head;
        
        LinkedListNode<Integer> r=null,q=null,p=head;
        
        while(p!=null){
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        
        return q;
	}
}
