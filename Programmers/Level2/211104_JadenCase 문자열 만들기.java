//https://programmers.co.kr/learn/courses/30/lessons/12951#

class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] chArr = s.toLowerCase().toCharArray();
        boolean isFirst = true;
        
        int index = 0;
        for(char ch : chArr){
            if (ch == ' '){
                isFirst = true;
            }else if (ch >= 'a' && ch <= 'z'){
                if(isFirst){
                    chArr[index] -= ('a' - 'A');
                    isFirst = false;
                }
            }
            else{
                isFirst = false;
            }
            index++;
        }
        
            
        answer += String.valueOf(chArr);
        return answer;
    }
}