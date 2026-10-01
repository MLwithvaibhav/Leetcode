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
    public ListNode rotateRight(ListNode head, int k) {

       if(head == null){
        return null;
       }
      
       if(head.next == null){
        return head;
       }

       ListNode temp = head;
       int count = 0;
       while(temp != null){
        count++;
        temp = temp.next;
       }

       k = k%count;

        for(int i=0;i<k;i++){
            temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            ListNode newNode = temp.next;
            temp.next = null;

            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}