//https://programmers.co.kr/learn/courses/30/lessons/82612

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        for(int i=0; i<count; i++){
            answer += price * (i+1);
        }
        
        if(money > answer){
            answer = 0;
        }
        else{
            answer -= money;
        }
        
        return answer;
    }
}