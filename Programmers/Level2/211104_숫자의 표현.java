//https://programmers.co.kr/learn/courses/30/lessons/12924

class Solution {
    public int solution(int n) {
        // 자기 자신을 항상 포함한다.
        int answer = 1;
        
        // 절반보다 큰 값부터 시작한 연속된 값은
        // 절대 자기 자신이 될 수 없다.
        for (int i=1; i<(n+1)/2; i++) {
            int sum = i;
            
            // 연속된 값 더하기
            int next = i + 1;
            while (sum < n) {
                sum += next;
                next++;
            }
            
            // 연속된 값의 합이 자기 자신이 된다.
            if (sum == n) {
                answer++;
            }
        }
        
        return answer;
    }
}