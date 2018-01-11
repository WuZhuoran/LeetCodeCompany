/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode current = head;
        int flag = 0; // 0 or 1 only
        while(p != null || q != null) {
            int a = 0;
            int b = 0;
            if(p == null) {
                a = 0;
            } else {
                a = p.val;
            }
            
            if(q == null) {
                b = 0;
            } else {
                b = q.val;
            }
            int sum = a + b + flag;
            int dig = sum % 10;
            flag = sum / 10;
            
            current.next = new ListNode(dig);
            current = current.next;
            
            if(p != null) {
                p = p.next;
            }
            if(q != null) {
                q = q.next;
            }
        }
        
        if(flag > 0) {
            current.next = new ListNode(1);
        }
        return head.next;
    }
}
