public class Solution {

	public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
		if(head == null) return head;
        
        LinkedListNode<Integer> temp = head;
        
        if(pos == 0)
            return head.next;
        
        int count = 0;
        while(temp != null){
            if(count + 1 == pos)
                break;
            
            count++;
            temp = temp.next;
        }
        
        
        if(temp != null && temp.next != null)
            temp.next = temp.next.next;
        
        return head;
	}
}
