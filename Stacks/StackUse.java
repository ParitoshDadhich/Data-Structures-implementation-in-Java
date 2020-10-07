package stack;

public class StackUse {

	public static void main(String[] args) throws StackOverFlowException, StackEmptyException {
		StackUseArray s = new StackUseArray(3);
		for(int i=1;i<=10;i++)
			s.push(i);
		
		while(!s.isEmpty()) {
			try {
				System.out.println(s.pop());
			} catch(StackEmptyException e) {
				// never reach here
				e.printStackTrace();
			}
		}
		
	}
}
