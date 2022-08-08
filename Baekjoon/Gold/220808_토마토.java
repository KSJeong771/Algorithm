//https://www.acmicpc.net/problem/7576

import java.util.*;

class Main {
    public static class Point {
        int r;
        int c;
        int round;

        public Point(int r, int c, int round) {
            this.r = r;
            this.c = c;
            this.round = round;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();

        // 입력 받기
        int[][] warehouse = new int[height][width];
        int[][] visited = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                warehouse[i][j] = sc.nextInt();
            }
        }

        // 익은 토마토 수집
        LinkedList<Point> queue = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (warehouse[i][j] == 1) {
                    queue.add(new Point(i, j, 0));
                }
            }
        }

        // 4방향으로 전파
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, -1, 0, 1 };

        int maxRound = 0;
        while (!queue.isEmpty()) {
            Point next = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newR = next.r + dr[i];
                int newC = next.c + dc[i];

                if (newR < 0 || newR >= height) continue;
                if (newC < 0 || newC >= width) continue;
                if (warehouse[newR][newC] != 0) continue;
                if (visited[newR][newC] != 0) continue;

                maxRound = Math.max(maxRound, next.round + 1);
                queue.add(new Point(newR, newC, next.round + 1));

                visited[newR][newC] = next.round + 1;
                warehouse[newR][newC] = 1;
            }
        }

        // 아직 익지 않은 토마토가 있는지 검사
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (warehouse[i][j] == 0) {
                    maxRound = -1;
                    break;
                }
            }
        }

        System.out.println(maxRound);
    }
}
