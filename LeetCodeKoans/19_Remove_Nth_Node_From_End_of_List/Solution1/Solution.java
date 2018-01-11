/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {
            return null;
        }
        
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p = start; // slow one
        ListNode q = start.next; // fast one
        
        for(int i = 1; i < n + 1; i++) {
            q = q.next;
        }
        
        while(q != null) {
            q = q.next;
            p = p.next;
        }
        
        p.next = p.next.next;
        
        return start.next;
    }
}
