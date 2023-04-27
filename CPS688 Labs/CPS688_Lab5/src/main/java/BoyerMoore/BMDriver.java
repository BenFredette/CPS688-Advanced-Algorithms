/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoyerMoore;

import java.util.Scanner;
/**
 *
 * @author benfredette
 */
public class BMDriver {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text:\n");
        String txt = sc.nextLine();
        System.out.print("Enter the pattern:\n");
        String pat = sc.nextLine();
        BoyerMoore bm = new BoyerMoore(pat);
        bm.printIndices(bm.search(txt));
    }
}
