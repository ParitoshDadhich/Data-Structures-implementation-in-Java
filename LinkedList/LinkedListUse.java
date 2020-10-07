package linkedList;

public class LinkedListUse extends LinkedListUsing{

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		print(head);
		
		head = insert(head, 454, 0);
		print(head);
		head = insert(head, 44, 1);
		print(head);
		head = insert(head, 765, 6);
		print(head);

		head = delete(head, 1);
		print(head);
		
		head = delete(head, 3);
		print(head);
		
		head = delete(head, 4);
		print(head);
		
		head = delete(head, 4);
		print(head);
		
		head = reverseI(head);
		print(head);
		
		head = revereseR(head);
		print(head);
	}
	

}
