//https://programmers.co.kr/learn/courses/30/lessons/43162

import java.util.*;

class Solution {
    int[] visited;
    int count = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 0) continue;
                if(computers[j][i] == 0) continue;
                if(visited[i] > 0 || visited[j] > 0) continue;
                bfs(i, j, computers);
            }
        }
        
        return count;
    }
    
    class Point{
        int y;
        int x;
        
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    public void bfs(int y, int x, int[][] computers){
        //System.out.println("bfs y : " + y + " x : " + x);
        //for(int i=0; i<visited.length; i++)
            //System.out.print(visited[i] + " ");
            //System.out.println();
        
            visited[x] = 1;
            visited[y] = 1;
        
        count++;
        var q = new LinkedList<Integer>();
        q.add(x);
        while(!q.isEmpty()){
            var p = q.poll();
        //System.out.println("poll : (" + p + ")");
            visited[p] = 1;
            
            for(int i=0; i<computers.length; i++){
                if(computers[p][i] == 0) {
        //System.out.println("computers[p.y][i] == 0 (" + p + ", " + i + ")");
                    continue;
                }
                if(visited[i] > 0) {
        //System.out.println("visited[i] > 0 / i : " + i);
                    continue;
                }
                
        //System.out.println("add : (" + p + ", " + i + ")");
                q.add(i);
            }
        }
        
        //for(int i=0; i<visited.length; i++)
        //    System.out.print(visited[i] + " ");
        //    System.out.println();
    }
}