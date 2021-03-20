public class Solution {

	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		if(head == null || head.next == null) return head;
        
        else{
            LinkedListNode<Integer> head2 = midPoint(head);
            LinkedListNode<Integer> temp = head2, head1 = head;
            head2 = head2.next;
            temp.next = null;
            
            head1 = mergeSort(head1);
            head2 = mergeSort(head2);
            
            head = merge(head1, head2);
            
            return head;
        }
    }
        
     static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
        
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        LinkedListNode<Integer> head = null, tail = null;
        
        if(head1 != null && head2 != null && head1.data < head2.data){
            head = head1;
            tail = head1;
            head1 = head.next;
        } else{
            head = head2;
            tail = head2;
            head2 = head2.next;
        }
        
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else{
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        
        if(head1 != null)
            tail.next = head1;
        if(head2 != null)
            tail.next = head2;
        
        return head;
    }
    
    private static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head){
        if(head == null || head.next == null) return head;
        
        LinkedListNode<Integer> slow = head, fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

}
