//https://programmers.co.kr/learn/courses/30/lessons/42747#

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
               
        for(int i=citations[citations.length-1]; i>= 0; i--){
            int right=0;
            int h = i;
            
            for(int j=citations.length-1; j>= 0; j--){
                if(citations[j] >= i) right++;
            }
            
            //System.out.println("h : " + h + " left : " + left + " right : " + right);
            if(h <= right)
                return h;
        }
        
        return answer;
    }
}