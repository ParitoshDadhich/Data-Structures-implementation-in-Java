import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class QueueEmptyException extends Exception {
}

class QueueUsingLL<T> {

	class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException {
		if (size == 0) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}

	public void enqueue(T element) {
		Node<T> newNode = new Node<T>(element);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException {
		if (head == null) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if (head == tail) {
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}
	
	private static void print(LinkedListNode<Integer> temp)
	{
		while(temp != null){
			System.out.print(temp.data + " ") ;
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		ArrayList<LinkedListNode<Integer>> output = Solution.constructLinkedListForEachLevel(root);
		if(output!=null)
		{
			for(LinkedListNode<Integer> head : output){
				print(head);
				
			}
		}
	}

}





import java.util.*;

public class Solution {
 
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		if(root == null){
            ArrayList<LinkedListNode<Integer>> ans = new ArrayList<LinkedListNode<Integer>>();
            return ans;
        }
        
        
        ArrayList<LinkedListNode<Integer>> ans = new ArrayList<LinkedListNode<Integer>>();
        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        LinkedListNode<Integer> currentLevelHead = null;
        LinkedListNode<Integer> currentLevelTail = null;
        
        
        queue.enqueue(root);
        queue.enqueue(null);
        
        
        while(!queue.isEmpty()){
            
            BinaryTreeNode<Integer> frontNode;
            try{
                
                
            if(queue.front() != null){
                frontNode = queue.dequeue();
                LinkedListNode<Integer> newNode = new LinkedListNode<>(frontNode.data);
                
                if(currentLevelHead == null){
                    currentLevelHead = newNode;
                    currentLevelTail = newNode;
                } else{
                    currentLevelTail.next = newNode;
                    currentLevelTail = newNode;
                }
                
                if(frontNode.left != null)
                    queue.enqueue(frontNode.left);
                if(frontNode.right != null)
                    queue.enqueue(frontNode.right);
                
            } else{
                
                ans.add(currentLevelHead);
                currentLevelHead = null;
                currentLevelTail = null;
                queue.dequeue();
                
                if(queue.isEmpty())
                    break;
                else
                    queue.enqueue(null);
                
            }
                
            } catch(QueueEmptyException e){};
        }
        return ans;
	}

}

