//https://programmers.co.kr/learn/courses/30/lessons/12935

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int min = 987654321;
        int minIndex = -1;
        
        for(int i=0; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
                minIndex = i;
            }
        }
        
        answer = new int[arr.length-1];
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(i==minIndex){
                continue;
            }
            answer[index++] = arr[i];
        }
        return answer;
    }
}