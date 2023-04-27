/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;
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
    //Return degree of vertex
    public int degreeVertex(int a){
        return adj[a].size();
    }
    //Print all adjacent vertices to vertex a
    public void printAdjVertices(int a){
        System.out.print("Adjacent vertices of vertex " +a +":" );
        for(int i = 0; i<adj[a].size(); i++){
            int temp = adj[a].get(i);
            System.out.print(" " + temp);
        }
    }
    //This method traverses the graph using BFS and outputs visited nodes
    public void doBFS(int start){
        boolean isVisited[] = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        
        //Set start node as visited
        isVisited[start] = true;
        queue.add(start);
        //set current node as value at front of queue and print
        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current +" ");
            //Add reachable nodes to queue
            for(int t : adj[current]){
                if(!isVisited[t]){
                    isVisited[t] = true;
                    queue.add(t);
                }
            }
        }
    }
    
    public void doDFS(int start){
        boolean isVisited[] = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();
        
        //Set start node as visited
        isVisited[start] = true;
        stack.push(start);
        
        //Loop until stack is empty, printing visited nodes in the process
        while(!stack.isEmpty()){
            int current = stack.pop();
            System.out.print(current + " ");
            //Loop through adjacent nodes, pushing them on top of the stack in the process
            for(int t: adj[current]){
                if(!isVisited[t]){
                    isVisited[t] = true;
                    stack.push(t);
                }
            }
        }
    }
}
