package test.kwaymerge;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(6);
        l1.next.next.next = new Node(7);
        // 2,4,6,7

        Node l2 = new Node(3);
        l2.next = new Node(5);
        l2.next.next = new Node(6);
        //3,5,6

        Node l3 = new Node(1);
        l3.next = new Node(2);
        l3.next.next = new Node(3);
        l3.next.next.next = new Node(5);
        l3.next.next.next.next = new Node(9);
        //1,2,3,5,9

        Node[] arr = {l1, l2, l3};

        Node head = mergeLists(arr);

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + ",");
            curr = curr.next;
        }
    }

    private static Node mergeLists(final Node[] arr) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException();

        int k = arr.length;

        PriorityQueue<Node> minHeap = new PriorityQueue<>((node1,node2) -> node1.val - node2.val);
        for(int i = 0; i < k; i++){
          minHeap.add(arr[i]);
        }

        Node result = new Node(Integer.MIN_VALUE);
        Node curr = result;
        while (!minHeap.isEmpty()){
            Node minNode = minHeap.poll();
            curr.next = new Node(minNode.val);
            curr = curr.next;

            if(minNode.next != null)
                minHeap.add(minNode.next);
        }
        //Clean up temp node
        return result.next;

    }

    private static class Node {
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }
}
