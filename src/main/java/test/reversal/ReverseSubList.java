package test.reversal;

public class ReverseSubList {
    public static void main(String[] args) {
        Node h = new Node(8,null);
        Node g = new Node(7,h);
        Node f = new Node(6,g);
        Node e = new Node(5,f);
        Node d = new Node(4,e);
        Node c = new Node(3,d);
        Node b = new Node(2,c);
        Node a = new Node(1,b);

        //indices are 0 indexed
        Node curr = reverseSubList(a, 2,5);
        while (curr != null) {
            System.out.print(curr.val + ",");
            curr = curr.next;
        }
    }

    private static Node reverseSubList(final Node head, final int startIndex, final int endIndex) {
        if(head == null)
            return null;
        int i = 0;
        Node node = head;
        while( node !=null && i < startIndex - 1 ) {
            node = node.next;
            i++;
        }

        //Begin reverse
        Node previous = null;
        Node curr = node.next;

        while (curr!=null && i < endIndex){
            Node temp = curr.next;
            curr.next = previous;
            previous = curr;
            curr= temp;
            i++;
        }

        Node oldStartNode = node.next;
        Node oldEndNode = previous;

        node.next = oldEndNode;
        oldStartNode.next = curr;

        return head;
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
