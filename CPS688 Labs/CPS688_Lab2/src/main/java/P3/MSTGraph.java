/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P3;

import java.util.*;
/**
 *
 * @author benfredette
 */
public class MSTGraph {
    //Graph must have nodes defined from 0 to n-1 (n is # of nodes)
    private int numVertices;
    protected LinkedList<Integer>[] adj;
    protected int[][] weights;
    
    public MSTGraph(int numVertices){
        this.numVertices = numVertices;
        this.adj = new LinkedList[numVertices];
        this.weights = new int[numVertices][numVertices];
        //Instantiate each Linked List
        for(int i = 0; i < numVertices; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    //add edge between vertex a and b
    public void addEdges(int a, int b, int w){
        adj[a].add(b);
        adj[b].add(a);
        weights[a][b] = w;
        weights[b][a] = w;
    }
    
    public int getWeight(int a, int b){
        //for root node
        if(a == -1 || b == -1){
            return 0;
        }
        return weights[a][b];
    }
    
    public int getNumVertices(){
        return this.numVertices;
    }
            
}
