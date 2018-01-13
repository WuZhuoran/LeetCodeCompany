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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        if(root == null) {
            return res;
        }

        q.add(root);

        while(!q.isEmpty()) {
            int n = q.size();
            long sum = 0;
            for(int i = 0; i < n; i++) {
                TreeNode x = q.poll();
                sum += (long)x.val;
                if(x.left != null) {
                    q.add(x.left);
                }
                if(x.right != null) {
                    q.add(x.right);
                }
            }
            res.add(1.0 * sum / n);
        }

        return res;
    }
}
