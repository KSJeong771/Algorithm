//https://programmers.co.kr/learn/courses/30/lessons/87389

class Solution {
    public int solution(int n) {
        int answer = -1;
        
        for(int i=2;i<n;i++){
            if((n%i) == 1)
                return i;
        }
        
        return answer;
    }
}