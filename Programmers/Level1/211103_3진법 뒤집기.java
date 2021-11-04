//https://programmers.co.kr/learn/courses/30/lessons/68935

import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        LinkedList<Integer> lst = new LinkedList();
        while(n >= 3){
            lst.add(n%3);
            n /= 3;
        }
        lst.add(n);
        
//         for(Integer nn : lst)
//            System.out.print(nn);
        
//         System.out.println();
        
        int num = 1;
        for(int i=lst.size()-1; i>=0; i--){
            // System.out.println("i : " + i + " lst.get(i) : " + lst.get(i) + " num : " + num);
            answer += lst.get(i) * num;
            num *= 3;
        }
        
        return answer;
    }
}