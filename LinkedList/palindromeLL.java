// BEST QUESTION

// method 1 
// we used 2 loops and it takes 
// time: o(n2) & space: o(1);

/*
public class Solution {
	
    
	public static boolean isPalindrome(LinkedListNode<Integer> head) {
        
        if(head == null || head.next == null)
            return true;
        
        
        LinkedListNode<Integer> temp1=head, temp2=head.next;
        
        boolean flag=true;
    	int len = length(head);
      	int i=0;
        while(i<len/2){
            int j=i+1;
            while(j<len-i-1 && temp2.next != null){
                temp2=temp2.next;
                j++;
            }
            if(temp1.data!=temp2.data){
                flag=false;
                break;
            }
            temp1=temp1.next;
            temp2=temp1.next;
            i++;
        }
        
        return flag;
        
	}
    
    static int length(LinkedListNode<Integer> head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }

}
*/


// method 2 
// time o(n)
// space o(n);
// here we creates an another 

/*
public class Solution{
    public static boolean isPalindrome(LinkedListNode<Integer> head){
        
        if(head==null || head.next==null)
            return true;
        
        boolean flag=true;
        // BY THIS LINE OF CODE WE ARE MAKING EXACT ANOTHER COPY OF ANOTHER LINKED LIST  
        LinkedListNode<Integer> head2 = takeInput(head);
        
        // HERE I WILL GET THE REVERSE LINKED LIST
        head2=reverse(head2);
        
        while(head2!=null){
            
   	     if(!head2.data.equals(head.data)){
   	     	flag=false; break; }
            
   	     head2=head2.next;
         head=head.next;
      }        
    
    return flag;   
    }
    
    
    private static LinkedListNode<Integer> takeInput(LinkedListNode<Integer> head){
    	LinkedListNode<Integer> head1 = new LinkedListNode<Integer>(head.data);
        LinkedListNode<Integer> temp=head1;
        head=head.next;
        
        while(head != null){
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(head.data);
            temp.next=newNode;
            temp=newNode;
            
            head=head.next;
         }    
    return head1;
    }
    
    
    private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
        LinkedListNode<Integer> p=head, q=null, r=null;
        while(p!=null){
            r=q;
            q=p;
            p=p.next;
            q.next=r;
        }
        
        head=q;
        
        return head;
    }
    
}
*/

//method 3
// time o(n);
// space o(1);
// here we divide the linked list into two half and reverse the one half and then compare;


public class Solution{
    public static boolean isPalindrome(LinkedListNode<Integer> head1){
        if(head1==null || head1.next==null)
            return true;
        
        boolean flag=true;
        LinkedListNode<Integer> head2=null, temp1=head1, temp2=null;
        int len=length(head1);
       
        // traversing till first half of the linked list
        int i=1;
        while(i<len/2){
            temp1=temp1.next;
            i++;
        }
        head2=temp1.next;     // making two half of the linked list
        temp1.next=null;
        
        head2=reverse(head2);   // reversing the second half 
        
        temp1=head1;
        temp2=head2;
        
        
        // comparing both the half;
        while(temp2!=null && temp1!=null){
            if(!temp2.data.equals(temp1.data)){
              //  System.out.println(temp1.data + " " + temp2.data + "\n");
                flag=false;
                break;
            }
          //  System.out.println(temp1.data + " " + temp2.data);
            temp1=temp1.next;
            temp2=temp2.next;
        }
         
    return flag;
        
    }
    
    
    
    private static int length(LinkedListNode<Integer> head)
    {
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    
    
    
    private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
        LinkedListNode<Integer> r=null, q=null, p=head;
        while(p!=null){
            r=q;
            q=p;
            p=p.next;
            q.next=r;
        }
        head=q;
    
        return head;
    }
}



 

 













 



 



