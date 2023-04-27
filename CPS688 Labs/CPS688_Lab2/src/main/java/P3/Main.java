/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P3;

import java.util.Scanner;

/**
 *
 * @author benfredette
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Provide Input:\n");
       
        //get integers n(# of vertices) and e(# of edges) from input
        int n = sc.nextInt();
        int e = sc.nextInt();
        //Create Graph Object
        MSTGraph myGraph = new MSTGraph(n);
        //add edges to graph from remainder of input
        for(int i = 0; i < e; i++){
            myGraph.addEdges(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        
        PrimMST.printMST(myGraph);   
    }
}
