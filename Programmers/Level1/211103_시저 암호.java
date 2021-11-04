//https://programmers.co.kr/learn/courses/30/lessons/12926

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; i++){
            if('A' <= ch[i] && ch[i] <= 'Z'){
                ch[i] += n;
                if(ch[i] > 'Z'){
                    ch[i] = (char)('A' + ch[i] - 'Z' - 1);
                }
            }
            else if('a' <= ch[i] && ch[i] <= 'z'){
                ch[i] += n;
                if(ch[i] > 'z'){
                    ch[i] = (char)('a' + ch[i] - 'z' - 1);
                }
            }
        }
        
        answer = String.valueOf(ch);
        return answer;
    }
}