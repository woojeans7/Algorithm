/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode tmp = new ListNode(0);
        ListNode cur = head;
        ListNode prev = tmp;
        ListNode next = null;

        while(cur != null){
            next = cur.next;

            while(prev.next != null && prev.next.val < cur.val){
                prev = prev.next;
            }

            cur.next = prev.next;
            prev.next = cur;

            prev = tmp;
            cur = next;
        }

        return tmp.next;
    }
}