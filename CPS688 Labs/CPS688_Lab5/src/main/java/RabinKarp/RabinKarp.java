/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RabinKarp;

import java.math.BigInteger;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author benfredette
 */
//Class taken from slides with sligh modifications to suit needs of assignment
public class RabinKarp {
    private long patHash;   //pattern has value
    private int M;          //pattern length
    private long Q;         //modulus
    private int R;          //radix
    private long RM;        //R^(M-1) % Q
    String pat;             //Pattern
    
    public RabinKarp(String pat){
        M = pat.length();
        R = 256;
        Q = longRandomPrime();
        this.pat = pat;
        //Precompute R^M-1 (mod Q)
        RM = 1;
        for(int i = 1; i <= M-1; i++){
            RM = (R * RM) % Q;
        }
        patHash = hash(pat, M);
    }
    
    private long hash(String key, int M){
        long h = 0;
        for(int j = 0; j < M; j++){
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }
    
    //Check for hash collision using rolling hash function
    public ArrayList<Integer> search(String txt){
        ArrayList<Integer> indices = new ArrayList<>();
        int N = txt.length();
        long txtHash = hash(txt, M);
        if(patHash == txtHash) indices.add(0);
        for(int i = M; i < N; i++){
            txtHash = (txtHash + Q - RM*txt.charAt(i-M) % Q) % Q;
            txtHash = (txtHash*R + txt.charAt(i)) % Q; 
            if(patHash == txtHash) indices.add(i - M + 1); //This check makes this algortihm Las Vegas version
        }
        return indices;
    }
    
    //This method was copied form https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/RabinKarp.java
    // generates a random 31-bit prime number
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
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
