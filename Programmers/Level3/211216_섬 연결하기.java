//https://programmers.co.kr/learn/courses/30/lessons/42861

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (a, b) -> a[2]-b[2]);
        
        ArrayList<int[]> edges = new ArrayList();
        for(int i=0; i<costs.length; i++){
            if(!isCycle(costs[i][0], costs[i][1], edges, n)){
                edges.add(costs[i]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    //두 노드를 잇는 길이 이미 있다면 사이클이 발생한다
    public boolean isCycle(int from, int to, ArrayList<int[]> edges, int n){
        boolean result = false;
        
        int[] visited = new int[n];
        var q = new LinkedList<Integer>();
        q.add(from);
        
        while(!q.isEmpty()){
            int current = q.poll();
            int next = -1;
            for(var edge : edges){
                if(edge[0] == current){
                    next = edge[1];
                }
                else if(edge[1] == current){
                    next = edge[0];
                }else{
                    continue;
                }
                
                if(visited[next] == 0){
                    visited[next] = 1;
                    q.add(next);
                }
            }
        }
        
        return visited[to] > 0;
    }
}