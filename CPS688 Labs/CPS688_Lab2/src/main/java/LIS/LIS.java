/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIS;

/**
 *
 * @author benfredette
 */
import java.util.*;

public class LIS {
    public void lis(int[] input){
        //Create array B containing unique elements of A in order
        Set<Integer> set = new HashSet<>();
        for(int num : input){
            set.add(num);
        }
        int[] b = new int[set.size()];
        int i = 0;
        for(int num: set){
            b[i++] = num;
        }
        Arrays.sort(b);
        
        //Find the LCS of A and B using dynamic programming
        int n = input.length;
        int m = b.length;
        int[][] dpg = new int[n+1][m+1];
        for(i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(input[i-1] == b[j-1]){
                    dpg[i][j] = dpg[i-1][j-1] + 1;
                }else{
                    dpg[i][j] = Math.max(dpg[i-1][j], dpg[i][j-1]);
                }
            }
        }
        
        //Get LCS from dpg array and print LIS
        List<Integer> lis = new ArrayList<>();
        i = n; //length of input 
        int j = m; //length of B
        while(i > 0 && j > 0){
            if(input[i-1] == b[j-1]){
                lis.add(0, input[i-1]);
                i--;
                j--;             
            }else if(dpg[i-1][j] >= dpg[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        
        System.out.println("LIS = " + lis.size());
        System.out.print("LIS is: ");
        for(int num: lis){
            System.out.print(num + " ");
        }
    }
}
