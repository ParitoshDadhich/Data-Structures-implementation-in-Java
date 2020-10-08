package queueArray;

public class QueueUse {

	public static void main(String[] args) throws QueueEmptyException {
		 QueueUsingArray queue = new QueueUsingArray(20);
		 for(int i=1; i<=20; i++)
			 queue.enqueue(i);
		 
		 for(int i=1; i<=20; i++)
			try {
				System.out.print(queue.dequeue() + " ");
			} catch (QueueEmptyException e) {
				e.printStackTrace();
			}

	}

}
