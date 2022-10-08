//https://school.programmers.co.kr/learn/courses/30/lessons/12923

import java.util.*;

class Solution {
    public long[] solution(long begin, long end) {
        int length = (int)(end-begin) + 1;
        long[] answer = new long[length];
        
        Arrays.fill(answer, 1);
        
        // 자신을 제외한 약수 중 가장 큰 것
        for (long num = begin; num <= end; num++) {
            int index = (int)(num-begin);
            
            for (int i=2; i<=(int)Math.sqrt(num); i++) {
                if (num % i != 0) continue;
                if (num / i > 10000000) continue;
                
                answer[index] = num / i;
                break;
            }
        }
        
        if (begin == 1) {
            answer[0] = 0;
        }
        
        return answer;
    }
}