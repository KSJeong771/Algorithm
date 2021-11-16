//https://programmers.co.kr/learn/courses/30/lessons/12981

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        HashMap<String, Integer> map = new HashMap();
        String before = words[0];
        map.put(before, 1);
        
        for(int i=1; i<words.length; i++){
            String current = words[i];
            
            if(map.get(current) != null){
                //중복체크 실패
                answer[0] = (i+1)%(n);
                if(answer[0] == 0)
                    answer[0] = n;
                
                answer[1] = i/n + 1;
                System.out.println("중복체크 실패 : " + current);
                return answer;
            }
            
            if(before.charAt(before.length()-1) != current.charAt(0)){
                //규칙 위반
                answer[0] = (i+1)%(n);
                if(answer[0] == 0)
                    answer[0] = n;
                
                answer[1] = i/n + 1;
                System.out.println("규칙 위반 : " + current + " i+1 : " + i+1 + " answer[1] : " + answer[1]);
                return answer;
            }
            
            map.put(words[i], 1);
            before = words[i];
        }

        return answer;
    }
}