//https://programmers.co.kr/learn/courses/30/lessons/12978#

import java.util.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        //초기화
        int[][] newRoad = convertRoad(N, road);
        int[] visited = new int[N+1];
        long[] distance = new long[N+1];
        for(int i=0; i<=N; i++){
            distance[i] = 987654321987654321L;
        }
        
        //BFS
        LinkedList<Integer> queue = new LinkedList();
        queue.add(1);
        distance[1] = 0;
        
        while(!queue.isEmpty()){
            int current = queue.pop();
            
            //인접 노드 탐색
            for(int next=1; next<=N; next++){
                //인접 노드가 아님
                if(newRoad[current][next] >= 987654321)
                    continue;
                
                //방문한 적이 없으면 다음으로
                if(distance[next] >= distance[current]+newRoad[current][next])
                    queue.add(next);
                
                //값을 갱신
                distance[next] = Math.min(distance[next], distance[current]+newRoad[current][next]);
            }
        }
        
        int answer = 0;
        for(int i=1; i<=N; i++){
            System.out.print(distance[i] + " ");
            if(distance[i] <= K)
                answer++;
        }
        return answer;
    }
    
    public int[][] convertRoad(int N, int[][] road){
        Arrays.sort(road, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               return a[2] - b[2];
           } 
        });
        
        int[][] newRoad = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++){
                newRoad[i][j] = 987654321;
            }
        }
        
        for(int i=0; i<road.length; i++){
            int node1 = road[i][0];
            int node2 = road[i][1];
            int value = road[i][2];
            newRoad[node1][node2] = Math.min(newRoad[node1][node2], value);
            newRoad[node2][node1] = Math.min(newRoad[node2][node1], value);
        }
        
        return newRoad;
    }
}