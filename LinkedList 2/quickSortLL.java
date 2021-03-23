
 public class Solution {



	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head )
	{
        // base condition
        if(head == null || head.next == null)
            return head;
       
        // calculating length of ll
    	int len = length(head);
       
        for(int i=0;i<len;i++){
        
            // creating q, p, and r variables and initializing them
			LinkedListNode<Integer> q=head.next, p=head, r=null;
        
            
            // applying the required condioiton and performing opernations
     	    while(p!=null){
            
     	       if(r == null && (p != null && q != null) && (p.data >  q.data)){
     	            p.next = q.next;
        	        q.next = p;
            	    head = q;
                
          	        r = q;
                    q = p.next;
         	   }
            	else if((p != null && q != null) && p.data > q.data){
                	p.next = q.next;
     	            r.next = q;
        	        q.next = p;
                
             	    r = q;
     	            q = p.next;
         	   }
            	else{
     	            r = p;
        	        p = q;
             	    if(q != null)
            		q = q.next;
     	       }
            
    	    }
        }
        
        	return head;
	}
    
     // function to calculate length of ll
    static int length(LinkedListNode<Integer> head){
        int count=0;
        while(head!=null)
        {
            count++;
            head=head.next;
        }
        return count;
    }

}
