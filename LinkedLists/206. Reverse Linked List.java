/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
*/


class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode prev = null;
        
        while(head!=null)
        {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        
        return prev;
    }
}
