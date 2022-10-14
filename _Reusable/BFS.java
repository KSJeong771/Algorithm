package reusable;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

    private int bfs(int[][] picture, int[][] visited, int r, int c) {
        // 벽 등 탐색 불가 지역은 탐색하지 않도록 하기 (문제별로 다름)
        if (picture[r][c] == 0) {
            return 0;
        }

        // 이미 탐색한 영역을 다시 탐색하지 않도록 하기
        if (visited[r][c] > 0) {
            return 0;
        }

        int sizeOfArea = 1;
        visited[r][c] = 1;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));
        while (!queue.isEmpty()) {
            var current = queue.poll();

            int nextR;
            int nextC;
            for (int i=0; i<4; i++) {
                nextR = current.r + dr[i];
                nextC = current.c + dc[i];

                if (nextR < 0) continue;
                if (nextC < 0) continue;
                if (nextR >= picture.length) continue;
                if (nextC >= picture[0].length) continue;

                if (visited[nextR][nextC] > 0) continue;

                // 동일한 영역만 탐색하고 싶을 때 조건
                if (picture[nextR][nextC] != picture[r][c]) continue;

                queue.add(new Point(nextR, nextC));

                // 미로찾기식 BFS, depth를 visited에 기록
                //visited[nextR][nextC] = visited[val.r][val.c] + 1;

                // 영역의 크기를 구하는 BFS, 큐에 들어온 원소 수만큼 visited에 기록
                visited[nextR][nextC] = ++sizeOfArea;
            }
        }

        // for (int k = 0; k < picture.length; k++) {
        // 	for (int l = 0; l < picture[0].length; l++) {
        // 		System.out.print(visited[k][l] + " ");
        // 	}
        // 	System.out.println();
        // }
        // System.out.println();

        return sizeOfArea;
    }
}