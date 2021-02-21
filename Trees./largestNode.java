package trees;

import java.util.*;

public class TreeUse {

	private static TreeNode<Integer> takeInput(Scanner sc){
		//System.out.println("Enter the root data");
		//Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		System.out.println("Enter the child count of " + rootData);
		int childCount = sc.nextInt();
		
		for(int i=0; i<childCount; i++) {
			TreeNode<Integer> child = takeInput(sc);
			root.children.add(child);
		}
		
		return root;
	}

	private static TreeNode<Integer> takeInputLevelWise(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the root data");
		int rootData = sc.nextInt();
		// creating a queue in order to store nodes of a tree;
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		// add root data to the queue;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode<Integer> frontNode = queue.poll();
			System.out.println("Enter the number of children of " + frontNode.data);
			int childCount = sc.nextInt();
			for(int i=0; i<childCount; i++) {
				System.out.println("Enter the " + (i+1) + " th child of " + frontNode.data);
				int childData = sc.nextInt();
				TreeNode<Integer> child = new TreeNode<Integer>(childData);
				frontNode.children.add(child);
				queue.add(child);
			}
		}
		
		return root;
	}
	

	private static int largestNode(TreeNode<Integer> root) {
		if(root == null) return Integer.MIN_VALUE;
		
		int ans = root.data;
		
		for(int i=0; i<root.children.size(); i++) {
			int temp = largestNode(root.children.get(i));
			ans = Math.max(temp, ans);
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		TreeNode<Integer> root = takeInput(sc);
		
		TreeNode<Integer> root = takeInputLevelWise();
		//printLevelWise(root);
		
		//System.out.println(countNodes(root));
		System.out.println(largestNode(root));
		
	}

}
