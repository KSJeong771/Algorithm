//https://programmers.co.kr/learn/courses/30/lessons/12933

import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        LinkedList<Long> list = new LinkedList();
        while(n > 0){
            list.add(n%10);
            n /= 10;
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        
        int mul = 1;
        for(int i=list.size()-1; i>=0; i--){
            answer += list.get(i) * mul;
            mul *= 10;
        }
        return answer;
    }
}