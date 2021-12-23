//https://programmers.co.kr/learn/courses/30/lessons/76503#

import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        for(int i=0; i<a.length; i++){
            sum += a[i];
        }
        if(sum != 0) 
            return -1;
        
        HashSet<Integer>[] adjustNodes = new HashSet[300000];
        for(int i=0; i<adjustNodes.length; i++){
            adjustNodes[i] = new HashSet<Integer>();
        }
        for(int i=0; i<edges.length; i++){
            adjustNodes[edges[i][0]].add(edges[i][1]);
            adjustNodes[edges[i][1]].add(edges[i][0]);
        }
        
        var queue = new LinkedList<Integer>();
        for(int i=0; i<adjustNodes.length; i++){
            if(adjustNodes[i].size() == 1) {
                queue.add(i);
            }
        }
        
        long[] currentNodeValue = new long[a.length];
        for(int i=0; i<a.length; i++){
            currentNodeValue[i] = a[i];
        }
        
        long answer = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            answer += Math.abs(currentNodeValue[current]);
            // System.out.println("current : " + current + " answer : " + answer);
            
            if(adjustNodes[current].size() == 0){
                // System.out.print("current : " + current);
                // System.out.println(" adjustNodes[current].size() == 0");
                continue;
            }
            
            int next = adjustNodes[current].iterator().next();
            adjustNodes[current].remove(next);
            adjustNodes[next].remove(current);
            currentNodeValue[next] += currentNodeValue[current];
            
            if(adjustNodes[next].size() == 1)
                queue.add(next);

        }
        
        return answer;
    }
}


//     public long solution(int[] a, int[][] edges) {
//         if(getSum(a) != 0)
//             return -1;

//         var childQueue = getLeafNodes(a, edges);
//         var parentQueue = new LinkedList<Integer>();
//         int treeSize = a.length;
//         long answer = 0;
        
//         int[] removedNodes = new int[a.length];
//         int[] visitedEdges = new int[edges.length];
        
//         while(true){
//             var leafNode = childQueue.poll();
//             answer += Math.abs(a[leafNode]);
//             removedNodes[leafNode] = 1;
//             visitedEdges[leafNode] = 1;
            
//             if(--treeSize == 1)
//                 return answer;
            
//             if(isLeafNode(leafNode.parent))
//                 parentQueue.add(leadNode.parent);
            
//             if(queue.isEmpty()){
//                 childQueue = parentQueue;
//                 parentQueue = new LinkedList<Integer>();
//             }
//         }
//     }
    
//     public int getSum(int[] a){
//         int sum = 0;
        
//         for(var value : a){
//             sum += value;
//         }
        
//         return sum;
//     }
    
//     public LinkedList<Integer> getLeafNodes(int[] a, int[][] edges){
//         int[] nodeCount = new int[a.length];
//         for(var edge : edges){
//             nodeCount[edge[0]] += edge[1];
//             nodeCount[edge[1]] += edge[0];
//         }
        
//         LinkedList<Integer> leafNodes;
//         for(int node=0; node<nodeCount.length; node++){
//             if(nodeCount == 1){
//                 leafNodes.add(nodeCount);
//             }
//         }
        
//         return leafNodes;
//     }
    
    
//     public boolean isLeafNode(int node, int[] a, int[][] edges, int[] removedNodes, int[] visitedEdges){
//         int nodeCount = 0;
//         for(int edgeIndex = 0; edgeIndex < edges.length; edgeIndex++){
//             if(visitedEdges[edgeIndex] > 0) continue;
//             if(removedNodes[edges[edgeIndex][0]] > 0) continue;
//             if(removedNodes[edges[edgeIndex][1]] > 0) continue;
            
//             if(edges[edgeIndex][0] == node) nodeCount++;
//             if(edges[edgeIndex][1] == node) nodeCount++;
//         }
        
//         return nodeCount == 1;
//     }



// import java.util.*;

// class Solution {
//     public long solution(int[] a, int[][] edges) {
//         //초기 조건 : 다 더해서 0이 안되면 -1 리턴
//         int sum = 0;
        
//         for(var value : a){
//             sum += value;
//         }
        
//         if(sum != 0){
//             return -1;
//         }
        
//         long answer = 0;
        
//         //최소횟수 구하기
//         int treeSize = a.length;
//         int[] visitedEdge = new int[edges.length];
//         int[] removedNode = new int[a.length];
        
//         while(true){
//             //모든 리프노드 찾기
//             for(int childNode = 0; childNode < a.length; childNode++){
//                 if(removedNode[childNode] > 0) 
//                     continue;
                
//                 int edgeCount = 0;
//                 int foundEdge = 0;
//                 for(int edgeIndex = 0; edgeIndex < edges.length; edgeIndex++){
//                     if(visitedEdge[edgeIndex] > 0) 
//                         continue;
                    
//                     if(edges[edgeIndex][0] == childNode || edges[edgeIndex][1] == childNode){
//                         edgeCount++;
//                         foundEdge = edgeIndex;
//                     }
//                 }
                
//                 if(edgeCount != 1) 
//                     continue;
                
//                 //리프 노드 발견
//                 //부모 노드와 합치기
//                 int parentNode = (edges[foundEdge][0] != childNode)
//                                 ? edges[foundEdge][0] : edges[foundEdge][1];
//                 int childNodeValue = Math.abs(a[childNode]);
//                 answer += childNodeValue;
//                 a[parentNode] += childNodeValue;

//                 //노드, 엣지 제거
//                 visitedEdge[foundEdge] = 1;
//                 removedNode[childNode] = 1;

//                 if((--treeSize) <= 1)
//                     return answer;
//             }
//         }
//     }
// }