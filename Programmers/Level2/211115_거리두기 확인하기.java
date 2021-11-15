//https://programmers.co.kr/learn/courses/30/lessons/81302

import java.util.*;

class Solution {
    public final int size = 5;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[size];
        
        for(int i=0; i<size; i++){
            //String 형식 입력을 char[][] 형태로 변환
            char[][] place = strTo2dArray(places[i]);
            
            //사람을 발견하면 거리두기를 지키는지 검사
            answer[i] = explorePlace(place);
        }
        
        return answer;
    }
    
    public int explorePlace(char[][] place){
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                if(place[r][c] == 'P' && checkKeepDistance(r,c,place) == 0)
                    return 0;
            }
        }
        
        return 1;
    }
        
    //모든 사람에서부터 일정 거리(2)까지 완전탐색하고 사람을 찾는데 성공하면 거리두기 실패
    public int checkKeepDistance(int y, int x, char[][] place){
        int maxDistance = 2;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] visited = new int[size][size];
        
        //BFS 탐색에 사용할 큐
        LinkedList<Point> queue = new LinkedList();
        
        //첫 번째 노드 탐색
        queue.add(new Point(y, x));
        visited[y][x] = 1;
        
        while(!queue.isEmpty()){
            var p = queue.pop();
            
            //거리 2까지만 탐색
            if(visited[p.y][p.x] > maxDistance) 
                continue;
            
            //4방향으로 탐색
            for(int i=0; i<4; i++){
                int nextY = p.y + dy[i];
                int nextX = p.x + dx[i];
                
                //0~4 인덱스 범위 벗어나면 제외
                if(nextY < 0 || nextY >= size || nextX < 0 || nextX >= size) 
                    continue;
                
                //이미 방문한 노드 제외
                if(visited[nextY][nextX] > 0) 
                    continue;
                
                //칸막이 제외
                if(place[nextY][nextX] == 'X') 
                    continue;
                
                //사람 발견 시 
                if(place[nextY][nextX] == 'P') {
                    //거리두기 실패
                    return 0;
                }
                
                //방문 여부와 거리를 기록
                visited[nextY][nextX] = visited[p.y][p.x] + 1;
                
                //탐색
                queue.add(new Point(nextY, nextX));
            }
        }
        
        return 1;
    }
    
    //String 형식 입력을 char[][] 형태로 변환
    public char[][] strTo2dArray(String[] places){
        char[][] place = new char[size][size];
        
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                place[r][c] = places[r].charAt(c);
            }
        }
        
        return place;
    }
    
    public class Point{
        int y;
        int x;
        
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
}