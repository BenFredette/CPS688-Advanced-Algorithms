/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P4;

/**
 *
 * @author benfredette
 */
import java.util.Scanner;

public class KSDriver {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Input:\n");
        int n, W;
        n = sc.nextInt();
        int v[] = new int[n];
        int w[] = new int[n];
        //Fill arrays with input
        for(int i = 0; i < n; i++){
            v[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            w[i] = sc.nextInt();
        }
        
        W = sc.nextInt();
        
        KnapSackNR KS = new KnapSackNR(v, w, W);
        int output = KS.SolveKS();
        System.out.println(output);  
    }
}
