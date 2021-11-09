//https://programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        int[] visited = new int[length];
        
        ArrayList<Integer> list = new ArrayList();
        int total = 0;
        int currentProgress = 0;
        while(total < length){
            //작업 진행
            for(int i=currentProgress; i<length; i++){
                progresses[i] += speeds[i];
            }
            
            //앞 기능 미완성
            if(progresses[currentProgress] < 100){
                continue;
            }
            
            int releaseCount = 0;
            for(int i=currentProgress; i<length; i++){
                //미완성 작업 발견 시 탐색 중단
                if (progresses[i] < 100){
                    break;
                }
                
                currentProgress++;
                visited[i] = 1;
                releaseCount++;
            }
            
            list.add(releaseCount);
            total += releaseCount;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}