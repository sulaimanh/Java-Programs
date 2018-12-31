/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sulaimanhamouda
 */
// - Binary Search Tree Big O:
//      Search: 
//                  Worst Case is O(n)
//                  Average Case is O(n log n)
//      Insertion: 
//                  Worst Case is O(n)
//                  Average Case is O(n log n)
//      Deletion: 
//                  Worst Case is O(n)
//                  Average Case is O(n log n)
public class Tree {
    
    public class Node {
        // - This is the Node class
        // - Each node has a value and a left and right child
    
    
        int value;
        Node left, right;
        
        public Node(int item){
            value = item;
            left = right = null;
        }
    }
    
    Node root;
    
    // - This is a constructor for just 
    public Tree(){
        root = null;
    }
    
    public static void main(String[] args) {
        Tree binSearchTree = new Tree();

        binSearchTree.root = binSearchTree.insertion(binSearchTree.root, 50);
        binSearchTree.root = binSearchTree.insertion(binSearchTree.root, 30);
        binSearchTree.root = binSearchTree.insertion(binSearchTree.root, 20);
        binSearchTree.root = binSearchTree.insertion(binSearchTree.root, 40);
        binSearchTree.root = binSearchTree.insertion(binSearchTree.root, 70);
        binSearchTree.root = binSearchTree.insertion(binSearchTree.root, 60);
        binSearchTree.root = binSearchTree.insertion(binSearchTree.root, 80);
        
        
        System.out.println(binSearchTree.depthOfTree(binSearchTree.root));
    }

    // - Here, we will find the depth of the Binary Search Tree
    public int depthOfTree(Node node){
        if(node == null)
            return 0;

        int left = depthOfTree(node.left);
        int right = depthOfTree(node.right);
        
        if(left > right)
            return left + 1;
        else
            return right + 1;
    }
    
    
    // - Recursive function for inserting into a binary tree
    public Node insertion(Node node, int value){
        // - If the node is null, then we will create a new node and return it
        if(node == null){
            node = new Node(value);
            return node;
        }
        
        // - This is how we insert the node into the right spot
        if(node.value < value)
            node.right = insertion(node.right, value);
        else
            node.left = insertion(node.left, value);
        
        // - Return the unchanged node
        return node;
    }
    
    // - Here, we will delete the selected Node
    public Node deletion(Node node, int value){
        // - If the tree is empty
        if(node == null)
            return node;
        
        // - These if statements will go all the way down to the node to be deleted
        // - When we reach the node that needs to be deleted, we will replace it with the node in its
        //       right subtree which is the least value. 
        if(node.value < value)
            node.right = deletion(node.right, value);
        else if(node.value > value)
            node.left = deletion(node.left, value);
        else{
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;
            
            // - Here, we will traverse down the deleted nodes right subtree until we get the least value
            node.value = minValue(node.right);
            // - After we get that value, we will then set the value we took from the right subtree to null
            node.right = deletion(node.right, node.value);
        }
        
        
        return node;
    }
    
    // - This will traverse down the right nodes left children in order to get the least value;
    int minValue(Node node){ 
        
        int minv = node.value;
        // - We will keep going down until we reach the smallest left node in the tree
        while (node.left != null) { 
            minv = node.left.value; 
            node = node.left; 
        } 
        return minv; 
    } 
    
    
    
    // - Depth First Traversal
    // -  Visit the nodes in ascending order
    public void inOrderTraversal(Node node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.println(node.value);
            inOrderTraversal(node.right);
        }
    }
    
    // - Depth First Traversal
    // - The root is always the first node visited
    public void preOrderTraversal(Node node){
        if(node != null){
            System.out.println(node.value);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    
    // - Depth First Traversal
    // - The root is always teh last node visited
    public void postOrderTraversal(Node node){
        if(node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.value);
        }
    }
    
}
