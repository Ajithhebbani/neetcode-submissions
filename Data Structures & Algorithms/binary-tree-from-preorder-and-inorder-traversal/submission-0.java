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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

    // Store inorder value -> index
    for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
    }

    return build(preorder, 0, preorder.length - 1,
                 inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(
        int[] preorder, int preStart, int preEnd,
        int[] inorder, int inStart, int inEnd,
        Map<Integer, Integer> map) {

    // No elements
    if (preStart > preEnd || inStart > inEnd) {
        return null;
    }

    // First element in preorder is the root
    int rootValue = preorder[preStart];

    TreeNode root = new TreeNode(rootValue);

    // Find root position in inorder
    int rootIndex = map.get(rootValue);

    // Number of nodes in left subtree
    int leftSize = rootIndex - inStart;

    // Build left subtree
    root.left = build(
            preorder,
            preStart + 1,
            preStart + leftSize,
            inorder,
            inStart,
            rootIndex - 1,
            map
    );

    // Build right subtree
    root.right = build(
            preorder,
            preStart + leftSize + 1,
            preEnd,
            inorder,
            rootIndex + 1,
            inEnd,
            map
    );

    return root;
}
}
