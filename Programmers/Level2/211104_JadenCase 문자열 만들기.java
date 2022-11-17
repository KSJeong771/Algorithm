//https://programmers.co.kr/learn/courses/30/lessons/12951#

class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        
        boolean scanningWord = false;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                scanningWord = false;
            } else {
                if (!scanningWord && 'a' <= ch && ch <= 'z') {
                    ch = (char)('A' + (ch - 'a'));
                }
                if (scanningWord && 'A' <= ch && ch <= 'Z') {
                    ch = (char)('a' + (ch - 'A'));
                }
                scanningWord = true;
            }
            
            result.append(ch);
        }
        
        return result.toString();
    }
}