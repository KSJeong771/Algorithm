//https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap();
        for (int i=0; i<9; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        for (int i=9; i<discount.length; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            if (isSatisfied(want, number, map)) {
                answer++;
            }
            
            map.put(discount[i-9], map.get(discount[i-9]) - 1);
        }
        
        return answer;
    }
    
    public boolean isSatisfied(String[] want, int[] number, Map<String, Integer> map) {
        // for (int i=0; i<want.length; i++) {
        //     System.out.print(want[i] + ":" + map.getOrDefault(want[i], 0) + " ");
        // }
        // System.out.println();
        
        for (int i=0; i<want.length; i++) {
            if (map.getOrDefault(want[i], 0) < number[i]) {
                return false;
            }
        }
        return true;
    }
}