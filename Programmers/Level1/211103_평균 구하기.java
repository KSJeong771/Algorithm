//https://programmers.co.kr/learn/courses/30/lessons/12944

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int i=0;i<arr.length;i++){
            answer += arr[i];
        }
        answer /= arr.length;
        return answer;
    }
}