//https://programmers.co.kr/learn/courses/30/lessons/12945

class Solution {
    public long solution(int n) {
        long answer = 0;
        
        long[] fibo = new long[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        long div = 1234567;
        
        for(int i=2; i<=n; i++){
            fibo[i] = (fibo[i-1] + fibo[i-2]) % div;
            //System.out.println(i + " : " + fibo[i]);
        }
        
        answer = fibo[n];
        return answer;
    }
}