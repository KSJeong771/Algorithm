//https://programmers.co.kr/learn/courses/30/lessons/12900

class Solution {
    public int solution(int n) {
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        for(int i=3; i<=n; i++){
            memo[i] = (memo[i-2] + memo[i-1]) % 1000000007;
        }
        
        return memo[n];
    }
}