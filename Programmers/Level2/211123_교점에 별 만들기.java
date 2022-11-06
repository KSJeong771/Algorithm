//https://programmers.co.kr/learn/courses/30/lessons/87377

import java.util.*;

class Solution {
    class Point {
        long x;
        long y;
        
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
        List<Point> intersection = new ArrayList<>();
        
        for (int i=0; i<line.length; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            
            for (int j=i+1; j<line.length; j++) {
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                
                long dividendX = B*F - E*D;
                long dividendY = E*C - A*F;
                long divisor = A*D - B*C;
                
                // 두 직선이 평행 또는 일치
                if (divisor == 0) continue;
                
                // 정수인지 판별
                if (dividendX % divisor != 0) continue;
                if (dividendY % divisor != 0) continue;
                
                // 교점 수집
                long x = dividendX / divisor;
                long y = dividendY / divisor;
                intersection.add(new Point(x, y));
            }
        }
        
        // 최소 사각형 크기 구하기
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (var point : intersection) {
            minX = Math.min(minX, point.x);
            minY = Math.min(minY, point.y);
            maxX = Math.max(maxX, point.x);
            maxY = Math.max(maxY, point.y);
        }

        int width = (int)(maxX - minX) + 1;
        int height = (int)(maxY - minY) + 1;

        // 최소 사각형에 별 찍기
        char[][] rectangle = new char[height][width];
        for (int i=0; i<height; i++) {
            Arrays.fill(rectangle[i], '.');
        }
        for (var point : intersection) {
            int actualX = (int)(point.x - minX);
            int actualY = (int)(point.y - minY);
            rectangle[actualY][actualX] = '*';
        }
        
        // 위아래 반전
        String[] answer = new String[height];
        for (int i=height-1; i>=0; i--) {
            answer[height-i-1] = String.valueOf(rectangle[i]);
        }
        return answer;
    }
}