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
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToHeightBalancedTree(0, nums.length - 1, nums);
    }

    public TreeNode convertToHeightBalancedTree(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        
        int middle = (left + right) / 2;
        
        TreeNode root = new TreeNode (nums[middle]);
        root.left = convertToHeightBalancedTree(left, middle - 1, nums);
        root.right = convertToHeightBalancedTree(middle + 1, right, nums);

        return root;
    }
}