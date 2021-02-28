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
 
    static class Wrapper{
        int min;
        int max;
        int height;
        boolean isBST;
        
    }
    
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
	 	return helper(root).height;
	}
    
    private static Wrapper helper(BinaryTreeNode<Integer> root){
        
        if(root == null){
            Wrapper output = new Wrapper();
            output.max = Integer.MIN_VALUE;
            output.min = Integer.MAX_VALUE;
            output.height = 0;
            output.isBST = true;
            return output;
        }
        
        
        Wrapper leftOutput = helper(root.left);
        Wrapper rightOutput = helper(root.right);
        
        if(!(leftOutput.max < root.data && leftOutput.isBST))
            leftOutput.isBST = false;
        
        if(!(rightOutput.min > root.data && rightOutput.isBST))
            rightOutput.isBST = false;
        
        Wrapper output = new Wrapper();
        
        
       	if( !leftOutput.isBST || !rightOutput.isBST || (root.data < leftOutput.max) || (root.data > rightOutput.min) ){
            if(leftOutput.height > rightOutput.height){
                leftOutput.isBST = false;
                return leftOutput;
            } else{
                rightOutput.isBST = false;
                return rightOutput;
            }
        }
        
        
        output.min = Math.min( leftOutput.min, Math.min(rightOutput.min, root.data) );
        output.max = Math.max( leftOutput.max, Math.max(rightOutput.max, root.data) );
        output.isBST = true;
        
        //if(output.isBST)
            output.height = 1 + Math.max(leftOutput.height, rightOutput.height);
        //else
           // output.height = Math.max(leftOutput.height, rightOutput.height);
        
        
        return output;
    }

}
