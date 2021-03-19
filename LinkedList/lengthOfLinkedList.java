public class Solution {

	public static void printIthNode(LinkedListNode<Integer> head, int i){
        
        if(head == null) return;
        
		int count = 0;
        LinkedListNode<Integer> temp = head;
        
        while(temp != null){
            count++;
            temp = temp.next;
            if(count == i)
                break;
        }
       
        if(temp != null)
        	System.out.println(temp.data);
        else
            return;
	}
}


