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

    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        /**
        static하게 minimumDepth tracking
        root가 left, right 둘다 안가지고 있으면 return 1

        leftMinDepth = left 트리노드중 가장 짧은 leaf노드 찾기
        rightMinDepth = right 트리노드중 가장 짧은 leaf노드 찾기
        
        leftMinDepth, rightMinDepth 비교해서 가장 작은거 return 
         */
        
        if (root == null) {
            return 0;
        }
        
        findAndGetMinDepth(root, 1);

        return min;
    }

    public void findAndGetMinDepth(TreeNode root, int depth) {
        if (root == null || min < depth) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (min > depth) {
                min = depth;
            }
            return;
        }

        findAndGetMinDepth(root.left, depth + 1);
        findAndGetMinDepth(root.right, depth + 1);
    }
}