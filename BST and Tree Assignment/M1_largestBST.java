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
	
	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		System.out.println(Solution.largestBSTSubtree(root));
	}

}




public class Solution {	
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		return helper(root, Integer.MIN_VALUE);
	}
    
    private static int helper(BinaryTreeNode<Integer> root, int maxHeight){
        if(root == null) return -1;
        
        if(isBST(root)){
            int temp = height(root);
            maxHeight = Math.max(temp, maxHeight);
        }
        
        int leftBstHeight = helper(root.left, maxHeight);
        int rightBstHeight = helper(root.right, maxHeight);
        
        maxHeight = Math.max(maxHeight, Math.max(leftBstHeight, rightBstHeight));
        
        return maxHeight;
        
    }
    
    private static int height(BinaryTreeNode<Integer> root){
        if(root == null) return 0;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static boolean isBST(BinaryTreeNode<Integer> root){
        return helperBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
	private static boolean helperBST(BinaryTreeNode<Integer> root, int min, int max){
        if(root == null) return true;
        
        if(root.data < min || root.data > max)
            return false;
        
        boolean flag1 = helperBST(root.left, min, root.data-1);
        boolean flag2 = helperBST(root.right, root.data, max);
        
        return flag1 && flag2;
    }    

}
