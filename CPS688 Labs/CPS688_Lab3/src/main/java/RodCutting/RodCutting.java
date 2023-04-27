/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RodCutting;

/**
 *
 * @author benfredette
 */
import java.util.Scanner;

public class RodCutting {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter input>\n");
        // Take in rod size
        int n = sc.nextInt();
        // Array to store prices
        int[] prices = new int[n+1];
        //Get prices from input
        for(int i = 1; i <= n; i++){
            prices[i] = sc.nextInt();
        }
        // Array to store optimal revenue for ech subproblem
        int[] optrev = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int maxRevenue = Integer.MIN_VALUE;
            // Try all possible cuts for current subproblem
            for(int j = 1; j <= i; j++){
                maxRevenue = Math.max(maxRevenue, prices[j] + optrev[i - j]);
            }
            //Store optimal revenue for current subproblem
            optrev[i] = maxRevenue;
        }
        //Print solution to original problem
        System.out.println(optrev[n]);
    }
}
