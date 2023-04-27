/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1;
import java.util.*;
/**
 *
 * @author bfredett
 */
public class Lab1 {

    public static void main(String[] args) {
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
        System.out.print("Result for BFS: ");
        myGraph.doBFS(0);
        System.out.print("\n"+"Result for DFS: ");
        myGraph.doDFS(0);
        System.out.print("\n" + "Degree of vertex zero is: " + myGraph.degreeVertex(0) +"\n");
        myGraph.printAdjVertices(0);
    }
}
