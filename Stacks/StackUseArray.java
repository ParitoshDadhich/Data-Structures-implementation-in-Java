package stack;

public class StackUseArray {
	
	private int data[];
	private int top; // it is the index of topmost element of stack
	
	public StackUseArray() {
		data = new int[10];
		top = -1;
	}
	
	public StackUseArray(int capacity) {
		data = new int[capacity];
		top = -1;
	}
	
	public int size(){
		return top+1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int ele) throws StackOverFlowException {
		// here we throw an exception when stack becomes full;
//		if(size() == data.length) {
//			StackOverFlowException e = new StackOverFlowException();
//			throw e;
//		}
		
		// here we double the size of the stack;
		if(size() == data.length) {
			doubleSize();
		}
		
		top++;
		data[top] = ele;
	}
	
	private void doubleSize() {
		int temp[] = data;
		data = new int[2 * temp.length];
		for(int i=0; i <= top; i++) {
			data[i] = temp[i];
		}
		
	}

	public int pop() throws StackEmptyException {
		if(size() == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
	return data[top--];
	}
	
	public int top() throws StackEmptyException {
		if(top == -1) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return data[top];
	}
	
}
