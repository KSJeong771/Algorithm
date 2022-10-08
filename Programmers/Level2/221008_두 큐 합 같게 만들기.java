//https://school.programmers.co.kr/learn/courses/30/lessons/118667

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Long sumQ1 = 0L;
        Long sumQ2 = 0L;
        Queue<Long> Q1 = new LinkedList();
        Queue<Long> Q2 = new LinkedList();
        for (int i=0; i<queue1.length; i++) {
            sumQ1 += (long)queue1[i];
            Q1.add((long)queue1[i]);
        }
        for (int i=0; i<queue2.length; i++) {
            sumQ2 += (long)queue2[i];
            Q2.add((long)queue2[i]);
        }
        
        int count = 0;
        do {
            if (sumQ1 < sumQ2) {
                var element = Q2.poll();
                Q1.add(element);
                sumQ1 += element;
                sumQ2 -= element;
            } else if (sumQ1 > sumQ2) {
                var element = Q1.poll();
                Q2.add(element);
                sumQ1 -= element;
                sumQ2 += element;
            } else {
                return count;
            }
            count++;
        } while (count < (queue1.length + queue2.length) * 9);
        
        return -1;   
    }
}