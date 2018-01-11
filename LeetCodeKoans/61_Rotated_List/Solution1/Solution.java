/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        if(k == 0) {
            return head;
        }
        
        ListNode m = new ListNode(0);
        m.next = head;
        ListNode p = m;
        ListNode q = m;
        
        int count = 0;
        while(p.next != null) {
            p = p.next;
            count ++;
        }
        
        System.out.println(count);

        for(int i = count - k % count; i > 0; i-- ) {
            q = q.next;
        }
        
        // Now p.next is the new head;
        
        p.next = m.next;
        m.next = q.next;
        q.next = null;
        
        
        return m.next;
    }
}
