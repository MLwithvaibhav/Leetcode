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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 1. Aage ka node save kiya
            curr.next = prev;              // 2. Arrow reverse kiya
            prev = curr;                   // 3. prev ko aage badhaya
            curr = nextTemp;               // 4. curr ko aage badhaya
        }

        // Loop ke baad curr null ho jayega aur prev naya head ban chuka hoga
        return prev;
    }
}