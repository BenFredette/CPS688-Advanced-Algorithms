/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cps688_lab2;

import java.util.Scanner;

/**
 *
 * @author benfredette
 */
public class NQDriver {
        public static void main(String[] args){
        
        System.out.println("Input board size as an integer.");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        NQueens nq = new NQueens(N);
        nq.solveNQ(nq.board);
    }
}
