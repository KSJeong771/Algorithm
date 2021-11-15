//https://programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int sizeR = maps.length;
        int sizeC = maps[0].length;
        int[][] visited = new int[sizeR][sizeC];
        visited[sizeR-1][sizeC-1] = -1;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        
        LinkedList<Point> queue = new LinkedList();
        queue.add(new Point(0, 0));
        visited[0][0] = 1;
        while(!queue.isEmpty()){
            var p = queue.poll();
            //System.out.println("current : (" + p.r + "," + p.c + ")");
            for(int i=0; i<4; i++){
                int nextR = p.r + dr[i];
                int nextC = p.c + dc[i];
                if(nextR < 0 || nextR >= sizeR || nextC < 0 || nextC >= sizeC)
                    continue;
                if(maps[nextR][nextC] == 0)
                    continue;
                if(visited[nextR][nextC] > 0)
                    if(visited[nextR][nextC] <= visited[p.r][p.c]+1)
                        continue;
                
                queue.add(new Point(nextR, nextC));
                visited[nextR][nextC] = visited[p.r][p.c] + 1;
            }
            
            // for(int i=0; i<size; i++){
            //     for(int j=0; j<size; j++){
            //         System.out.print(visited[i][j] + " ");
            //     }
            //         System.out.print("\n");
            // }
            //         System.out.print("\n");
        }
        
        return visited[sizeR-1][sizeC-1];
    }
    
    public class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}