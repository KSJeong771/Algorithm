//https://programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        var queue = new LinkedList<Integer>();
        int maxValue = -1;
        
        for(int i=0; i<1  /*n*/; i++){
            int[] visited = new int[n];
            queue.add(i);
            visited[i] = 1;
            
            while(!queue.isEmpty()){
                var node = queue.poll();
                
                //인접노드 찾기
                for(int j=0; j<edge.length; j++){
                    int from = edge[j][0]-1;
                    int to = edge[j][1]-1;
                    if(from == node){
                        if(visited[to] == 0){
                            visited[to] = visited[node] + 1;
                            queue.add(to);
                            maxValue = Math.max(maxValue, visited[to]);
                        }
                    }
                    else if(to == node){
                        if(visited[from] == 0){
                            visited[from] = visited[node] + 1;
                            queue.add(from);
                            maxValue = Math.max(maxValue, visited[from]);
                        }
                    }
                }
            }
            
            for(var v : visited)
                if(v == maxValue)
                    answer++;
        }
        
        return answer;
    }
}