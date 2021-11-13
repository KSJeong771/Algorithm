//https://programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        LinkedList<Integer> queue = new LinkedList();
        
        //다리를 지날 때 걸리는 시간을 더미노드를 통해 구현
        for(int i=0; i<bridge_length; i++)
            queue.add(0);
        
        int index = 0;
        int current_weight = 0;
        while(index < truck_weights.length || current_weight > 0){
            time++;
            current_weight -= queue.poll();
            
            //마지막 트럭이 지나갈 때는
            //더미노드만을 큐에서 빼주면서 시간을 보낸다
            if(index >= truck_weights.length)
                continue;
            
            //무게 때문에 다리에 트럭이 진입하지 못할 경우 더미노드를 삽입
            if(truck_weights[index] + current_weight > weight){
                queue.add(0);
                continue;
            }
            
            //새로운 트럭이 다리에 진입
            current_weight += truck_weights[index];
            queue.add(truck_weights[index++]);
        }
        
        return time;
    }
}