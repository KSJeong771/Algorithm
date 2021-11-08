//https://programmers.co.kr/learn/courses/30/lessons/1829

import java.util.*;

class Solution {
    public class Point{
        int y;
        int x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    public void bfs(int y, int x, int[][] picture){
        //System.out.println("bfs" + " y : " + y + " x : " + x);
        if(visited[y][x] > 0){
            //System.out.println("bfs visited[y][x] > 0");
            return;
        }
        
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        areaCount++;
        int areaSize = 0;
        
        LinkedList<Point> queue = new LinkedList();
        queue.push(new Point(y, x));
        
        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(visited[point.y][point.x] > 0){
                continue;
            }
        //System.out.println("bfs picture[point.y][point.x] : " + picture[point.y][point.x]+ " point.y : " + point.y + " point.x : " + point.x);
            visited[point.y][point.x] = 1;
            areaSize++;
            
            for(int i=0; i<4; i++){
                int newY = point.y + dy[i];
                int newX = point.x + dx[i];
                if (newY < 0 || newY >= picture.length){
                    continue;
                }
                if (newX < 0 || newX >= picture[0].length){
                    continue;
                }
                if(picture[newY][newX] != picture[y][x]){
                    continue;
                }

                queue.add(new Point(newY, newX));
            }
        }
        
        sizeOfArea = Math.max(sizeOfArea, areaSize);
    }
    
    int areaCount = 0;
    int sizeOfArea = 0;
    int[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new int[picture.length][picture[0].length];
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        for(int y = 0; y<picture.length; y++){
            for(int x = 0; x<picture[0].length; x++){
                if(picture[y][x] == 0){
                    continue;
                }
                
                bfs(y, x, picture);
            }
        }
        
        //System.out.println(areaCount + ", " + sizeOfArea);
        answer[0] = areaCount;
        answer[1] = sizeOfArea;
        return answer;
    }
}