package queueLinkedList;

@SuppressWarnings("serial")
public class QueueEmptyException extends Exception {
	public QueueEmptyException() {
		System.out.println("Queue is Empty");
	}
}
