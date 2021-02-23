package binaryTree;

import java.util.*;

public class BinaryTreeUse {

	// TAKE INPUT USING RECURSION
	public static binaryTreeNode<Integer> takeInput(Scanner sc){
		System.out.println("Enter root data");
		int rootData = sc.nextInt();
		
		if(rootData == -1) return null;
		
		binaryTreeNode<Integer> root = new binaryTreeNode<Integer>(rootData);
		root.left = takeInput(sc);
		root.right = takeInput(sc);
		
		return root;
	}
	
	// PRINT DATA USING RECURSION
	public static void printTree(binaryTreeNode<Integer> root) {
		// this is a base case 
		// in case of generic tree it is not a base case, it was edge case;
		if(root == null) return;
		
		String toBePrinted = root.data + "";
		if(root.left != null)
			toBePrinted += "L: " + root.left.data + ", ";
		
		if(root.right != null)
			toBePrinted += "R: " + root.right.data;
		
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}

	
	
	// TAKE INPUT LEVEL WISE;
	public static binaryTreeNode<Integer> takeInputLevelWise(){
		Queue<binaryTreeNode<Integer>> queue = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the data");
		int rootData = sc.nextInt();
		if(rootData == -1) return null;
		
		binaryTreeNode<Integer> root = new binaryTreeNode<>(rootData); 
		queue.add(root);
		
		while(!queue.isEmpty()) {
			binaryTreeNode<Integer> front = queue.remove();
			
			// taking left child input;
			System.out.println("Enter the left child of " + front.data );
			int leftChild = sc.nextInt();
			if(leftChild != -1) {
				binaryTreeNode<Integer> child1 = new binaryTreeNode<Integer>(leftChild);
				front.left = child1;
				queue.add(child1);
			}
			
			// taking right child input;
			System.out.println("Enter the right child of " + front.data);
			int rightChild = sc.nextInt();
			if(rightChild != -1) {
				binaryTreeNode<Integer> child2 = new binaryTreeNode<Integer>(rightChild);
				queue.add(child2);
				front.right = child2;
			}
		}
		
		return root;
	}
	
	// PRINT DATA LEVEL WISE;
	public static void printTreeLevelWise(binaryTreeNode<Integer> root) {
		Queue<binaryTreeNode<Integer>> queue = new ArrayDeque<>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			
			binaryTreeNode<Integer> front = queue.remove();
			String toBePrinted = front.data + ":";
			
			if(front.left != null) {
				toBePrinted += "L" + front.left.data + ", ";
				queue.add(front.left);
			}
			
			if(front.right != null) {
				toBePrinted += "R" + front.right.data;
				queue.add(front.right);
			}
			
			System.out.println(toBePrinted);
		}
		
	}
	
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		binaryTreeNode<Integer> root = takeInput(sc);
		binaryTreeNode<Integer> root = takeInputLevelWise();
		printTreeLevelWise(root);
		//sc.close();

	}

}
