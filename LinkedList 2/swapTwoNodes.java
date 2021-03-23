public class Solution {

	public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
        
		if(head == null) return null;
        int len = length(head);
        if(i>=len || j>=len) return null;
        
        // case 1 i==0 || j==0 && Mod(i-j)=1;
        if((i==0 || j==0) && Math.abs(i-j)==1){
            LinkedListNode<Integer> c1 = head, c2 = head.next;
            
            c1.next = c2.next;
            c2.next = c1;
        }
        
        // case 2 i==0 || j==0
        else if(i==0 || j==0){
            int max = i>j?i:j;
            LinkedListNode<Integer> c1 = head, c2 = null, temp=null;;
            int count = 0;
            while(c2!=null && count<max){
                c2 = c2.next;
                count++;
            }
            if(c2 != null)
                temp = c2.next;
            
            c2.next = c1.next;
            c1.next = temp;
        }
        
        
        // case 3 Mod(i-j)=1;
        else if(Math.abs(i-j)==1){
            int max = i>j?i:j;
            LinkedListNode<Integer> c1=null, c2=head,prev1=null;
            int count=0;
            while(c2!=null && count<max){
                prev1 = c1;
                c1 = c2;
                c2 = c2.next;
                count++;
            }
            
            prev1.next = c2;
            c1.next = c2.next;
            c2.next = c1;
            
        }
        
        else{
            int count=0;
            LinkedListNode<Integer> p1=null,c1=head,temp=null;
            while(c1!=null && count<i){
                p1 = c1;
                c1 = c1.next;
                count++;
            }
            temp = c1.next;
            
            LinkedListNode<Integer> p2=null, c2=head;
            count=0;
            while(c2!=null && count<j){
                p2 = c2;
                c2 = c2.next;
                count++;
            }
            
            p1.next = c2;
            p2.next = c1;
            c1.next = c2.next;
            c2.next = temp;
        }
        
        return head;
	}

    
    private static int length(LinkedListNode<Integer> head){
        while(head == null) return 0;
        
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}
