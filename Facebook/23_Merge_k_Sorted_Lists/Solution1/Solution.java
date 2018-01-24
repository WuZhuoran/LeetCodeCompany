/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Try merge sort
        return partition(lists, 0, lists.length - 1);

    }

    public ListNode partition(ListNode[] list, int start, int end) {
        if(start == end) {
            return list[start];
        }

        if(start < end) {
            int mid = (start + end) / 2;
            ListNode l = partition(list, start, mid);
            ListNode r = partition(list, mid + 1, end);

            return merge(l, r);

        } else {
            return null;
        }
    }

    public ListNode merge(ListNode l, ListNode r) {
        if(l == null) {
            return r;
        }

        if(r == null) {
            return l;
        }

        if(l.val < r.val) {
            l.next = merge(l.next, r);
            return l;
        } else {
            r.next = merge(l, r.next);
            return r;
        }
    }
}
