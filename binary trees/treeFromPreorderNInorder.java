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
	int[] preOrder;
	int[] inOrder;

	public Pair(int[] preOrder, int[] inOrder) {
		this.preOrder = preOrder;
		this.inOrder = inOrder;
	}

}

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Pair takeInput() throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine().trim());

    	int pre[] = new int[n];
    	int in[] = new int[n];

    	String[] preOrder = br.readLine().trim().split(" ");
    	String[] inOrder = br.readLine().trim().split(" ");


    	for (int i = 0; i < n; i++) {
    		pre[i] = Integer.parseInt(preOrder[i].trim());
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

    	int[] preOrder = input.preOrder;
    	int[] inOrder = input.inOrder;

    	BinaryTreeNode<Integer> root = Solution.buildTree(preOrder, inOrder);

    	printLevelWise(root);

    }
}





public class Solution {

	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		return helper(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
	}

    private static BinaryTreeNode<Integer> helper(int pre[], int in[], int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd) return null;
        if(inStart > inEnd) return null;
        
        // getting rootData, first element in preordet is always a root element;
        int rootData = pre[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        
        // trying to find the index of rootData in in[];
        int index = -1;
        for(int i=inStart; i<=inEnd; i++){
            if(in[i] == rootData){
                index = i;
                break;
            }
        }
        
        if(index == -1) return null;
        
        // calculating the needed calculations
        int leftInStart = inStart;
        int leftInEnd = index-1;
        int rightInStart = index+1;
        int rightInEnd = inEnd;
        
        int leftPreStart = preStart+1;
        int leftPreEnd = leftPreStart+leftInEnd-leftInStart;
        int rightPreStart = leftPreEnd+1;
        int rightPreEnd = preEnd;
        
        
        root.left = helper(pre, in, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
        root.right = helper(pre, in, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
        
        return root;
    }
    
}
