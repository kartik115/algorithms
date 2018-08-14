package graph.learning.kartikeya;

import java.util.Iterator;
import java.util.LinkedList;

public class DirectedGraph {
	int v;
	LinkedList<Integer> adj[];
	DirectedGraph(int v){
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			this.adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	void dfsUtil(int l, boolean visited[]) {
		visited[l] = true;
		System.out.println(l+" ");
		Iterator<Integer> i = adj[l].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				dfsUtil(n, visited);
			}
		}
	}
	
	void dfs(int s){
		boolean visited[] = new boolean[v];
		dfsUtil(s, visited);
	}
	
	public static void main(String args[]) {
		DirectedGraph g = new DirectedGraph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.dfs(2);
	}
}
