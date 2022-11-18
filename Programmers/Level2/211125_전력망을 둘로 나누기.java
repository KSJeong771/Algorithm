//https://programmers.co.kr/learn/courses/30/lessons/86971

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minGap = Integer.MAX_VALUE;
        
        for (int bannedEdge = 0; bannedEdge < wires.length; bannedEdge++) {
            int from = wires[bannedEdge][0];
            int to = wires[bannedEdge][1];
            
            int partOne = bfsGraph(from, bannedEdge, wires, new int[n+1]);
            int partTwo = bfsGraph(to, bannedEdge, wires, new int[n+1]);
            
            int gap = Math.abs(partOne - partTwo);
            minGap = Math.min(minGap, gap);
        }
        
        return minGap;
    }
    
    /**
     * 노드 간선 그래프를 너비 우선 탐색한다.
     *
     * @param startNode : 탐색이 시작되는 지점
     * @param bannedEdge : 탐색하지 않을 간선
     * @param graph : 노드 간선 그래프
     * @param visited : 어떤 단계를 거쳐 탐색했는지 기록한다.
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
                if (bannedEdge == edge) continue;

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