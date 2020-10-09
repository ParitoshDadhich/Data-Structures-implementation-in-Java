package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PracticeTreeUse {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//PracticeNode<Integer> root = takeInput(s);
		PracticeNode<Integer> root = takeInputLevelWise();
		print(root);
		System.out.println("The largest value of the tree is " + largest(root));
		System.out.println("Number of nodes in Tree are: " + numNodes(root));
		printAtK(root, 2);

	}

	private static PracticeNode<Integer> takeInput(Scanner s) {
		System.out.println("Enter the next node");
		int n = s.nextInt();
		PracticeNode<Integer> root = new PracticeNode<Integer>(n);
		System.out.println("Enter the children for root " + n);
		int childCount = s.nextInt();
		
		for(int i=0; i<childCount; i++) {
			PracticeNode<Integer> child = takeInput(s);
			root.children.add(child);
		}
		
		return root;
	}

	public static void print(PracticeNode<Integer> root) {
		String s = root.data + ": ";
		for(int i=0; i<root.children.size(); i++)
			s += root.children.get(i).data + ", ";
		System.out.println(s);
		
		for(int i=0; i<root.children.size(); i++)
			print(root.children.get(i));
	}

	private static PracticeNode<Integer> takeInputLevelWise(){
		System.out.println("Enter the next node");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PracticeNode<Integer> root = new PracticeNode<Integer>(n);
		Queue<PracticeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		 while(!queue.isEmpty()) {
			PracticeNode<Integer> front = queue.poll();
			System.out.println("Enter the children for root " + front.data);
			int childCount = sc.nextInt();
			for(int i=0; i<childCount; i++) {
				System.out.println("Enter "+ (i+1) + " children of root " + front.data);
				int childData = sc.nextInt();
				PracticeNode<Integer> child = new PracticeNode<Integer>(childData);
				front.children.add(child);
				queue.add(child);
			}
		 }
		
		return root;
	}

	public static int largest(PracticeNode<Integer> root) {
		if(root == null) return -1;
		
		int max = Integer.MIN_VALUE;
		if(root.data > max)
			max = root.data;
		
		for(int i=0; i<root.children.size(); i++) {
			int temp = largest(root.children.get(i));
			if(temp > max)
				max = temp;
		}
		return max;
	}
	
	
    public static int numNodes(PracticeNode<Integer> root) {
		if(root == null ) return 0;
		int count =1;
		for(int i=0; i<root.children.size(); i++) 
			count += numNodes(root.children.get(i));
		
		return count;
	}

    public static void preorder(PracticeNode<Integer> root) {
    	if(root == null) return;
    	
    	System.out.print(root.data + " ");
    	for(int i=0; i<root.children.size(); i++)
    		preorder(root.children.get(i));
    	
    	return;
    }

    public static void printAtK(PracticeNode<Integer> root, int k) {
    	if(k < 0 || root == null) return;
    	
    	if(k == 0) {
    		System.out.print(root.data + " ");
    		return;
    	}
    	
    	for(int i=0; i<root.children.size(); i++)
    		printAtK(root.children.get(i), k-1);
    	
    	return;
    }
}
