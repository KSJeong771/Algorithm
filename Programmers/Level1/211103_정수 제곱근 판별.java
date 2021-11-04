//https://programmers.co.kr/learn/courses/30/lessons/12934

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long number = 1;
        long doubled = 0;
        while(doubled < n){
            doubled = number * number;
            number++;
        }
        //System.out.println(max);
        
        if((number-1) * (number-1) != n){
            return -1;
        }else{
            return (number) * (number);
        }
        
        //return answer;
    }
}