package linkedList;

import java.util.Scanner;

public class LinkedListUsing {
	
	public static Node<Integer> takeInput(){
		Node<Integer> head = null, tail = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the elements ");
		int data = sc.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
//				
//				Node<Integer> tail = new Node<Integer>(data);
//				tail = head;
//				while(tail != null)
//					tail = tail.next;
//				tail.next = newNode;
				
			}
			data = sc.nextInt();
		}
		return head;
	}
	
	public static Node<Integer> insert(Node<Integer> head, int data, int pos) {
		Node<Integer> temp = head;
		Node<Integer> newNode = new Node<Integer>(data);
		
		if(pos == 0) {
			newNode.next = head;
			head = newNode;
			return head;
		} 
		else {
			for(int i=1; i<=pos-1;i++)   
				temp = temp.next;
			if(temp != null)
			newNode.next = temp.next;
			temp.next = newNode;
		}
		return head;
	}
	
	public static Node<Integer> delete(Node<Integer> head, int pos) {
		Node<Integer> temp = head;
		if(pos == 1) {
			head = head.next;
			return head;
		} else {
			for(int i=1; i<pos-1; i++) {
				temp = temp.next;
			}
			if(temp.next != null)
				temp.next = temp.next.next;
		}
		
		return head;
		
	}
	
	
	public static Node<Integer> reverseI(Node<Integer> head) {
		Node<Integer> p = head, q = null, r = null;
		while(p!= null) {
			r = q;
			q = p;
			p = p.next;
			// now I am chaning the link
			q.next = r;
		}
		head = q;
		return head;
	}
	
	public static Node<Integer> revereseR(Node<Integer> head){
		if(head == null || head.next == null) return head;
		
		// suppose we have list 1 2 3 4 and if I reverse 2 3 4 then 
		// I will get 4 3 2
		// notice now 2 has become tail pointer and 
		// initially it was head.next;
		Node<Integer> tail = head.next;
		// i am passing 2 3 4 in the form of head.next;
		Node<Integer> ans = revereseR(head.next);
		
		// we want 4 3 2 1 and we get 4 3 2 with the help of recursion
		// now to link to 1 we need tail pointer
		// so we will point tail.next to head i.e. 1
		// and later head.next to null we are doing this because
		// the list on which head is point is 1 2 3 4 and 
		// if we don't make head.next to null then we will not get any 
		// result it will end up into infinite series
		
		tail.next = head;
		head.next = null;
 		return ans; 
	}
	
	public static void print(Node<Integer> head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
}


