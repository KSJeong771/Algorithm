//https://programmers.co.kr/learn/courses/30/lessons/12952?language=java#

import java.util.*;

class Solution {
    int count = 0;
    
    public int solution(int n) {
        //모든 가로축 탐색
        for(int i=0; i<n; i++){
            int[][] visited = new int[n][n];
            findNext(0, i, visited.clone(), n);
        }
        
        return count;
    }
    
    public void findNext(int y, int x, int[][] visited, int n){
        int[] dx = {-1, 0, 1, 0, -1, 1, -1, 1};
        int[] dy = {0, -1, 0, 1, -1, 1, 1, -1};

        //퀸 범위 채우기
        visited[y][x] = 9;
        for(int k=0; k<8; k++){
            int nextX = x+dx[k];
            int nextY = y+dy[k];
            while(nextX < n && nextX >= 0 && nextY < n && nextY >= 0){
                if(visited[nextY][nextX] == 0) 
                    visited[nextY][nextX] = 1;
                nextX += dx[k];
                nextY += dy[k];
            }
        }
        
        //printBoard(visited);
        if(y+1 >= n)
        {
            //printBoard(visited);
            count++;
            return;
        }
        
        for(int i=0; i<n; i++){
            if(visited[y+1][i] == 0){
                findNext(y+1, i, copyBoard(visited), n);
            }
        }
    }
    
    public void printBoard(int[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public int[][] copyBoard(int[][] board){
        int[][] newBoard = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                newBoard[i][j] = board[i][j];
            }
        }
        
        return newBoard;
    }
}