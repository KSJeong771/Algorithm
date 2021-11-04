//https://programmers.co.kr/learn/courses/30/lessons/12901

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        int[] days = {0,31,29,31,30,31,30,31,
                      31,30,31,30,31};
        int gap = 0;
        for(int i=0; i<a; i++){
            gap += days[i];
        }
        gap += (b - 1);
        int first = 5;
        String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        answer = week[(first + gap) % 7];
        
        return answer;
    }
}