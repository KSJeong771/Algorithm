//https://programmers.co.kr/learn/courses/30/lessons/86052

import java.util.*;

class Solution {
    char[][] grid;
    
    //좌회전하면 인덱스 감소
    //우회전하면 인덱스 증가
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    
    HashMap<String, Integer> visited = new HashMap();
    
    public int func(int r, int c, int direction) {
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;
        int depth = 0;
        
        int sizeBefore = visited.size();
        
        //사이클 감지할때까지
        //같은 장소를 같은 방향으로 탐색했을 때 사이클이 발생한다
        while(true){
            char currentNode = grid[r][c];
            String temp = Integer.toString(r) + "," + Integer.toString(c) + "," + direction;
            
            if(visited.get(temp) != null)
                break;
            
            visited.put(temp, 1);

            direction = turn(currentNode, direction);
            r += dy[direction];
            c += dx[direction];

            if(r < 0) r = HEIGHT-1;
            if(c < 0) c = WIDTH-1;
            if(r >= HEIGHT) r = 0;
            if(c >= WIDTH) c = 0;
        }
        
        // for(var v : visited.entrySet())
        //     System.out.print(v + " ");
        // System.out.print("\n");
        
        return visited.size() - sizeBefore;
    }
    
    public int[] solution(String[] sgrid) {
        //처리하기 쉬운 배열로 변환
        grid= new char[sgrid.length][sgrid[0].length()];
        for(int i=0; i<grid.length; i++){
            grid[i] = sgrid[i].toCharArray();
        }        
        
        var list = new ArrayList<Integer>();
        
        //모든 노드에서
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                //모든 방향으로 빛 쏴보기
                for(int i=0; i<4; i++){
                    String temp = Integer.toString(r) + "," + Integer.toString(c) + "," + i;
                    if(visited.get(temp) == null)
                        list.add(func(r, c, i));
                }
            }
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for(var v : list){
            answer[index++] = v;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public int turn(char node, int direction){
        switch(node){
            case 'S':
                break;
            case 'L':
                direction--;
                break;
            case 'R':
                direction++;
                break;
        }
        
        if(direction < 0)
            direction = 3;
        
        if(direction > 3)
            direction = 0;
        
        return direction;
    }
}