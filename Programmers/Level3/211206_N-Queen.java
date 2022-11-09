//https://programmers.co.kr/learn/courses/30/lessons/12952?language=java#

import java.util.*;

class Solution {
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int count = 0;
    
    public int solution(int n) {
        int[][] queens = new int[n][n];
        int[][] attackRange;
        
        // 가장 위쪽 행부터 아래로 내려가면서
        // 퀸을 배치할 수 있는지 탐색한다.
        int y = 0;
        for (int x=0; x<n; x++) {
            // 퀸 배치
            queens[y][x] = 9;
            attackRange = markAttackRange(n, queens);
            
            explore(y+1, n, attackRange, queens);
            
            // 퀸 배치 해제
            queens[y][x] = 0;
            attackRange = markAttackRange(n, queens);
        }
        
        return count;
    }
    
    void explore(int y, int n, int[][] attackRange, int[][] queens) {
        // 마지막 행까지 n개의 퀸이 배치되었으므로 카운트하고 마무리
        if (y == n) {
            count++;
            return;
        }
        
        for (int x=0; x<n; x++) {
            // 다른 퀸의 공격 범위 안이라 퀸을 배치할 수 없다.
            if (attackRange[y][x] == 0) {
                continue;
            }
            
            // 퀸 배치
            queens[y][x] = 9;
            attackRange = markAttackRange(n, queens);
            
            // 다음 행에 퀸을 배치할 수 있는지 탐색
            explore(y+1, n, attackRange, queens);
            
            // 퀸 배치 해제
            queens[y][x] = 0;
            attackRange = markAttackRange(n, queens);
        }
    }
    
    int[][] markAttackRange(int n, int[][] queens) {
        int[][] attackRange = new int[n][n];
        
        // 퀸 위치를 모두 찾아서 공격 범위를 표시한다.
        for (int y=0; y<n; y++) {
            for (int x=0; x<n; x++) {
                if (queens[y][x] == 0) {
                    continue;
                }
                
                // 퀸의 위치를 표시
                attackRange[y][x] = queens[y][x];
                
                // 8방향으로 마킹 시작
                int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
                int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
                for (int direction=0; direction<8; direction++) {
                    int currentRange = 0;
                    
                    // 배열 경계에 닿을 때까지 마킹
                    while (true) {
                        int nextY = y + dy[direction] * currentRange;
                        int nextX = x + dx[direction] * currentRange;
                        
                        if (nextY < 0) break;
                        if (nextX < 0) break;
                        if (nextY >= n) break;
                        if (nextX >= n) break;
                        
                        if (attackRange[nextY][nextX] != 9) {
                            attackRange[nextY][nextX] = 1;
                        }
                        
                        currentRange++;
                    }
                }
            }
        }
        
        return attackRange;
    }
    
}