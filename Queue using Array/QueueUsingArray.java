package queueArray;

public class QueueUsingArray {
	private int data[];
	private int front;
	private int rear;
	private int size;
	
	QueueUsingArray(){
		front = -1;
		rear = -1;
		data = new int[10];
		size = 0;
	}
	
	QueueUsingArray(int capacity) {
		front = -1;
		rear = -1;
		data = new int[capacity];
		size = 0;
	}
	
	public int size() {
		return size;
	}

	public int front() throws QueueEmptyException {
		if(size == 0)
			throw new QueueEmptyException();
		
		return data[front];
	}
	
	public int rear() throws QueueEmptyException {
		if(size == 0)
			throw new QueueEmptyException();
		
		return data[rear];
	}

	public void enqueue(int element) throws QueueEmptyException {
		if(size == 0)
			front = 0;
	
		if(data.length == 0)
			throw new QueueEmptyException();
		
		rear = (rear+1)%data.length;
//		or
//		rear++;
//		if(rear == data.length)
//			rear = 0;
		size++;
		data[rear] = element;
	}
	
	public int dequeue() throws QueueEmptyException {
		if(size == 0)
			throw new QueueEmptyException();
		
		int temp = data[front];
		
		if(size == 0)
			throw new QueueEmptyException();
		
		front = (front +1)%data.length;
//		or
//		front++;
//		if(front == data.length)
//			front = 0;
		size--;
		if(size == 0) {
			front = -1;
			rear = -1;
		}
		return temp;
	}
	
	
	
}
