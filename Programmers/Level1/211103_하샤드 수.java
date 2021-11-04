//https://programmers.co.kr/learn/courses/30/lessons/12947

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        int temp = x;
        while(temp > 0){
            sum += temp % 10;
            temp /= 10;
        }
        
        answer = x % sum == 0;
        return answer;
    }
}