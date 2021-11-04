//https://programmers.co.kr/learn/courses/30/lessons/12910

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList();
        for(int element : arr){
            if(element % divisor == 0)
                list.add(element);
        }
        
        answer = list.stream().mapToInt(i -> i).toArray();
        if(answer.length == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            Arrays.sort(answer);
        }
        
        return answer;
    }
}