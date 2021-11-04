//https://programmers.co.kr/learn/courses/30/lessons/12912

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        for(int i=a; i<=b; i++) answer += i;
        for(int i=b; i<=a; i++) answer += i;
        return answer;
    }
}