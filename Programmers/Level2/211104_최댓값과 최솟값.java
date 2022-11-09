//https://programmers.co.kr/learn/courses/30/lessons/12939

class Solution {
    public String solution(String s) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        
        for (var substr : s.split(" ")){
            long num = Long.parseLong(substr);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        return min + " " + max;
    }
}