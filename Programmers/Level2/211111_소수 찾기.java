//https://programmers.co.kr/learn/courses/30/lessons/42839#

import java.util.*;

class Solution {
    public int solution(String numbers) {
        HashMap<Integer, Integer> map = new HashMap();
        boolean[] visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            dfs(i, 0, numbers, "", visited.clone(), map);
        }
        
        return map.size();
    }
    
    public void dfs(int index, int depth, String numbers, String selectedNumbers, boolean[] visited, HashMap<Integer, Integer> map){
        //방문처리
        selectedNumbers += numbers.substring(index, index+1);
        visited[index] = true;
        
        //소수체크
        int num = Integer.parseInt(selectedNumbers);
        if(isPrime(num))
            map.put(num, 1);
        
        //깊이체크
        if(++depth >= numbers.length())
            return;
        
        //노드 방문
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i])
                dfs(i, depth, numbers, selectedNumbers, visited.clone(), map);
        }
    }
    
    public boolean isPrime(Integer num){
        if(num == 0 || num == 1)
            return false;
        
        if(num == 2)
            return true;
        
        if(num % 2 == 0)
            return false;
        
        for(int i=3; i<=Math.sqrt(num); i+= 2){
            if(num % i == 0)
                return false;
        }
        
        System.out.println(num + " is prime.");
        return true;
    }
}