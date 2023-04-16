//Recursive

//Time = O(n)
//Space = O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Define the public method that takes in the preorder and inorder arrays
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Call the private helper method with the appropriate parameters
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    // Define the private helper method that constructs the binary tree recursively
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        // Base case: if any of the indices are out of bounds, return null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        // Create a new TreeNode with the value at the current index in the preorder array as the root of the current subtree
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // Find the index of the root in the inorder array
        int inorderRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inorderRootIndex = i;
                break;
            }
        }
        
        // Calculate the size of the left subtree
        int leftSubtreeSize = inorderRootIndex - inStart;
        
        // Recursively construct the left and right subtrees, and set them as the left and right children of the current root node
        root.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart + leftSubtreeSize, inStart, inorderRootIndex - 1);
        root.right = buildTreeHelper(preorder, inorder, preStart + leftSubtreeSize + 1, preEnd, inorderRootIndex + 1, inEnd);
        
        // Return the current root node
        return root;
    }
}


//Brute force

//Time = O(n^2)
//Space = O(n)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // If the preorder array is null or empty, there is no node to construct
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        // The first element of the preorder array is the root of the binary tree
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root node in the inorder array
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // Create subarrays for the left and right subtrees
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

        // Recursively construct the left and right subtrees and assign them to the root's left and right nodes
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        // Return the root of the constructed binary tree
        return root;
    }
}
