package test.reversal;

public class LinkedListReversal {
    public static void main(String[] args) {
        Node e = new Node(5,null);
        Node d = new Node(4,e);
        Node c = new Node(3,d);
        Node b = new Node(2,c);
        Node a = new Node(1,b);

        Node curr = reverseLinkedList(a);
        while (curr != null) {
            System.out.print(curr.val + ",");
            curr = curr.next;
        }

    }

    private static Node reverseLinkedList(final Node head) {
        if(head == null)
            return head;
        Node previous = null;
        Node curr = head;

        while(curr !=null ){
            Node temp = curr.next;
            curr.next = previous;
            previous = curr;
            curr = temp;
        }

        return previous;
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}
