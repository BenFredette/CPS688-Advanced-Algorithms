/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NQueens;

/**
 *
 * @author benfredette
 */
import java.util.Arrays;
public class NQueens {
    
    int N;
    int board[][];
    public NQueens(int N){
        this.N = N;
        this.board = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(this.board[i], 0);
        }
    }
    
    public boolean canPlace(int board[][], int row, int col){
        //Check row and column for queen
        for(int i = 0; i < this.N; i++){
            if(this.board[i][col] == 1 || this.board[row][i] == 1){
                return false;
            }
        }
        //Check diagonals
        //up and left
        for(int i = row, j = col; (i >= 0 && j >= 0); i--, j--){
            if(this.board[i][j] == 1){
                return false;
            }
        }
        //up and right
        for(int i = row, j = col; (i >= 0 && j < this.N); i--, j++){
            if(this.board[i][j] == 1){
                return false;
            }
        }
        //down and left
        for(int i = row, j = col; (i < this.N && j >= 0); i++, j--){
            if(this.board[i][j] == 1){
                return false;
            }
        }
        
        //down and right
        for(int i = row, j = col; (i < this.N && j < this.N); i++, j++){
            if(this.board[i][j] == 1){
                return false;
            }
        }
        return true;
    }
    
    public boolean NQRecurs(int board[][], int col){
        //Base case ( If all queens have been placed, return true)
        if(col >= this.N){
            return true;
        }
        
        //Try placing queen in this column one by one
        for(int i = 0; i < this.N; i++){
            if(canPlace(board, i, col)){
                //Place queen on board at i,col
                this.board[i][col] = 1;
                //Recursion to place rest of queens on board
                if(NQRecurs(board,col + 1) == true){
                    return true;
                }
                
                //If queen at [i][col] does not lead to solution, remove queen
                this.board[i][col] = 0; //<- Backtracking
            }
        }
        //Return false if queen cannot be placed in any row of this column
        return false;
    }
    
    public void printBoard(int board[][]){
        for(int i = 0; i < this.N; i++){
            for(int j = 0; j < this.N; j++){
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    //Solve the NQ problem using helper methods
    public boolean solveNQ(int board[][]){
        if(NQRecurs(board, 0) == false){
            System.out.println("There is no solution to this problem");
                    return false;
        }
      
        printBoard(board);
        return true;
    }   
}
