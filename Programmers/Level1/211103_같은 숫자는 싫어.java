//https://programmers.co.kr/learn/courses/30/lessons/12906

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        boolean[] check = new boolean[arr.length];
        
        int count = arr.length;
        for(int i=1;i<arr.length; i++){
            if(arr[i] == arr[i-1]){
                check[i] = true;
                count--;
            }
        }
        
        answer = new int[count];
        int index = 0;
        for(int i=0; i<check.length; i++){
            if(!check[i])
                answer[index++] = arr[i];
        }
        
        
        return answer;
    }
}