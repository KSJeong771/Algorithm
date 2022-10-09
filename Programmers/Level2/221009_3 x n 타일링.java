//https://school.programmers.co.kr/learn/courses/30/lessons/12902

class Solution {
    public long solution(int n) {
        long[] dp = new long[5000];
        dp[0] = 0;
        dp[1] = 3;
        dp[2] = 11;
        for (int i=3; i<n/2+1; i++) {
            dp[i] = (dp[i-1] * 3) + 2;
            for (int j=0; j<i-1; j++) {
                dp[i] += (dp[j] * 2);
            }
            dp[i] %= 1000000007L;
        }

//         for (int i=0; i<n/2+1; i++) {
//             System.out.print(dp[i] + " ");
//         }
        
        return dp[n/2];
    }
}