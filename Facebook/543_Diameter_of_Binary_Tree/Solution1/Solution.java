/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int rootDepth = maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftMax = maxDepth(node.left);
        int rightMax = maxDepth(node.right);

        max = Math.max(max, leftMax + rightMax);

        return Math.max(leftMax, rightMax) + 1;
    }
}
