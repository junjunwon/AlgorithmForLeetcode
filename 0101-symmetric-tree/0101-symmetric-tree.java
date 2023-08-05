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
    public boolean isSymmetric(TreeNode root) {
        /**
        define left 
        define right
        null && null return true;
        null || null return false;
        
        left.left == null || right.right == null return true;
        left.left != right.right; return false;
        left.right == null || right.left == null return true;
        left.right != right.left; return false;

         */

        if (root == null) {
            return true;
        }

         
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode leftNode, TreeNode rightNode) {
        
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }

        return (leftNode.val == rightNode.val && 
                dfs(leftNode.left, rightNode.right) &&
                dfs(leftNode.right, rightNode.left));


    }
}