//https://programmers.co.kr/learn/courses/30/lessons/87377

import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        HashMap<String, Integer> map = new HashMap();
        long minX = 8987654321987654321L;
        long minY = 8987654321987654321L;
        
        long maxX = -8987654321987654321L;
        long maxY = -8987654321987654321L;
        
        for(int i=0; i<line.length; i++){
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            
            for(int j=i+1; j<line.length; j++){
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                
                //System.out.printf("직선 1 : %dx + %dy + %d", A, B, C);
                //System.out.printf(" 직선 2 : %dx + %dy + %d\n", D, E, F);
                
                long xBefore = (B * F) - (E * D);
                long yBefore = (E * C) - (A * F);
                long div = (A * D) - (B * C);
                
                //두 직선이 평행 또는 일치
                if(div == 0){
                    //System.out.println("두 직선이 평행 또는 일치");
                    continue;
                }
                
                //정수가 아닌 교점
                if(xBefore % div != 0 || yBefore % div != 0){
                    //System.out.println("정수가 아닌 교점 : " + xBefore + "," + yBefore + "," + div);
                    continue;
                }
                
                int x = (int)(xBefore / div);
                int y = (int)(yBefore / div);
                
                if(x < minX) minX = x;
                if(y < minY) minY = y;
                if(x > maxX) maxX = x;
                if(y > maxY) maxY = y;
                
                map.put(Integer.toString(x) + "," + Integer.toString(y), 1);
            }
        }
        
        int width = (int)Math.abs(maxX - minX) + 1;
        int height = (int)Math.abs(maxY - minY) + 1;
        if(width > 1000) width = 1000;
        if(height > 1000) height = 1000;
        
        char[][] board = new char[height][width];
        for(int i=height-1; i>=0; i--){
            for(int j=0; j<width; j++){
                board[i][j] = '.';
            }
        }
        
        for(var v : map.entrySet()){
            //System.out.println(v.getKey());
            int x = Integer.parseInt(v.getKey().split(",")[0]) - (int)minX;
            int y = Integer.parseInt(v.getKey().split(",")[1]) - (int)minY;
            if(x > 1000) continue;
            if(y > 1000) continue;
            board[y][x] = '*';
        }
        
        String[] answer = new String[height];
        
        int answerIndex = 0;
        for(int i=height-1; i>=0; i--){
            answer[answerIndex++] = String.valueOf(board[i]);
        }
        
        return answer;
    }
}