//https://programmers.co.kr/learn/courses/30/lessons/17679

import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        final char EMPTY = '-';
        ArrayList<ArrayList<Character>> rotatedBoard = rotateBoard(m, n, board);
        
        int squareCount;
            
        do{
            squareCount = 0;
            int[][] memo = new int[n][m];

            for(int i=0; i<n-1; i++){
                var c1 = rotatedBoard.get(i);
                var c2 = rotatedBoard.get(i+1);
                for(int j=0; j<m-1; j++){
                    if(c1.get(j) == EMPTY) continue;
                    if(c2.get(j) == EMPTY) continue;
                    if(c1.get(j) != c1.get(j+1)) continue;
                    if(c2.get(j) != c2.get(j+1)) continue;
                    if(c1.get(j) != c2.get(j)) continue;
                    if(c1.get(j+1) != c2.get(j+1)) continue;
                                           
                    memo[i][j] = 1;
                    memo[i][j+1] = 1;
                    memo[i+1][j] = 1;
                    memo[i+1][j+1] = 1;
                }
            }

            for(int i=0; i<n; i++){
                for(int j=m-1; j>=0; j--){
                    if(memo[i][j] == 0)
                        continue;
                    
                    rotatedBoard.get(i).remove(j);
                    rotatedBoard.get(i).add(EMPTY);
                    squareCount++;
                }
            }
            
            answer += squareCount;
            //printBoard(rotatedBoard);
                       
        }while(squareCount > 0);
        
        return answer;
    }
    
    public ArrayList<ArrayList<Character>> rotateBoard(int m, int n, String[] board){
        ArrayList<ArrayList<Character>> rotatedBoard = new ArrayList<ArrayList<Character>>();
        
        for(int column=0; column<n; column++){
            ArrayList<Character> arr = new ArrayList<Character>();
            for(int row=m-1; row>=0;row--){
                arr.add(board[row].charAt(column));
            }
            rotatedBoard.add(arr);
        }
        
        return rotatedBoard;
    }
    
    public void printBoard(ArrayList<ArrayList<Character>> rotatedBoard){
        for(var r : rotatedBoard){
            for(var c : r){
                System.out.print(c + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}