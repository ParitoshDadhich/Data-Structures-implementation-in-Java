// method 3
// time o(n);


// in this approach we are not putting any restrictions on root 
// root can take any value 
// idea here is the leftTree and the rightTree can have values within a range only;
// left -> (min, root.data-1);
// right -> (root.data, max);

public class Solution {

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
    
    private static boolean helper(BinaryTreeNode<Integer> root, int min, int max){
        if(root == null)
            return true;
        
        if(root.data < min || root.data > max)
            return false;
        
        boolean isLeftBST = helper(root.left, min, root.data-1);
        boolean isRightBST = helper(root.right, root.data, max);
        
        return isLeftBST && isRightBST;
    }

}

