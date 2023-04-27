/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cps688_lab4;

/**
 *
 * @author benfredette
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxBipartiteMatchingMain {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

    // read input matrix from command line
    List<String> lines = new ArrayList<>();
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            break;
        }
        lines.add(line);
    }
    
    // convert input to 2D array
    int numRows = lines.size();
    int numCols = lines.get(0).split(" ").length;
    int[][] graph = new int[numRows][numCols];
    for (int i = 0; i < numRows; i++) {
        String[] values = lines.get(i).split(" ");
        for (int j = 0; j < numCols; j++) {
            graph[i][j] = Integer.parseInt(values[j]);
        }
    }
    for (int i = 0; i < numRows; i++) {
    for (int j = 0; j < numCols; j++) {
        System.out.print(graph[i][j] + " ");
    }
    System.out.println();
}
        MaxBipartiteMatching mbm = new MaxBipartiteMatching();
        int maxMatching = mbm.maxMatching(graph);
        System.out.println("The maximum number of applicants matching for the jobs is " + maxMatching);
    }
}
      /*int [][] graph2 = {
        {0,1,1,0,0,0},
        {0,0,0,0,0,0},
        {1,0,0,1,0,0},
        {0,0,1,0,0,0},
        {0,0,1,1,0,0},
        {0,0,0,0,0,1}
    }; */