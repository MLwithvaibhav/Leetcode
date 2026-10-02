class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1;
        ListNode j = list2;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (i != null && j != null) {
            if (i.val <= j.val) {
                tail.next = i;
                i = i.next;
            } else {
                tail.next = j;
                j = j.next;
            }
            tail = tail.next; // Har iteration ke baad tail ko aage badhao
        }

        // Loop ke BAHAR bachi hui list ko attach karo
        if (i != null) {
            tail.next = i;
        } else {
            tail.next = j;
        }

        return dummy.next;
    }
}