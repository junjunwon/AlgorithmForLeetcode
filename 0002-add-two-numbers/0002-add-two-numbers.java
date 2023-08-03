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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int extra = 0;
        while (l1 != null || l2 != null || extra != 0) {
            int l1Value = 0;
            int l2Value = 0;
            
            if (l1 != null) {
                l1Value = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Value = l2.val;
                l2 = l2.next;
            }
            
            int sum = l1Value + l2Value + extra;
            int digit = sum % 10;
            extra = sum / 10;
            
            tail.next = new ListNode(digit);;
            tail = tail.next;
        }

        return dummyHead.next;
    }
}