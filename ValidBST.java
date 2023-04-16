//Brute Force

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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBSTUtil(TreeNode node, long min, long max) {
        if (node == null) {
            return true; // an empty tree is a valid BST
        }
        
        if (node.val <= min || node.val >= max) {
            return false; // current node violates the BST property
        }
        
        // recursively check if left and right subtrees are valid BSTs
        return isValidBSTUtil(node.left, min, node.val) && isValidBSTUtil(node.right, node.val, max);
    }
}
