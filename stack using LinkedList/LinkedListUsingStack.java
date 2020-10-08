package stackUsingLL;

public class LinkedListUsingStack<T> {
	private Node<T> head;
	private int size = 0;
	
	
	public LinkedListUsingStack() {
		head = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void push(T data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public T top() throws StackEmptyException {
		if(size() == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		return head.data;
	}

	public T pop() throws StackEmptyException {
		if(size() == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		size--;
		T temp =  head.data;
		head = head.next;
		return temp;
	}

	public boolean isEmpty() {
		return head == null;
	}

	
	
}
