/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RabinKarp;

import java.util.Scanner;

/**
 *
 * @author benfredette
 */
public class RBDriver {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text:\n");
        String txt = sc.nextLine();
        System.out.print("Enter the pattern:\n");
        String pat = sc.nextLine();
        RabinKarp rk = new RabinKarp(pat);
        rk.printIndices(rk.search(txt));
    }    
}
