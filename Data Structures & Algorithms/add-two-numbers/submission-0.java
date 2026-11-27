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
        if(l1==null && l2==null){
            return l1;
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        ListNode a=l1;
        ListNode b=l2;
        int carry=0;
        while(a!=null && b!=null){
            int sum=a.val+b.val+carry;
            carry=sum/10;
            ListNode newNode =new ListNode(sum%10);
            temp.next=newNode;
            temp=newNode;
            a=a.next;
            b=b.next;
        }
        while(a!=null){
            int sum=a.val+carry;
            carry=sum/10;
            ListNode newNode =new ListNode(sum%10);
            temp.next=newNode;
            temp=newNode;
            a=a.next;
        }
        while(b!=null){
            int sum=b.val+carry;
            carry=sum/10;
            ListNode newNode =new ListNode(sum%10);
            temp.next=newNode;
            temp=newNode;
            b=b.next;
        }
        if(carry>0){
            ListNode newNode=new ListNode(carry);
            temp.next=newNode;
        }
        return dummy.next;
    }
}
