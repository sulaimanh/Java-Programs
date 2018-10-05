/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ant;
	

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
	
/**
*
* @author sulaimanhamouda
*/

public class ant{

    public static void main(String[] args){
        // - n is the number of campuses
	// - h is the number of hills
	// - t is the number of tunnels
        // - x and y represent two ant hills the tunnel connects
	// - d represents the cost of digging this tunnel to connect them
        Scanner stdin = new Scanner(System.in);
        int x, y, d, h, t;    
        
        int n = stdin.nextInt();
        
        for(int i = 1; i <= n; i++){
            h = stdin.nextInt();
            t = stdin.nextInt();
            
            // - Here, we will make an array of type edge
            ArrayList<edge> edgeArray = new ArrayList<>();

            // - Here, we will read in all of the edges into the edge array
            for(int s = 0; s < t; s++){
                x = stdin.nextInt()-1;
                y = stdin.nextInt()-1;
                d = stdin.nextInt();
                // - We will enter x,y and d as new edges into the array
                edgeArray.add(new edge(x,y,d));
            }

            // - counter will be the value of the weight
            int counter = kruskal(edgeArray, h);
            
            // - If counter equals -1, then we were not able to connect the ant hills. Otherwise, we will print
            //      the value of the minimum weight
            if(counter == -1)
		System.out.println("Campus #" + i + ": I'm a programmer, not a miracle worker!");
            else
                System.out.println("Campus #" + i + ": " + counter);
        }
        stdin.close();
    }

    public static int kruskal(ArrayList<edge> edgeArray, int h){
	disjointset disjSet = new disjointset(h);
	int edgeCount = 0;
        int minSpanWeight = 0;
        int x = 0;
        int sizeOfedgeArray = edgeArray.size();
        
        // - Here, we will sort the edges with the smallest weight first
	Collections.sort(edgeArray);
        
        // - We will loop through until the edge count is one less then the amount of hills because that is 
        //       the maximum amount of tunnels we will need.
	while(edgeCount < h-1 && x < sizeOfedgeArray){
            // - We will attempt to put in this edge
            boolean check = disjSet.union(edgeArray.get(x).startVertex, edgeArray.get(x).endVertex);
            
            // - If check is true, then we will increment edgeCount by 1 and we will add the weight to 
            //      the minSpanWeight.
            if(check){
		edgeCount++;
		minSpanWeight += edgeArray.get(x).weight;
            }
            // - Here, we will move on to next edge in the ArrayList
            x += 1;
	}
        
        // - If edgeCount is less then the amount of hills minus 1, then we do not have enough tunnels
	if (edgeCount < h-1) 
            return -1;
        
        // - minSpanWeight will have the minimum amount of weight to connect the tunnels
	return minSpanWeight;
    }
}

class disjointset{

    public int[] parents;
    public int[] heights;

    public disjointset(int h){
        parents = new int[h];
	heights = new int[h];
	for (int i = 0; i < h; i++)
            parents[i] = i;
    }
    
    public int find(int node){
	if (parents[node] == node) 
            return node;
        // - We will keep calling find until we find the correct node.
	return find(parents[node]);
    }

    public boolean union(int x, int y){
	int parent1 = find(x);
	int parent2 = find(y);
        
        // - Here, we will check if parent1 and parent2 are the same
	if(parent1 == parent2) 
            return false;

        // - Which ever tree is shorter, then we will connect it to the longer one
        // - If heights are equal, then we will just add 1 to the height
        if (heights[parent1] < heights[parent2])
            parents[parent1] = parent2;
        else if (heights[parent2] < heights[parent1])
            parents[parent2] = parent1;
        else {
            parents[parent1] = parent2;
            heights[parent2]++;
        }

        return true;
    }
}

class edge implements Comparable<edge>{

    public int startVertex;
    public int endVertex;
    public int weight;

    public edge(int sV, int eV, int w){
	startVertex = sV;
	endVertex = eV;
	weight = w;
    }

    @Override
    public int compareTo(edge other){
	return this.weight - other.weight;
    }
}