import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class QueueEmptyException extends Exception {

}

 class QueueUsingLL<T> {

	class Node<T> {
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}


	public void enqueue(T element){
		Node<T> newNode = new Node<T>(element);

		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if(head == tail){
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
		this.left = null;
		this.right = null;
	}
}

public class Runner {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}

		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		String[] target_k = br.readLine().trim().split(" ");

		int target = Integer.parseInt(target_k[0].trim());
		int k = Integer.parseInt(target_k[1].trim());

		Solution.nodesAtDistanceK(root, target, k);
	}
}



public class Solution {

    private static void printNodesAtDeptK(BinaryTreeNode<Integer> root, int k){
        if(root == null)
            return;
        
        if(k == 0)
            System.out.println(root.data);
        
        printNodesAtDeptK(root.left, k-1);
        printNodesAtDeptK(root.right, k-1);
    }
    
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
	    printElementAtDistanceK(root, node, k);
	}
    
    private static int printElementAtDistanceK(BinaryTreeNode<Integer> root, int targetNode, int k){
        if(root == null || k < 0)
            return -1;
        
        if(root.data == targetNode){
            printNodesAtDeptK(root, k);
            return 0;
        }
        
        int leftDistance = printElementAtDistanceK(root.left, targetNode, k);
        if(leftDistance != -1){
            if(leftDistance+1 == k)
                System.out.println(root.data);
            else
                printNodesAtDeptK(root.right, k-2-leftDistance);
            
            return leftDistance+1;
        }
        
        int rightDistance = printElementAtDistanceK(root.right, targetNode, k);
        if(rightDistance != -1){
            if(rightDistance+1 == k)
                System.out.println(root.data);
            else
                printNodesAtDeptK(root.left, k-2-rightDistance);
            
            return rightDistance+1;
        }
        
        return -1;
    }

}
