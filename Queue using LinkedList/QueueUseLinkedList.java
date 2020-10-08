package queueLinkedList;

public class QueueUseLinkedList {

	public static void main(String[] args) throws QueueEmptyException {
		QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
		
		for(int i=0;i<=5;i++)
			queue.enqueue(i);
		 for(int i=0;i<=7;i++)
			System.out.println( queue.size() + " "+queue.dequeue());
	}

}
