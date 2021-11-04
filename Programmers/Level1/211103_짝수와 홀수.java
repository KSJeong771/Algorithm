//https://programmers.co.kr/learn/courses/30/lessons/12937

class Solution {
    public String solution(int num) {
        String answer = "";
        answer = num%2==0 ? "Even" : "Odd";
        return answer;
    }
}