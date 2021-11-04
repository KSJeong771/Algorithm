//https://programmers.co.kr/learn/courses/30/lessons/12922

class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=n; i++){
            if(i%2 == 0)
                sb.append("박");
            else
                sb.append("수");
        }
        answer=sb.toString();
        return answer;
    }
}