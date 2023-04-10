package fiftyPopularCodintInterviewProblems;

public class SortLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){this.data = data; this.next = null;}
        Node(int data, Node next){this.data = data; this.next = next;}
    }

    static class LinkedList{
        Node head;
        LinkedList(){this.head = null;}
        LinkedList(Node head){this.head = head;}
    }

    public void sortList(){
        LinkedList list = new LinkedList(new Node(4, new Node(8, new Node(1, new Node(6, new Node(2, new Node(5)))))));
        Node globalNode = list.head;
        Node newNode = null;
        while (globalNode.next != null) {
            Node node = globalNode;
            int max = node.data;
            Node previous = null;
            Node current = null;
            while (node.next != null) {
                if (node.next.data > max) {
                    max = node.next.data;
                    previous = node;
                }
                node = node.next;
            }
            if (previous == null) {
                current = globalNode;
                globalNode = globalNode.next;
                current.next = newNode;
                newNode = current;
                continue;
            }
            current = previous.next;
            previous.next = previous.next.next;
            current.next = newNode;
            newNode = current;

        }
        globalNode.next = newNode;
        list.head = globalNode;
        Node node = list.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
