/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author sulaimanhamouda
 * 
 * First in Last Out
 * Last in First Out
 * 
 * Push: Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
 * 
 * Pop: Removes an item from the stack. The items are popped in the reversed order in which they are pushed. 
            If the stack is empty, then it is said to be an Underflow condition.
 * 
 * Peek or Top: Returns top element of stack.
 * 
 * isEmpty: Returns true if stack is empty, else false.
 * 
 * 
 * 
 **** push(), pop(), isEmpty() and peek() all take O(1) time. We do not run any loop in any of these operations. ****
 * 
 * 
 * Implementation:
 *      There are two ways to implement a stack:
 *          - Using array
 *          - Using linked list
 * 
 */
public class Stack {

    // - Maximum size of stack
    int MAX;
    // - Top represents the top of the stack
    int top;
    int [] a;
    
    public Stack(int n){
        MAX = n;
        a = new int[MAX];
        top = -1;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack(5);
        // - Let us insert some values into our stack
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        // - Here, we will print the stack
        myStack.printStack();
        // - We will now peek into the stack without removing anything
        System.out.println("We are peeking into the stack: " + peek())
        // - We will now take out the element at the top of the stack
        System.out.println("Let us now pop something out of the stack: " + pop());
        // - We will now check if the stack is empty
        System.out.println("Is our stack empty? " + isEmpty());
        // - Here, we will print the stack
        myStack.printStack();
    }
    
    // - Here, we will check if the stack is empty or not
    public boolean isEmpty(){
        // - top starts at -1. This represents an empty stack
        return (top < 0);
    }
    
    // - Here, we will now insert values into our stack
    public boolean push(int x){
        if(top >= MAX-1){
            System.out.println("Stack Overflow");
            return false;
        }else{
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    // - Here, we will take values out of our stack
    public int pop(){
        if(top < 0){
            System.out.println("Stack Underflow");
            return 0;
        }else{
            int x = a[top--];
            // or we can say this
            // int x = peek();
            // top--;
            return x;
        }
    }
    
    // - Let us now just look whats at the top of our stack without taking anything out
    public int peek(){
        if(top < 0)
            return 0;
        return a[top];
    }
    
    // - Let us now print all of the contents that are in the stack
    public void printStack(){
        if(this.isEmpty())
            return;
        System.out.println(this.pop());
        printStack();
    }
}
