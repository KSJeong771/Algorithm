//https://programmers.co.kr/learn/courses/30/lessons/12939

class Solution {
    public String solution(String s) {
        String answer = "";
        
        long max = -987654321;
        long min = 987654321;
        
        for(var subStr : s.split(" ")){
            long num = Long.parseLong(subStr);
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        
        answer = min + " " + max;
        return answer;
    }
}