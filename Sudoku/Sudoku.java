/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.util.Scanner;
/**
 * @author sulaimanhamouda 
 *  
 */
public class Sudoku {
    
    public static void main(String[] args) {
        int n, i, j = 1;
        int [] puzzle = new int[81];
        
        Scanner stdin = new Scanner(System.in);
        // - n is the number of sudoku puzzles we need to solve
        n = stdin.nextInt();
        
        // - In this loop, you will run through n sudoku puzzles
        while(n != 0){
            System.out.printf("Test Case %d\n", j);
            
            // - Putting Suduko puzzle into an array
            for(i = 0; i < 81; i++)
                puzzle[i] = stdin.nextInt();
            
            // - If this evaluates to true, then you will print the solved sudoku puzzle. If not, then "no solution possible"
            if(solve(puzzle, 0) == true){
                print(puzzle);
                System.out.println("");
            }
            else 
                System.out.println("No solution possible.");
            n--;
            j++;
            System.out.println("\n");
        }
    }
    
    // - In this function you will solve the Sudoku puzzle
    public static boolean solve(int [] puzzle, int indexWeAreOn){
        int num;
        
        // - If we are on index 81, then we will stop and return true, because the whole board has been filled.
        if(indexWeAreOn == 81) {
            return true;
        }
        // - If the index we are on does not equal zero, then we will move on to the next index.
        if(puzzle[indexWeAreOn]!= 0){
            return solve(puzzle,indexWeAreOn+1);
        }
        
        // - Here, we will see if we can insert num into the empty index we are on
        for(num = 1; num <= 9; num++){
            // - if it is safe to insert, then we will insert num into that index
            if(isSafeToInsert(puzzle, indexWeAreOn, num)){
                puzzle[indexWeAreOn] = num;
                
                if(solve(puzzle, indexWeAreOn+1))
                    return true;
                else
                    puzzle[indexWeAreOn] = 0;
            }
        }
        return false;
    }
    
    // - In this method, you completed looking through each row and column and 3x3 square
    public static boolean isSafeToInsert(int [] puzzle, int indexWeAreOn, int num){
        return checkColumn(puzzle, indexWeAreOn, num) && checkRow(puzzle, indexWeAreOn, num) && checkBox(puzzle, indexWeAreOn, num);
    }
    
    // - Here, you will check the column
    public static boolean checkColumn(int [] puzzle, int indexWeAreOn, int num){
        for(int i = 0; i < 9; i++){
            // - Column
            // - This will help you go through the whole column
            if(puzzle[(i*9) + (indexWeAreOn % 9)] == num)
                return false;
        }
        return true;
    }
        
    // - Here, you will check the row
    public static boolean checkRow(int [] puzzle, int indexWeAreOn, int num){
         for(int i = 0; i < 9; i++){
            // - Row
            // - This will help you go through the whole row 
            if(puzzle[(indexWeAreOn - (indexWeAreOn % 9)) + i] == num)
                return false;
        }
         return true;
     }
     
    // - Here, you will check the 3x3 box
    public static boolean checkBox(int [] puzzle, int indexWeAreOn, int num){
        int index, i, j;
        
        // - index will be the top left index of each index
        index = (indexWeAreOn - (indexWeAreOn % 3)); 
        index = index - (9*((index/9)%3));
        
        // - here, you will check each 3x3 box
        for(i = 0; i < 3; i++){
            for(j = 0; j < 3; j++){
                
                if(puzzle[index] == num) return false;
               
                // - If j = 2, then you will increment the index by 7 so you can go to the next index, which is on the next row.
                if(j == 2) index += 7;
                else index++;
            }
        }
        return true;
    }
    
    // - In this function, you will print the board.
    public static void print(int [] puzzle){
        int i, j;
        for(i = 0; i < 81; i++){
            if(i%9 == 0) System.out.println("");
            
            System.out.print(puzzle[i]+" ");
        }
    }
}