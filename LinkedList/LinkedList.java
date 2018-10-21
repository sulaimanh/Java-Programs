/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author sulaimanhamouda
 */
public class LinkedList {
    
    // - This represents the head of the linked list
    Node head;
    
    // - Linked List node
    public class Node{
        
        int data;
        Node next;
        
        public Node(int d){
            next = null;
            data = d;
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
       list.appendToTail(10);
       list.appendToTail(10);
       list.appendToTail(5);
       list.appendToTail(7);
       list.appendToTail(10);
       list.appendToTail(4);
       list.appendToTail(5);
       list.appendToTail(10);
       list.appendToTail(7);
       list.appendToTail(5);
       list.appendToTail(4);
       list.appendToTail(1);
        
          
        
       list.printList();
        
       list.removeDuplicates();

       list.removeKthToLastElement(2);

       list.printList();
    }
  
    
    // - In this method, we will append a new node at the end of a linked list.
    public void appendToTail(int d){
        // - Here, we allocate the new node and put in the data
        Node newNode = new Node(d);
        
        // - If the LinkedList is empty, then make the new node as head.
        if(head == null){
            head = new Node(d);
            return;
        }
        
        // - Since this is going to become the last node, we set next to null
        newNode.next = null;
        
        // - Here, we will traverse to the last node
        Node last = head;
        while(last.next != null)
            last = last.next;
        
        // - Change the next of last node
        last.next = newNode;
        return;
        
    }
    
    // - Here, we insert a new node at the front of the list.
    public void appendToFront(int d){
        Node newNode = new Node(d);
        newNode.next = head;
        head = newNode;
    }
    
    // - Here, we will delete the first occurrence of key in a linked list
    public void deleteNode(int key){
        Node temp = head;
        Node prev = null;
        
        if(temp != null && temp.data == key){
            head = temp.next;
            return;
        }
            
        while(temp.next != null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }
        
        if(temp == null)
            return;
        
        // - Unlink the node from the linked list
        prev.next = temp.next;
    }

    // - This will print out the whole linked list
    public void printList(){
        Node temp = head;
        
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    // - Here, we will remove all the duplicates from the linked list
    public void removeDuplicates(){
        Node temp = head;
        Node forward = null;
        Node dup = null;
        
        while(temp != null && temp.next != null){
            forward = temp;
            while(forward.next != null){
                if(temp.data == forward.next.data){
                    dup = forward.next;
                    forward.next = forward.next.next;
                    System.gc();
                }
                else
                    forward = forward.next;
                
            }
            temp = temp.next;
        }
        
    }
    
    // - Here, we remove the kth to last element.
    // - We first determine the size of the linked list in order to make the provess go smoother.
    public void removeKthToLastElement(int kthToLast){
        Node temp = head;
        Node prev = null;
        // - This is the actual element we want to remove.
        int removeElement = sizeOfLinkedList() - kthToLast;
        // - This represents the current element we are on
        int currentElement = 0;
        
        // - Here, we skip to that element.
        while(temp != null && removeElement != currentElement){
            currentElement++;
            prev = temp;
            temp = temp.next;
        }
        
        // - Here, we delete that element.
        prev.next = temp.next;
    }
    
    // - Here, we determine the size of our Linked List
    public int sizeOfLinkedList(){
        if(head == null)
            return 0;
        
        Node temp = head; 
        int size = 0;
        
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        // - This is the size of our linked list
        return size;
    }
}
