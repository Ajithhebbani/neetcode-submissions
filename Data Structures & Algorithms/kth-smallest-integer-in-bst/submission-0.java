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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (true) {

            // Go all the way to the left
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit the smallest node
            current = stack.pop();

            k--;

            // kth smallest found
            if (k == 0) {
                return current.val;
            }

            // Now process the right subtree
            current = current.right;
        }
    }
}
