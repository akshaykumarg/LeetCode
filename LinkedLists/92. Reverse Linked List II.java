
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode prev1 = new ListNode(0);
        prev1.next = head;
        ListNode prev = prev1;
        ListNode forward = head;
        
        for(int i=1;i<m;i++){
            prev = prev.next;
            forward = forward.next;
        }
        
        ListNode temp = forward.next;
        
        for(int i=m;i<n;i++){
            
            ListNode x = temp.next;
            temp.next = prev.next;
            prev.next = temp;    
            forward.next = x;
            temp = x;
            
        }
        
        return prev1.next;
    }
}   
