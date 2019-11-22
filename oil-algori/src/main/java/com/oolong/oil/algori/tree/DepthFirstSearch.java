package com.oolong.oil.algori.tree;

import java.util.Arrays;
import java.util.List;

public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        validateVertex(s);
        dfsNoRecursion(G, s);
    }

    //递归dfs
    private void dfs(Graph G, int v) {
        count++;
        marked[v] = true;
        System.out.println(" -> " + v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    private void accessVertex(int v) {
        count++;
        marked[v] = true;
        System.out.println(" -> " + v);

    }
    //非递归dfs
    private void dfsNoRecursion(Graph G, int v) {
        Stack<Integer> stack = new Stack<>();
        accessVertex(v);
        stack.push(v);
        while(!stack.isEmpty()) {
            int node = stack.peek();
            //对于栈顶元素，如果其关联顶点全部被访问过了，
            for (int w : G.adj(node)) {
                if (!marked[w]) {
                    accessVertex(w);
                    stack.push(w);
                    break;
                }
            }
            //没有新入栈元素，表示相连的顶点都访问过了,则出栈；
            if(node == stack.peek())    {
                stack.pop();
            }
        }
    }
    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    public int count() {
        return count;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Unit tests the {@code DepthFirstSearch} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        int V = 7;
        List<Integer>[] adj = new List[V];
        adj[0] = Arrays.asList(1,2);
        adj[1] = Arrays.asList(3);
        adj[2] = Arrays.asList(4,5,6);
        adj[3] = Arrays.asList(5);
        adj[4] = Arrays.asList(5);
        adj[5] = Arrays.asList();
        Graph graph = new Graph(V,adj);


        DepthFirstSearch search = new DepthFirstSearch(graph, 0);
        for (int v = 0; v < graph.V(); v++) {
            if (search.marked(v))
                System.out.print(v + " ");
        }

        System.out.println(" ");
        if (search.count() != graph.V()) System.out.println("NOT connected");
        else                         System.out.println("connected");
    }

}
