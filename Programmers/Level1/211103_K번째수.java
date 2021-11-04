//https://programmers.co.kr/learn/courses/30/lessons/42748

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        //System.out.println(commands.length);
        for(int i=0; i<commands.length; i++){
            Integer[] newArr = new Integer[array.length];
            for(int j=0; j<array.length; j++){
                newArr[j] = array[j];
            }
            Arrays.sort(newArr, commands[i][0]-1, commands[i][1]);
            //for(int j=0; j<newArr.length; j++)
            //    System.out.print(newArr[j]);
            //System.out.println();
            answer[i] = newArr[commands[i][0]-1 + commands[i][2] - 1];
        }
        
        return answer;
    }
}