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
import java.util.*;

public class MaxBipartiteMatching {
    private int[][] graph;
    private int[] parent;
    private boolean[] visited;

    public int maxMatching(int[][] graph) {
        this.graph = graph;
        int M = graph.length; // number of applicants
        int N = graph[0].length; // number of jobs
        int[] match = new int[N]; // stores the job assigned to each applicant (-1 if unassigned)
        Arrays.fill(match, -1); // initially all jobs are unassigned

        for (int u = 0; u < M; u++) {
            parent = new int[N];
            Arrays.fill(parent, -1); // initially all jobs are unvisited
            visited = new boolean[N];

            // find an augmenting path starting from this applicant
            if (dfs(u, match)) {
                // if an augmenting path is found, update the matching
                int v;
                for (v = 0; v < N; v++) {
                    if (visited[v] && match[v] == -1) {
                        match[v] = u;
                        break;
                    }
                }
                if(v == N) {
                    // If we reach here, then no job was assigned to the current applicant.
                    // We set the match back to -1 to mark that the applicant is unassigned.
                    match[u] = -1;
                }
            }
        }

        int maxMatching = 0;
        for (int v = 0; v < N; v++) {
            if (match[v] != -1) {
                maxMatching++;
            }
        }
        return maxMatching;
    }


    private boolean dfs(int u, int[] match) {
        for (int v = 0; v < graph[0].length; v++) {
            if (graph[u][v] == 1 && !visited[v]) {
                visited[v] = true;
                if (match[v] == -1 || dfs(match[v], match)) {
                    parent[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
}

