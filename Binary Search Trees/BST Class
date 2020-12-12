import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

	public static void main(String[] args) throws IOException {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			choice = Integer.parseInt(st.nextToken());
			switch (choice) {
			case 1:
				input = Integer.parseInt(st.nextToken());
				bst.insert(input);
				break;
			case 2:
				input = Integer.parseInt(st.nextToken());
				bst.remove(input);
				break;
			case 3:
				input = Integer.parseInt(st.nextToken());
				System.out.println(bst.search(input));
				break;
			default:
				bst.printTree();
				break;
			}

		}
	}
}




public class BinarySearchTree {
    
    static BinaryTreeNode<Integer> root;
    
    static boolean search(int data){
        return searchHelper(root, data);
    }
    
	private static boolean searchHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null) return false;
        
        if(root.data == data)
            return true;
        if(root.data > data)
            return searchHelper(root.left, data);
        else
            return searchHelper(root.right, data);
    }
    
    
    
    static void insert(int data){
        root = insertHelper(root, data);
        return ;
    }
    
    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data){
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
        
        if(root == null){
            root = node;
            return root;
        }
        
        if(root.data >= data)
            root.left = insertHelper(root.left, data);
        if(root.data < data)
            root.right = insertHelper(root.right, data);
        
        return root;
    }
    
    
    static void remove(int data){
        root = deleteHelper(root, data);
    }
    
    private static BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null) return null;
        
        
        if(root.data > data)
            root.left = deleteHelper(root.left, data);
        else if(root.data < data)
            root.right = deleteHelper(root.right, data);
        
        else{
        
			     if(root.left == null && root.right == null) return null;
    	    
	       		 else if(root.right == null && root.left != null) return root.left;
        
    		     else if(root.right != null && root.left == null) return root.right;
        
	
	            root.data = smallest(root.right).data;
        		root.right = deleteHelper(root.right, root.data);
     		 		
     		}
    	return root;
    }
    
    
    
    
    
    
    private static BinaryTreeNode<Integer> smallest(BinaryTreeNode<Integer> root){
        
        if(root.left == null)
            return root;
        
        return smallest(root.left);
        
        // BinaryTreeNode<Integer> temp = root;
        // while(root.left != null){
        //     temp = root.left;
        //     root = root.left;
        // }
        // return temp;
    }
    
    
    
    
    static void printTree(){
        if(root == null) return;
        
        printTreeHelper(root);
    }
    
    private static void printTreeHelper(BinaryTreeNode<Integer> root){
        if(root == null) return;
        
        String s = root.data + ":";
        if(root.left != null)
            s += "L:" + root.left.data + ",";
        if(root.right != null)
            s += "R:" + root.right.data;
        
        System.out.println(s);
        
        printTreeHelper(root.left);
        printTreeHelper(root.right);
        
        return;
    }
	
}
