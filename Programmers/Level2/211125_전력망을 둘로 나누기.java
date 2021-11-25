//https://programmers.co.kr/learn/courses/30/lessons/86971

import java.util.*;

class Solution {
    int min = 987654321;
    int n;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        this.n = n;
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList();
        for(int i=0; i<n; i++){
            ArrayList<Integer> ar = new ArrayList();
            arr.add(ar);
        }
        for(int i=0; i<wires.length; i++){
            arr.get(wires[i][0]-1).add(wires[i][1]-1);
            arr.get(wires[i][1]-1).add(wires[i][0]-1);
        }
        
        
        for(int i=0; i<n; i++){
            int[] visited = new int[n];
            visited[i] = 1;
            int a = func(arr, i, -1, visited.clone());
            //System.out.println(a);
        }
        
        return min;
    }
    
    public int func(ArrayList<ArrayList<Integer>> arr, int current, int parent, int[] visited){
        int result = 0;
        visited[current] = 1;
        var v = arr.get(current);
        for(var vv : v){
            if(vv == parent) continue;
            if(visited[vv] != 0) continue;
            result++;
        }
        for(var vv : v){
            if(vv == parent) continue;
            if(visited[vv] != 0) continue;
            int a = func(arr, vv, current, visited.clone());
            result += a;
            
            int right = a + 1;
            int left = n-right;
            int comp = Math.abs(left - right);
            //System.out.printf("노드 %d의 left : %d, right : %d, 차이 : %d\n", current, left, right, comp);
            
            this.min = Math.min(this.min, comp);
        }
        return result;
    }
}