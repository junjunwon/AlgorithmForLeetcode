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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode middle = findMiddleToEnd(head);
        ListNode reverse = ReverseListNode(middle);
        
    
        while (reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        
        return true;
    }
    
    public ListNode findMiddleToEnd(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next != null) {
            slow = slow.next;
        }

        return slow;
        
//         while (slow.next != null && fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
        
//         return slow;
    }
    public ListNode ReverseListNode(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode current = node;
        ListNode prev = null;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}
/**
초기 상태에서는 다음과 같습니다:

head: 1
prev: null
current: 1
첫 번째 노드인 1의 next를 이전 노드를 가리키도록 업데이트합니다. 이전 노드가 없으므로 next는 null이 됩니다.

연결 리스트 상태: null <- 1, 2 -> 3 -> 4 -> 5

prev: 1
current: 1
next: 2
두 번째 노드인 2의 next를 이전 노드를 가리키도록 업데이트합니다. 이전 노드는 1입니다.

연결 리스트 상태: null <- 1 <- 2, 3 -> 4 -> 5

prev: 2
current: 2
next: 3
세 번째 노드인 3의 next를 이전 노드를 가리키도록 업데이트합니다. 이전 노드는 2입니다.

연결 리스트 상태: null <- 1 <- 2 <- 3, 4 -> 5

prev: 3
current: 3
next: 4
네 번째 노드인 4의 next를 이전 노드를 가리키도록 업데이트합니다. 이전 노드는 3입니다.

연결 리스트 상태: null <- 1 <- 2 <- 3 <- 4, 5

prev: 4
current: 4
next: 5
다섯 번째 노드인 5의 next를 이전 노드를 가리키도록 업데이트합니다. 이전 노드는 4입니다.

연결 리스트 상태: null <- 1 <- 2 <- 3 <- 4 <- 5

prev: 5
current: 5
next: null

**/
