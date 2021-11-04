//https://programmers.co.kr/learn/courses/30/lessons/12903

class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length() % 2 == 0){
            System.out.println(s.length()/2-1 + ", " + s.length()/2);
            answer = s.substring(s.length()/2-1, s.length()/2+1);
            System.out.println(answer);
            
        }
        else{
            System.out.println(s.length()/2 + ", " + s.length()/2);
            answer = s.substring(s.length()/2, s.length()/2+1);
            System.out.println(answer);
        }
        return answer;
    }
}