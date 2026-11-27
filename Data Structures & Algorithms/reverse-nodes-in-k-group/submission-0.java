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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        if(k==1 || head==null){
            return head;
        }
        ListNode newHead=null;
        ListNode prev=null;
        ListNode next=head;
        int irt=len/k;
        int i=0;
        while(i<irt){
            ListNode pre=null;
            ListNode curr=next;
            ListNode nextptr=null;
            for (int j = 0; j < k && curr!=null; j++) {
                nextptr = curr.next;
                curr.next = pre;
                pre = curr;
                curr = nextptr;
            }
            if(i==0){
                newHead=pre;
            }
            if(prev!=null){
                prev.next=pre;
            }
            prev=next;
            next=nextptr;
            i++;
        }
         prev.next = next;
         return newHead;
    }
}
