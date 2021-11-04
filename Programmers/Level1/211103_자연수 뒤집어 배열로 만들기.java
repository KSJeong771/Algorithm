//https://programmers.co.kr/learn/courses/30/lessons/12932

import java.util.*;
class Solution {
    public int[] solution(long n) {
        
        ArrayList<Long> ar = new ArrayList();
        while(n>0){
            ar.add(n%10);
            n /= 10;
            //System.out.println(n);
        }
        int[] answer = new int[ar.size()];
        for(int i=0; i<ar.size(); i++){
            answer[i] = (int)(long)(ar.get(i));
        }
        return answer;
    }
}