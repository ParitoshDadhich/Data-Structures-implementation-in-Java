package Tree;

import queueLinkedList.*;
import java.util.Scanner;

public class TreeUse {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		//treeNode<Integer> root = takeInput(s);
		treeNode<Integer> root = takeInputLevelWise();
		print(root);
		
		System.out.println("Number of nodes in Tree are: " + numNodes(root));
		System.out.println("Largest value of the node in Tree is "+ largest(root));
		printAtK(root, 2);
		System.out.println();
		preorder(root);
		
	}

	private static int largest(treeNode<Integer> root) {
		if(root == null) return Integer.MIN_VALUE;
		
		int ans = root.data;
		for(int i=0; i<root.children.size(); i++) {
			int childTreeLargest = largest(root.children.get(i));
			if(childTreeLargest > ans)
				ans = childTreeLargest;
		}
		return ans;
	}

	private static int numNodes(treeNode<Integer> root) {
		// NOTE
		// code at line 22 is not a base case. its a edge case;
		if(root == null) return 0;
		int count = 1;
		// in this example we need not to write base case explicitly. It is tackled in for loop in second expression
		// if root doesn't have any children then it won't enter in the loop;
		// so indirectly it is acting as a base case;
		for(int i=0; i<root.children.size(); i++) {
			count += numNodes(root.children.get(i));
		}
		return count;
	}

	private static treeNode<Integer> takeInput(Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		// I passed scanner as the parameter because here I dealt with recursion. So not to give input couple of times I wanted to give in one go
		// I passed Scanner as a parameter.
		System.out.println("Enter the next node");
		int n = sc.nextInt();
		treeNode<Integer> root = new treeNode<Integer>(n);
		System.out.println("Enter the childern for root " + n);
		int childCount = sc.nextInt();
		
		for(int i = 0; i < childCount; i++) {
			treeNode<Integer> child = takeInput(sc);
			root.children.add(child);
		}
		return root;
	}

	public static void print(treeNode<Integer> root) {
		String s = root.data + ": ";
		for(int i=0; i < root.children.size(); i++) 
			s += root.children.get(i).data + ",";
		
		System.out.println(s);
		
		for(int i=0; i<root.children.size(); i++) 
			print(root.children.get(i));
		
	}
	
	public static treeNode<Integer> takeInputLevelWise(){
		
		// In this approach I will use queue. Because I want to get the element which comes first.
		// And I will store treeNode in the queue, so that I can get or access the children of root node or active node at the moment;
		
		// In this approach I need not to pass Scanner as a parameter because I will not be using recursion. 
		// Basically Whenever we use recursion, recursion complete or accesses the whole tree. MATLAB RECURSION USE KIYA TO RECURSION PURA
		// TREE KO ACCESS KARKE HI LOTEGA PAR HAME AISA NAHI KARNA HAI. HAME YAHA LEVEL WISE CHAL NA HAI NA KI SUBTREE WISE.
		
		// My approach will be first I will enqueue the root and apply loop until queue becomes empty.
		// inside the loop I will perform some operations and will ask the user regarding child nodes if there are any.
		// similarly I will join child to its parent root and then enqueue the child node so that I can ask if there are any 
		// children are there for child nodes. And repeat the process.

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the root data");
		int rootData = sc.nextInt();
		treeNode<Integer> root = new treeNode<Integer>(rootData);
		QueueUsingLinkedList<treeNode<Integer>> pendingNodes = new QueueUsingLinkedList<>();
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			try {
				treeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter the number of children of " + frontNode.data);
				int num = sc.nextInt();
				for(int i=0; i<num; i++) {
					System.out.println("Enter "+(i+1)+ "th node of " + frontNode.data);
					int childData = sc.nextInt();
					treeNode<Integer> child = new treeNode<Integer>(childData);
					frontNode.children.add(child);
					pendingNodes.enqueue(child);
				}
			} catch (QueueEmptyException e) {
				// shouldn't come here because we already check in the during the entering of the loop whether the queue is empty or not;
				e.printStackTrace();
			}
		}
		return root;
	}
	
	public static void printAtK(treeNode<Integer> root, int k) {
		if(k < 0) return;
		
		if(k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		for(int i=0; i<root.children.size(); i++) {
			printAtK(root.children.get(i), k-1);
		}
	}

	public static void preorder(treeNode<Integer> root) {
		if(root == null) return;
		
		System.out.print(root.data + " ");
		for(int i=0; i<root.children.size(); i++)
			preorder(root.children.get(i));
		return;
	}
}