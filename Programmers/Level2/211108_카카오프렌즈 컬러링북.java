//https://programmers.co.kr/learn/courses/30/lessons/1829

import java.util.*;

class Solution {
    class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxAreaSize = 0;
        
		int[][] visited = new int[picture.length][picture[0].length];

		for (int i = 0; i < picture.length; i++) {
			for (int j = 0; j < picture[0].length; j++) {
				int areaSize = bfsMatrix(new Point(i, j), picture, visited);		
				if (areaSize > 0) {
                    numberOfArea++;
                }
                
                maxAreaSize = Math.max(maxAreaSize, areaSize);
			}
		}

		return new int[] {numberOfArea, maxAreaSize};
	}

    /**
     * 2차원 배열을 너비 우선 탐색한다.
     *
     * @param startPoint : 탐색이 시작되는 지점
     * @param matrix : 탐색하고자 하는 2차원 배열
     * @param visited : 어떤 단계를 거쳐 탐색했는지 기록하기 위한 배열
     * @return 탐색된 영역의 크기
     */
    int bfsMatrix(Point startPoint, int[][] matrix, int[][] visited) {
        int areaSize = 0;

        // (Optional) 탐색 불가 영역 거르기
        if (matrix[startPoint.r][startPoint.c] == 0) {
            return areaSize;
        }

        // 이미 탐색된 영역 거르기
        if (visited[startPoint.r][startPoint.c] > 0) {
            return areaSize;
        }

        int[] dc = {0, -1, 0, 1};
        int[] dr = {-1, 0, 1, 0};

        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint.r][startPoint.c] = 1;
        areaSize++;

        while (!queue.isEmpty()) {
            var currentPoint = queue.poll();

            for (int i=0; i<4; i++) {
                int nextR = currentPoint.r + dr[i];
                int nextC = currentPoint.c + dc[i];

                if (nextR < 0) continue;
                if (nextC < 0) continue;
                if (nextR >= matrix.length) continue;
                if (nextC >= matrix[0].length) continue;

                // 이미 탐색된 영역 거르기
                if (visited[nextR][nextC] > 0) continue;

                // (Optional) 동일한 영역만 탐색하기
                if (matrix[nextR][nextC] != matrix[startPoint.r][startPoint.c]) continue;

                queue.add(new Point(nextR, nextC));
                visited[nextR][nextC] = visited[currentPoint.r][currentPoint.c] + 1;
                areaSize++;
            }
        }

        return areaSize;
    }
}