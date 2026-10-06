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
    private void insertInBetween(Node head){
        Node temp = head;
        while(temp != null){
            Node nextElement = temp.next;
            Node copy = new Node(temp.val);
            temp.next = copy;
            copy.next = nextElement;
            temp = nextElement;
        }
    }
    private void connectRandomPointer(Node head){
        Node temp = head;
        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            }
            else{
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }
    private Node getDeepCopyList(Node head){
        Node temp = head;
        Node dummy = new Node(0);
        Node res = dummy;
        while(temp != null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        insertInBetween(head);
        connectRandomPointer(head);
        return getDeepCopyList(head);
    }
}
