package ds.basics;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Linkedlist class
 * print list
 * add first
 * add last
 * add at specific position
 * size
 * remove first
 * remove last
 * remove at specific position
 * reverse list
 * iterative search
 * recursive search
 * find middle
 * reverse from a node
 * is linkedlist a palindrome or not
*/

class LinkedList {

    static Node head;
    static Node tail;

    public class Node{
        int data;
        Node next;
    
        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    //Printing a LinkedList
    void printLinkedList(){
        Node current = head;
        while(current!=null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("end of list");

    }

    //Add First 
    void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;       
    }

    //Add Last
    void addLast(int data){
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;        
    }

    //Add in middle
    //Considering 0 as start
    void addMiddle(int position, int data){
        int current=0;
        Node node = head;
        while(current<position-1){
            node = node.next;
            current++;
        }
        Node newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;
    }

    //Size of linkedlist
    void sizeOfLinkedList(){
        int size = 0;
        Node currentNode = head;
        while(currentNode!=null){
            size++;
            currentNode=currentNode.next;
        }

        System.out.println("\nThe size of this linked list is -> " + size);
    }

    //Remove first


    //Remove last
    void removeLast(){
        Node currentNode = head;
        while(currentNode.next!=tail){
            currentNode=currentNode.next;
        }
        currentNode.next=null;
        tail = currentNode;
        System.out.println("\n Printing after removing last element");
        this.printLinkedList();
    }

    //Reverse a linkedlist
    void reverseList(){
        Node temp1 = head, temp2 = head.next;
        temp1.next = null;
        while(temp2!=null){
            Node temp = temp2.next;
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp;
        }
        tail=head;
        head=temp1;
    }

    //Iterative search




    //Recursive search
    int recursiveSearchKey(int key){
        return helperRecursiveSearchKey(head, key, 0);
    }

    int helperRecursiveSearchKey(Node head, int key, int position){
        if(head==null) return -1;
        if(head.data==key) return position;
        return helperRecursiveSearchKey(head.next, key, position+1);        
    }



    //Find middle element of Linkedlist - Slow/Fast (aka Turtle/Hare) technique
    Node findMiddle(){
        Node slowPointer = head; //This will increase by 1
        Node fastPointer = head; //This will increase by 2

        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer=fastPointer.next.next;
        }
        System.out.println("Middle element of linkedlist is with data " + slowPointer.data);
        return slowPointer;
    }

    void reverseFromANode(Node node){
        Node temp1 = node;
        Node temp2 = node.next;
        temp1.next = null;

        while(temp2!=null){
            Node temp = temp2.next;
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp;
        }
    }

    boolean checkListPalindrome(){
        reverseFromANode(findMiddle());
        Node temp1 = head;
        Node temp2 = tail;
        while(temp1!=null && temp2!=null){
            if(temp1.data!=temp2.data) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    boolean detectLoopInLinkedList(){

        HashSet<Node> set = new HashSet<>();
        Node currentNode = head;

        while(currentNode!=null){
            set.add(currentNode);
            currentNode=currentNode.next;
            if(set.contains(currentNode)){
                System.out.println("\nThere is a cycle/loop present in list");
                return true;
            }
        }
        System.out.println("\nThere is no cycle/loop present in list");
        return false;
    }

    //FLOYD's CYCLE FINDING ALGORITHM USING SLOW FAST POINTER
    boolean detectLoopInLinkedListFLOYD(){
        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer==fastPointer){
                System.out.println("\nThere is a cycle/loop present in list FLOYD's cycle finding algorithm");
                return true;
            }
        }

        System.out.println("\nThere is no cycle/loop present in list FLOYD's cycle finding algorithm");
        return false;
    }

}


class LinkedListMainClass{

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        LinkedList.Node node1 = linkedList.new Node(1);
        linkedList.head = node1;
        LinkedList.Node node2 = linkedList.new Node(2);
        node1.next = node2;
        linkedList.tail = node2;
        System.out.println("\nPrinting initial linkedlist");
        // linkedList.printLinkedList();

        linkedList.addFirst(30);
        // System.out.println("\nPrinting after inserting element at first place");
        // linkedList.printLinkedList();
        linkedList.addLast(1);
        linkedList.addLast(30);
        // System.out.println("\nPrinting after inserting element at last place");
        // linkedList.printLinkedList();

        linkedList.tail.next = node2;
        // linkedList.addMiddle(3,786);
        // System.out.println("\nPrinting after inserting element at middle place");
        // linkedList.printLinkedList();

        // linkedList.reverseList();
        // System.out.println("\nPrinting after reversing the linked list");
        // linkedList.printLinkedList();
        // int key = 786;
        // System.out.println(
        //     "\n Key " + key +" is found at position -> " + linkedList.recursiveSearchKey(key)
        // );

        // linkedList.sizeOfLinkedList();

//        linkedList.removeLast();

        // linkedList.findMiddle();

        // System.out.println("\nIs linkedlist a palindrome -> " + linkedList.checkListPalindrome());;

        linkedList.detectLoopInLinkedListFLOYD();
    }

}




// class Node{
//     int data;
//     Node next;

//     public Node(int data){
//         this.data = data;
//         next = null;
//     }
// }



