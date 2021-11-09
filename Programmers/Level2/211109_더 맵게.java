//https://programmers.co.kr/learn/courses/30/lessons/42626

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //반복 돌 때 마다 최소값 2번을 구해야 함
        PriorityQueue<Integer> heap = new PriorityQueue();
        for(int i=0; i<scoville.length; i++){
            heap.add(scoville[i]);
        }
        
        while(true){
            if(heap.isEmpty()){
                return -1;
            }
            int minSco1 = heap.poll();
            
            if(K <= minSco1){
                break;
            }
            
            if(heap.isEmpty()){
                return -1;
            }
            int minSco2 = heap.poll();
            
            
            heap.add(minSco1 + minSco2 * 2);
            answer++;
        }
        
        return answer;
    }
}