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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int sum = 0;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        while(!s.isEmpty()) {
            TreeNode x = s.pop();
            if(x != null) {
                if(x.left != null && x.left.left == null && x.left.right == null) {
                    sum += x.left.val;
                }

                s.add(x.left);
                s.add(x.right);
            }

        }

        /*
        Stack<TreeNode> s = new Stack<TreeNode>();

        s.add(root);

        while(!s.isEmpty()) {
            int count = s.size();

            for(int i = 0; i < count; i++) {
                TreeNode n = s.pop();
                if(n.left != null) {
                    s.add(n.left);
                    sum += n.left.val;
                }

                if(n.right != null) {
                    s.add(n.right);
                }
            }
        }
        */

        return sum;
    }
}
