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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[2];
        dfs(root, k, count);
        return count[1];
    }

    private void dfs(TreeNode root, int k, int[] count){
        if(root == null) return;
        if(count[0] >= k) return;

        dfs(root.left, k, count);
        count[0]++;

        if(count[0] == k){
            count[1] = root.val;
        }
        dfs(root.right, k, count);
    }
}
