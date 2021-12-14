//https://programmers.co.kr/learn/courses/30/lessons/12938

class Solution {
    public int[] solution(int n, int s) {
        if(n > s)
            return new int[]{-1};
        
        int average = s / n;
        int remaining = s % n;
        
        int[] answer = new int[n];
        int index = 0;
        while(index < n-remaining){
            answer[index++] = average;
        }
        while(index < n){
            answer[index++] = average+1;
        }
        
        return answer;
    }
}