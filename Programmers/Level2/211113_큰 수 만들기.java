//https://programmers.co.kr/learn/courses/30/lessons/42883#

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        
        int length = sb.length();
        
        while(k-- > 0){
            int i = 0;
            for(; i<length-1; i++){
                if(sb.charAt(i) < sb.charAt(i+1))
                    break;
            }
            
            length--;
            sb.deleteCharAt(i);
        }
        
        return sb.toString();
    }
}