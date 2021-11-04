//https://programmers.co.kr/learn/courses/30/lessons/64061

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack();
        int boardSize = board[0].length;
        
        for(int i=0; i<moves.length; i++){
            for(int j=0; j<boardSize; j++){
                int item = board[j][moves[i]-1];
                if (item != 0){
                    //for(Integer n : stack){
                    //    System.out.print(n);
                    //}
                    //    System.out.println();
                    if (!stack.isEmpty() && stack.peek().equals(item)){
                //System.out.println("item : " + item + ", x : " + (moves[i]-1) + ", y : " + j);
                        stack.pop();
                        answer++;
                        answer++;
                    }else{
                        stack.push(item);
                    }
                    
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}