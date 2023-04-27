/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P5;

/**
 *
 * @author benfredette
 */
import java.util.Scanner;

public class LISMain {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter input: ");
    String str = sc.nextLine();
    String[] nums = str.split(" ");
    int[] input = new int[nums.length];
    for(int i = 0; i < nums.length; i++){
        input[i] = Integer.parseInt(nums[i]);
    }
    LIS myLIS = new LIS();
    myLIS.lis(input);
    }
}
