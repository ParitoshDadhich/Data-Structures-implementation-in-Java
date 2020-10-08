package stackUsingLL;

public class LinkedListUse {

	public static void main(String[] args) {
		LinkedListUsingStack<Integer> s = new LinkedListUsingStack<>();
		
		for(int i=0;i<=5;i++) {
			s.push(i);
		}
		
		//s = s.deleteAlternative();
		
		while(!s.isEmpty())
			try {
				System.out.print(s.pop() +" ");
			} catch (StackEmptyException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

}
