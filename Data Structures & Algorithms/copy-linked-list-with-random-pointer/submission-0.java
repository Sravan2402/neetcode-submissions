/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Map<Node,Node> mp=new HashMap<>();
        Node temp=head;
        Node copy=new Node(temp.val);
        Node curr=copy;
        mp.put(temp,curr);
        temp=temp.next;
        while(temp!=null){
            Node newNode=new Node(temp.val);
            curr.next=newNode;
            curr=curr.next;
            mp.put(temp,curr);
            temp=temp.next;
        }
        temp=head;
        curr=copy;
        while(temp!=null){
            curr.random=mp.get(temp.random);
            curr=curr.next;
            temp=temp.next;
        }
        return copy;
    }
}
