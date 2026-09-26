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
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long min, long max) {
    if (node == null) {
        return true;
    }

    // Node must be strictly between min and max
    if (node.val <= min || node.val >= max) {
        return false;
    }

    // Left: values must be smaller than node.val
    // Right: values must be greater than node.val
    return dfs(node.left, min, node.val) &&
           dfs(node.right, node.val, max);
}
}
