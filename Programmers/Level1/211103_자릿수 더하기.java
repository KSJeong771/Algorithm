//https://programmers.co.kr/learn/courses/30/lessons/12931

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        long div = 100000000;
        while(n > 0){
            answer += n / div;
            n %= div;
            div /= 10;
        }
        return answer;
    }
}