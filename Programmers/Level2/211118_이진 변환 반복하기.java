//https://programmers.co.kr/learn/courses/30/lessons/70129

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        int doCount = 0;
        int zeroCount = 0;
        while(true){
            int lengthBefore = s.length();
            //0 제거
            s = s.replace("0", "");
            int lengthAfter = s.length();
            
            zeroCount += (lengthBefore - lengthAfter);
            
            //남은 문자열 길이를 이진법으로
            s = Integer.toBinaryString(lengthAfter);
            
            doCount++;
            if(s.equals("1"))
                break;
        }
        
        answer[0] = doCount;
        answer[1] = zeroCount;
        
        return answer;
    }
}