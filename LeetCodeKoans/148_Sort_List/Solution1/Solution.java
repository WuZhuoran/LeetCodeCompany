/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        // divide into two list
        
        ListNode pre = head;
        ListNode p1 = head;
        ListNode p2 = head;
        
        while(p2 != null && p2.next != null) {
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        pre.next = null;
        
        //now we have two list, head to pre, p1 to p2
        
        ListNode p = sortList(head);
        ListNode q = sortList(p1);
        
        return mergeList(p,q);
        //return head;
        
    }
    
    /*
    public int count(ListNode head) {
        int count = 0;
        ListNode p = head;
        while(p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    */
    
    public ListNode mergeList(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        if(l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }
        
    }
}
