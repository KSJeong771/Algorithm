//https://programmers.co.kr/learn/courses/30/lessons/12924

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            answer += isContiSum(i, n) ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean isContiSum(int num, int max){
        while(max > 0){
            max -= num;
            if(max == 0)
                return true;
            num++;
        }
        return false;
    }
}