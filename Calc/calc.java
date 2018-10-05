/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author sulaimanhamouda
 */
public class calc {
    
    // - n specifies the number of input cases
    // - a is the additive constant
    // - b is the multiplicative constant 
    // - c is the division constant
    // - t is the target value
    public static int n, a, b, c, t;
    
    public static void main(String[] args){
        
        Scanner stdin = new Scanner(System.in);
        n = stdin.nextInt();
        
        // - Here, we will set up the BFS
        for(int i = 0; i < n; i++){
            a = stdin.nextInt();
            b = stdin.nextInt();
            c = stdin.nextInt();
            t = stdin.nextInt();
            
            Queue<Integer> link = new LinkedList<>();
            int[] adj = new int[1000000];
            
            // - Here, we will fill the entire array with -1
            Arrays.fill(adj, -1);
            
            adj[0] = 0;
            
            link.add(0);
            
            // - This is where we will perform the BFS and we will store the answer into 
            int fin = performBFS(link, adj);
            
            // - Here, we will print the answer
            System.out.println(fin);
        }
    }
    
    public static int performBFS(Queue<Integer> link, int [] adj){
        while(!link.isEmpty()){

            // - If this evaluates to true, then we have found our answer
            if(adj[t] != -1)
                break;
            
            // - Here, we will get the next item
            int next = link.poll();

            // - Here, we will perform each operation and store them
            ArrayList<Integer> neigh = new ArrayList<>();
            neigh.add((next+a)%1000000);
            neigh.add((next*b)%1000000);
            neigh.add(next/c);

            // - If it has not been visited, then mark it and queue it
            for(int j = 0; j < neigh.size(); j++){
                if(adj[neigh.get(j)] == -1){
                    link.add(neigh.get(j));
                    adj[neigh.get(j)] = adj[next] + 1;
                }
            }
        }
        
        // - We will return the value
        return adj[t];
    }
    
}
