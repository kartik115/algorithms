package com.graph.learning.kartikeya;

import java.util.LinkedList;

public class Graph {
	int V;
	LinkedList<Integer> adjecencyList[];
	
	Graph(int v){
		this.V = v;
		this.adjecencyList = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adjecencyList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int a, int b){
		adjecencyList[a].add(b);
		adjecencyList[b].add(a);
	}
	
	public void printTree() {
		for(int i = 0; i < V; i++)
        {
            System.out.println("Adjacency list of vertex "+ i);
            System.out.print("head");
            for(Integer pCrawl: adjecencyList[i]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
	}
	
	// Driver program to test above functions
    public static void main(String args[])
    {
        // create the graph given in above figure
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
      
        // print the adjacency list representation of 
        // the above graph
        graph.printTree();
    }
}
