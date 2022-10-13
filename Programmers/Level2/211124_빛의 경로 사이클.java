//https://programmers.co.kr/learn/courses/30/lessons/86052

import java.util.*;

class Solution {
    int[] solution(String[] strGrid) {
        char[][] grid = to2dArray(strGrid);
        int height = grid.length;
        int width = grid[0].length;

        int[][][] visited = new int[height][width][4];
        List<Integer> cycles = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 4; k++) {
                    bfs3d(grid, visited, cycles, i, j, k);
                }
            }
        }

        return to1dArray(cycles);
    }

    void bfs3d(char[][] grid, int[][][] visited, List<Integer> cycles, int i, int j, int k) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int height = grid.length;
        int width = grid[0].length;

        int nextRow = i;
        int nextCol = j;
        int nextDir = k;

        int depth = 1;
        while (visited[nextRow][nextCol][nextDir] == 0) {
            visited[nextRow][nextCol][nextDir] = depth++;

            nextDir = changeDirection(nextDir, grid[nextRow][nextCol]);
            nextRow += dr[nextDir];
            nextCol += dc[nextDir];

            if (nextRow < 0) nextRow = height - 1;
            if (nextCol < 0) nextCol = width - 1;
            if (nextRow >= height) nextRow = 0;
            if (nextCol >= width) nextCol = 0;
        }
        if (depth - 1 > 0) {
            cycles.add(depth - 1);
        }
    }

    int changeDirection(int direction, char where) {
        switch (where) {
            case 'L':
                direction--;
                break;
            case 'R':
                direction++;
                break;
        }

        if (direction < 0) {
            direction = 3;
        }
        if (direction > 3) {
            direction = 0;
        }

        return direction;
    }

    int[] to1dArray(List<Integer> list) {
        return list.stream()
                .sorted()
                .mapToInt(i->i)
                .toArray();
    }

    char[][] to2dArray(String[] grid) {
        int height = grid.length;
        int width = grid[0].length();

        char[][] arrGrid = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arrGrid[i][j]=  grid[i].charAt(j);
            }
        }

        return arrGrid;
    }
}