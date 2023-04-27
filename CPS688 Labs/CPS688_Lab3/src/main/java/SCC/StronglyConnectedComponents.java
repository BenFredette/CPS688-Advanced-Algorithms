/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCC;

/**
 *
 * @author benfredette
 */
import java.util.*;

public class StronglyConnectedComponents {
    private int numVertices;
    private LinkedList<Integer>[] adj;
 
    public StronglyConnectedComponents(int numVertices) {
        this.numVertices = numVertices;
        adj = new LinkedList[numVertices];
        for(int i = 0; i < numVertices; ++i)
            adj[i] = new LinkedList();
    }
 
    // add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
 
    // returns reverse (or transpose) of the graph
    private StronglyConnectedComponents getTranspose() {
        StronglyConnectedComponents g = new StronglyConnectedComponents(numVertices);
        for (int v = 0; v < numVertices; v++) {
            for (int i = 0; i < adj[v].size(); i++) {
                g.adj[adj[v].get(i)].add(v);
            }
        }
        return g;
    }
 
    // DFS traversal of the vertices reachable from v
    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
 
    // check if the graph is strongly connected
    public boolean isStronglyConnected() {
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(visited, false);
 
        // DFS traversal from the first vertex
        DFSUtil(0, visited);
 
        // if any vertex is not reachable, then the graph is not strongly connected
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }
 
        // get the transpose of the graph
        StronglyConnectedComponents g = getTranspose();
 
        // mark all the vertices as not visited
        Arrays.fill(visited, false);
 
        // DFS traversal of the reversed graph from the same starting vertex
        g.DFSUtil(0, visited);
 
        // if any vertex is not reachable, then the graph is not strongly connected
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }
 
        return true;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int e = sc.nextInt();
 
            StronglyConnectedComponents g = new StronglyConnectedComponents(n);
 
            for (int i = 0; i < e; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                g.addEdge(a, b);
            }
 
            if (g.isStronglyConnected()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

