package reusable;

import java.util.*;

public class BFS {

    class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/1829
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
//        if (matrix[startPoint.r][startPoint.c] == 0) {
//            return areaSize;
//        }

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
//                if (matrix[nextR][nextC] != matrix[startPoint.r][startPoint.c]) continue;

                queue.add(new Point(nextR, nextC));
                visited[nextR][nextC] = visited[currentPoint.r][currentPoint.c] + 1;
                areaSize++;
            }
        }

        return areaSize;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/86971
    /**
     * 노드 간선 그래프를 너비 우선 탐색한다.
     *
     * @param startNode : 탐색이 시작되는 지점
     * @param bannedEdge : 탐색하지 않을 간선
     * @param graph : 탐색하고자 하는 노드 간선 그래프
     * @param visited : 어떤 단계를 거쳐 탐색했는지 기록하기 위한 배열
     * @return 탐색된 영역의 크기
     */
    int bfsGraph(int startNode, int bannedEdge, int[][] graph, int[] visited) {
        int areaSize = 0;

        // 이미 탐색된 영역 거르기
        if (visited[startNode] > 0) {
            return areaSize;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = 1;
        areaSize++;

        while (!queue.isEmpty()) {
            var currentNode = queue.poll();

            for (int edge=0; edge<graph.length; edge++) {
                int from = graph[edge][0];
                int to = graph[edge][1];
                int nextNode = (currentNode == from) ? to : from;

                // (Optional) 특정 간선 거르기
//                if (bannedEdge == edge) continue;

                // 현재 노드와 관련없는 간선 거르기
                if (currentNode != from && currentNode != to) continue;

                // 이미 탐색된 영역 거르기
                if (visited[nextNode] > 0) continue;

                queue.add(nextNode);
                visited[nextNode] = visited[currentNode] + 1;
                areaSize++;
            }
        }

        return areaSize;
    }
}