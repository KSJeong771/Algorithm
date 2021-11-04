//https://programmers.co.kr/learn/courses/30/lessons/76501

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int size = absolutes.length;
        for(int i=0; i<size; i++){
            int temp = (signs[i] == true) ? absolutes[i] : -absolutes[i];
            answer += temp;
        }
        
        return answer;
    }
}