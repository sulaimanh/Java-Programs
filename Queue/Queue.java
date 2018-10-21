/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author sulaimanhamouda
 */
public class Queue {

    /**
     * First in First out ordering
     * It uses the operations:
     *      enqueue(item)
     *      dequeue()
     *      peek()
     *      isEmpty()
     * 
     */
    
    // a is the our queue represented as a queue
    // MAX represents the maximum number of elements we can put in our queue
    // front represents the front element
    // rear represents the rear element
    // size represents the true number of elements in the queue
    int [] a;
    int MAX;
    int front, rear, size;
    
    public Queue(int n){
        MAX = n;
        a = new int[MAX];
        front = size = 0;
        rear = MAX - 1;
    }
    
    // - Here, we will check if the queue is full
    public boolean isFull(){
        // - If the size of the elements equals the max capacity of the array, then we are full
        return (this.size == this. MAX);
    }
    
    // - This will add an element to the queue
    public void enqueue(int item){
        // - If we are full, we will not enqueue
        if(isFull())
            return;
        // - This will get the next available space in our queue
        rear = (rear + 1) % MAX;
        // - Insert into queue
        a[rear] = item;
        // - Increase the size by one because we added an element
        size = size + 1;
        System.out.println(item + " enqueued to queue");
    }
    
    // - This will remove the first element to ever be enqueued
    public int dequeue(){
        if(isEmpty())
            return Integer.MIN_VALUE;
        
        // - When we dequeue, we remove the front element
        int item = a[front];
        // - We will now increment the front variable by one;
        front = (front + 1) % MAX;
        size = size - 1;
        return item;
    }
    
    // - This will provide us with the front element of the queue
    public int front(){
        if(isEmpty())
            return Integer.MIN_VALUE;
        return a[front];
    }
    
    // - This will provide us with the back element of the queue
    public int rear(){
        if(isEmpty())
            return Integer.MIN_VALUE;
        return a[rear];
    }
    
    public boolean isEmpty(){
        return (this.size == 0);
    }
    
    
    public static void main(String[] args) {
        Queue queue = new Queue(5); 
            
        queue.enqueue(10); 
        queue.enqueue(20); 
        queue.enqueue(30); 
        queue.enqueue(40); 
        queue.enqueue(40); 
        
        System.out.println(queue.dequeue() +  
                     " dequeued from queue\n"); 
        
        System.out.println("Front item is " +  
                               queue.front()); 
           
        System.out.println("Rear item is " +  
                                queue.rear()); 
    }
    
}
