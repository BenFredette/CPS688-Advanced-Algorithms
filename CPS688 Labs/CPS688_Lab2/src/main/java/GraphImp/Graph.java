/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphImp;

import java.util.*;
/**
 *
 * @author bfredett
 */
public class Graph {
    //Graph must have nodes defined from 0 to n-1 (n is # of nodes)
    private int numVertices;
    protected LinkedList<Integer>[] adj;
    
    public Graph(int numVertices){
        this.numVertices = numVertices;
        this.adj = new LinkedList[numVertices];
        //Instantiate each Linked List
        for(int i = 0; i < numVertices; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    //add edge between vertex a and b
    public void addEdges(int a, int b){
        adj[a].add(b);
        adj[b].add(a);
    }
    //Public interface for user to use
    public boolean isCyclic(){
        boolean[] visited = new boolean[numVertices];
        for(int i = 0; i < numVertices; i++){
            if(!visited[i]){
                if(isCyclic(i, visited, -1)){ //-if recursive calls return true, there is a cycle
                    return true;
                }
            }
        }
        return false;
    }
    //Recursive method that detects cycle in a graph that can be reached from vertex v
    //Uses BFS traversal
    //This method does not get called by the user, hence why it is private
    private boolean isCyclic(int v, boolean visited[], int parent){
        // mark the current node as visited
        visited[v] = true;
        
        for(int neighbor : adj[v]){
            if(!visited[neighbor]){
                if(isCyclic(neighbor, visited, v)){
                    return true;
                }
            } else if(neighbor != parent){
                //If a neighbor has been visited but is not the parent then 
                //we have detected a cycle
                return true;
            }
        }
        return false;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Provide Input:\n");
       
        //get integers n(# of vertices) and e(# of edges) from input
        int n = sc.nextInt();
        int e = sc.nextInt();
        //Create Graph Object
        Graph myGraph = new Graph(n);
        //add edges to graph from remainder of input
        for(int i = 0; i < e; i++){
            myGraph.addEdges(sc.nextInt(), sc.nextInt());
        }
        
        boolean hasCycle = myGraph.isCyclic();
        
        if(hasCycle){
            System.out.println("no");
        }else{
            System.out.println("yes");
        }
        
    }
}
