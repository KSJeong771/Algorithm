//https://programmers.co.kr/learn/courses/30/lessons/42884

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] != b[0])
                    return a[0] - b[0];
                else
                    return a[1] - b[1];
            }
        });
        
        // for(var v : routes){
        //     System.out.println("routes : " + v[0] + ", " + v[1]);
        // }
        
        int cameraCount = 0;
        for(int i=0; i<routes.length; i++){
            int start = routes[i][0];
            int end = routes[i][1];
            cameraCount++;
            // System.out.println("start : " + start + " end : " + end + " cameraCount : " + cameraCount);
            
            int nextIndex = i+1;
            //탐색 끝점 이전에 시작하는 노드들 모두 찾기
            while(nextIndex < routes.length && routes[nextIndex][0] <= end){
                //발견한 노드는 다음 탐색에서 배제
                i++;
                
                //끝점 최신화
                end = Math.min(end, routes[nextIndex++][1]);
            }
            
        }
        
        return cameraCount;
    }
}