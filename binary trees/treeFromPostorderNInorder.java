import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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

class Pair {
	int[] postOrder;
	int[] inOrder;

	public Pair(int[] postOrder, int[] inOrder) {
		this.postOrder = postOrder;
		this.inOrder = inOrder;
	}

}

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Pair takeInput() throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine().trim());

    	int pre[] = new int[n];
    	int in[] = new int[n];

    	String[] postOrder = br.readLine().trim().split(" ");
    	String[] inOrder = br.readLine().trim().split(" ");


    	for (int i = 0; i < n; i++) {
    		pre[i] = Integer.parseInt(postOrder[i].trim());
    		in[i] = Integer.parseInt(inOrder[i].trim());
    	}

    	return new Pair(pre, in);

    }

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
        pendingNodes.add(null);

		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

        
	        if (frontNode == null) {
	            System.out.println();

	            if (!pendingNodes.isEmpty()) {
	                pendingNodes.add(null);
	            }

	        } else {
	        	System.out.print(frontNode.data + " ");

	            if (frontNode.left != null) {
	                pendingNodes.add(frontNode.left);
	            } 

	            if (frontNode.right != null) {
	                pendingNodes.add(frontNode.right);
	            } 
	        }

		}
		
	}
    public static void main(String[] args) throws NumberFormatException, IOException {

    	Pair input = takeInput();

    	int[] postOrder = input.postOrder;
    	int[] inOrder = input.inOrder;

    	BinaryTreeNode<Integer> root = Solution.buildTree(postOrder, inOrder);

    	printLevelWise(root);

    }
}



public class Solution {

	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		return helper(postOrder, inOrder, 0, postOrder.length-1, 0, inOrder.length-1);
	}
    
    private static BinaryTreeNode<Integer> helper(int po[], int in[], int poStart, int poEnd, int inStart, int inEnd){
        
        if(poStart > poEnd) return null;
        if(inStart > inEnd) return null;
        
        int rootData = po[poEnd];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        
        int index = -1;
        for(int i=inStart; i<=inEnd; i++){
            if(in[i] == rootData){
                index = i;
                break;
            }
        }
        
        if(index == -1) return null;
        
        int leftInStart = inStart;
        int leftInEnd = index-1;
        int rightInStart = index+1;
        int rightInEnd = inEnd;
        
        int leftPoStart = poStart;
        int leftPoEnd = leftPoStart + leftInEnd-leftInStart;
        int rightPoStart = leftPoEnd+1;
        int rightPoEnd = poEnd-1;
        
        root.left = helper(po, in, leftPoStart, leftPoEnd, leftInStart, leftInEnd);
        root.right = helper(po, in, rightPoStart, rightPoEnd, rightInStart, rightInEnd);
        
        return root;
    }

}

