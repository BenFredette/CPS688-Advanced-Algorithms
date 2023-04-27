/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoyerMoore;

import java.util.ArrayList;
/**
 *
 * @author benfredette
 */
public class BoyerMoore {
    private String pat;
    private int[] right;
    
    public BoyerMoore(String pat){
        this.pat = pat;
        int M = pat.length();
        int R = 128; //Number of ASCCII chars
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1; // Initialize all values to -1
        }
        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j; // Store the rightmost occurrence of each character
        }        
    }
    
    //BM Implementation directly from lecture slides with slight modification to keep list of indices
    public ArrayList<Integer> search(String txt){
        ArrayList<Integer> indices = new ArrayList<>();
        int N = txt.length();
        int M = pat.length();
        int skip;
        for(int i = 0; i <= N-M; i += skip){
            skip = 0;
            for(int j = M-1; j >= 0; j--){
                if(pat.charAt(j) != txt.charAt(i+j)){
                    skip = Math.max(1, j - right[txt.charAt(i+j)]);
                    break;
                }
            }
            if(skip == 0){
                indices.add(i); //Add index to list of matches
                skip = 1; //Check rest of text for matches
            }
        }
        return indices;
    }
    
    public void printIndices(ArrayList<Integer> indices){
        int n = indices.size();
        if(n == 0){
            System.out.println("Pattern " +pat+" not found");
        }else if(n == 1){
            System.out.println("Pattern " +pat+" found at index "+indices.get(0));
        }else{
            String ind ="";
            for(int i = 0; i < n; i++){
                ind = ind+indices.get(i)+",";
            }
            String newind = ind.substring(0, ind.length() - 1);
            System.out.println("Pattern "+pat+" found at indices "+newind );
        }
    }
    
}
