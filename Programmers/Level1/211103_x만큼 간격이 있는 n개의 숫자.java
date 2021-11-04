//https://programmers.co.kr/learn/courses/30/lessons/12954

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=1; i<=n; i++){
            answer[i-1] = (long)x*(long)i;
        }
        return answer;
    }
}