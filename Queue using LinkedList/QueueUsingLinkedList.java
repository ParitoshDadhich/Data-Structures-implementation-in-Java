package queueLinkedList;

public class QueueUsingLinkedList<T> {
	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	public QueueUsingLinkedList() {
		front = null;
		rear = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public T front() throws QueueEmptyException {
		if(size == 0)
			throw new QueueEmptyException();
		return front.data;
	}
	
	public T peek() {
		return rear.data;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(T element) {
		Node<T> newNode = new Node<T>(element);
		
		if(size == 0) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}
	
	public T dequeue() throws QueueEmptyException {
		if(size == 0) 
			throw new QueueEmptyException();
		
		T temp = front.data;
		front = front.next;
		size--;
		return temp;
	}	
}
