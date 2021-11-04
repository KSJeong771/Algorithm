//https://programmers.co.kr/learn/courses/30/lessons/42576

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hmap = new HashMap();
        for(var part : participant){
            Integer num = hmap.get(part);
            if (num != null){
                hmap.put(part, ++num);
            }
            else{
                hmap.put(part, 1);
            }
        }
        
        for(var comp : completion){
            Integer num = hmap.get(comp);
            if (num != null)
                hmap.put(comp, --num);
        }
        
        for(var kv : hmap.entrySet()){
            //System.out.println(kv.getKey() + " : " + kv.getValue());
            if (kv.getValue() > 0){
                answer = kv.getKey();
            }
        }
        
        return answer;
    }
}