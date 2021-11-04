//https://programmers.co.kr/learn/courses/30/lessons/12918

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() != 4 && s.length() != 6)
            return false;
        for(int i=0; i<s.length(); i++){
            System.out.println("a : " + s.charAt(i));
            if(s.charAt(i) < 48 || s.charAt(i) > 57)
                return false;
        }
        return answer;
    }
}