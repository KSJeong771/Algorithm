//https://programmers.co.kr/learn/courses/30/lessons/42578#

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap();
        for(var cloth : clothes){
            if(map.get(cloth[1]) != null)
                map.put(cloth[1], map.get(cloth[1])+1);
           else
                map.put(cloth[1], 1);
        }
        
        for(var m : map.entrySet()){
            answer *= m.getValue()+1;
        }
        answer--;
        
        return answer;
    }
}