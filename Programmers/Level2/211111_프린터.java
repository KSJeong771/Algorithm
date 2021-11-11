//https://programmers.co.kr/learn/courses/30/lessons/42587

import java.util.*;

class Solution {
    public int getMax(LinkedList<Integer> queue){
        int max = -1;
        for(int i=0; i<queue.size(); i++){
            max = Math.max(max, queue.get(i));
        }
        return max;
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        LinkedList<Integer> queue = new LinkedList();
        for(int i=0; i<priorities.length; i++){
            queue.add(priorities[i]);
        }
        
        int max = getMax(queue);
        while(!queue.isEmpty() && location >= 0){
            int node = queue.poll();
            location--;
            
            if(max > node){
                queue.add(node);
                
                if(location < 0){
                    location = queue.size()-1;
                }
            }
            else{
                answer++;
                max = getMax(queue);
            }
            
            //System.out.println("location : " + location + ", answer : " + answer);
            // for(int i=0; i<queue.size(); i++){
            //     System.out.print(queue.get(i) + ", ");
            // }
        }
        
        return answer;
    }
}