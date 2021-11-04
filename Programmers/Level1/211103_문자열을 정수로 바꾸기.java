//https://programmers.co.kr/learn/courses/30/lessons/12925

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] ch = s.toCharArray();
        int mul = 1;
        for(int i=ch.length-1; i>=0; i--){
            if(ch[i] == '+'){
                continue;
            }
            if(ch[i] == '-'){
                answer *= -1;
                continue;
            }
            int temp = ch[i]-48;
            System.out.println(temp);
            answer += temp * mul;
            mul *= 10;
        }
        return answer;
    }
}