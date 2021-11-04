//https://programmers.co.kr/learn/courses/30/lessons/12930

import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] ch = s.toCharArray();
        boolean isEven = false;
        for(int i=0; i<ch.length; i++){
            isEven = !isEven;
            if (ch[i] == ' ')
                isEven = false;
            
            if (isEven)
                ch[i] = Character.toUpperCase(ch[i]);
            else
                ch[i] = Character.toLowerCase(ch[i]);
        }
        
        answer = new String(ch);
        return answer;
    }
}