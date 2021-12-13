//https://programmers.co.kr/learn/courses/30/lessons/12914

class Solution {
    public long solution(int n) {
        long[] memo = new long[2001];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        
        for(int i=3; i<=n; i++){
            memo[i] = (memo[i-2] + memo[i-1]) % 1234567L;
        }
        
        return memo[n];
    }
}