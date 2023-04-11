package fiftyPopularCodintInterviewProblems;


import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
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

    public void reverseList(LinkedList list){
        Node previous = null;
        Node currentNode = list.head;
        while (currentNode != null) {
            Node next = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            currentNode = next;
        }
        list.head = previous;
    }
}
