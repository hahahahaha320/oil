package com.oolong.oil.algori.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private List<Integer>[] adj;
    

    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }
    public Graph(int V,List<Integer>[] adj) {
        this(V);
        for(int i=0;i<adj.length;i++)   {
            List<Integer> list = adj[i];
            if(list == null)    {
                continue;
            }
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()) {
                addEdge(i,iterator.next());
            }
        }
    }

    public Graph(Graph G) {
        this.V = G.V();
        this.E = G.E();
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");

        adj = new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    public List<Integer> adjBag(int v) {
        validateVertex(v);
        return adj[v];
    }
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        List<Integer>[] adj = new List[6];
        adj[0] = Arrays.asList(1,2);
        adj[1] = Arrays.asList(3);
        adj[2] = Arrays.asList(4,5);
        adj[3] = Arrays.asList(5);
        adj[4] = Arrays.asList(5);
        adj[5] = Arrays.asList();
        Graph graph = new Graph(6,adj);
        System.out.println(graph.toString());
    }
}
