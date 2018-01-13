/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 *
 *
 If we convert BST to sorted array and use two pointers, we need <strong>O(n)</strong> space. In fact, we only need <strong>O(lg(n))</strong> space, by implement two iterators using stack.

 The idea of using interator is from 173. Binary Search Tree Iterator. Since the in-order treversal of BST ouputs the value in ascending order, we can use iterator to get next smallest value in <strong>O(1) average time</strong>. Similarly, we can also implement a reverse iterator to get next largest value each time from BST. (For how to use stack to implement iterator, please refer to: https://discuss.leetcode.com/topic/6604/ideal-solution-using-stack-java)

 With those two iterators in hand, now we can use two pointers to solve the problem.

 Since the size iterator(stack) is the height of the BST tree, it only requries <strong>O(lg(n))</strong> space.

 So the overall performace is: O(n)/O(lg(n)).
 */

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> l = new Stack<TreeNode>();
        Stack<TreeNode> r = new Stack<TreeNode>();

        for(TreeNode curr = root; curr != null; curr = curr.left) {
            l.push(curr);
        }
        for(TreeNode curr = root; curr != null; curr = curr.right) {
            r.push(curr);
        }

        while(!l.isEmpty() && !r.isEmpty() && l.peek() != r.peek()) {
            int sum = l.peek().val + r.peek().val;
            if(sum == k) {
                return true;
            }

            if(sum < k) {
                for(TreeNode curr = l.pop().right; curr != null; curr = curr.left) {
                    l.push(curr);
                }
            } else {
                for(TreeNode curr = r.pop().left; curr != null; curr = curr.right) {
                    r.push(curr);
                }
            }
        }

        return false;
    }
}
