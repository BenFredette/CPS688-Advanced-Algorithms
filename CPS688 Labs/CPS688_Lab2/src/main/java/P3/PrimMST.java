/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P3;

import java.util.Arrays;

/**
 *
 * @author benfredette
 */
import java.util.PriorityQueue;
public class PrimMST {
    
    public static void printMST(MSTGraph graph){
       int V = graph.getNumVertices();
       
       //Array to keep track of visited nodes
       boolean[] visited = new boolean[V];
       
       //Create PQ to keep trac of vertices and their weights
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
       
       //Array to keep track of parent of each vertex
       int[] parent = new int[V];
       Arrays.fill(parent, -1);
       
       //Array to keep track of minimum weight of each vertex
       int[] key = new int[V];
       Arrays.fill(key, Integer.MAX_VALUE);
       key[0] = 0;
       
       int mstWeight = 0;
       
       //Add first vertex to PQ
       pq.offer(new int[]{0, 0});
       
       //Do Prim's Algortithm
       while(!pq.isEmpty()){
           // Dequeue the vertex with minimum weight from PQ
           int[] curr = pq.poll();
           int u = curr[0];
           
           //If vertex is visited continue to next iteraton of loop
           if(visited[u] == true){
                continue;
           }
           
           //Mark vertex as visited and add its weight to MST
           visited[u] = true;
           mstWeight += key[u];
           
           //Check all adjacent vertices of the current vertex
           for(int v : graph.adj[u]){
               if(!visited[v] && graph.getWeight(u, v) < key[v]){
                   //If adjacent vertex is not visited and weight of the edge is less than the
                   //minimum weight of the vertex, update minimum weight and add vertex to PQ
                   key[v] = graph.getWeight(u, v);
                   pq.offer(new int[]{v, key[v]});
                   parent[v] = u;
               }
           }
           
       }
       
       //Print the MST
       for(int i = 1; i < V; i++){
           System.out.println("Edge " + parent[i] + "-" + i + " has a weight of " + graph.getWeight(parent[i], i));
       }
       //Print the total weight of MST
       System.out.println("MST = " + mstWeight);      
    }    
}
