public class Solution {

	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		if(head == null || head.next == null) return head;
        
        LinkedListNode<Integer> temp1 = head, temp2 = head.next;
        
        while(temp2 != null){
            if(temp1.data.equals(temp2.data)){
                temp1.next = temp2.next;
                temp2 = temp2.next;
            } else{
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        
        return head;
	}

}
