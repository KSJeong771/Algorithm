//https://programmers.co.kr/learn/courses/30/lessons/12916

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int np = 0;
        int ny = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                np++;
            }
            else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
                ny++;
            }
        }
        return np == ny ? true : false;
    }
}