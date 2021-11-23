//https://programmers.co.kr/learn/courses/30/lessons/87946

class Solution {
    int maxDepth = 0;
    int[][] dungeons;
    int len;
    int k;
    
    public int solution(int k, int[][] dungeons) {
        this.len = dungeons.length;
        this.dungeons = dungeons;
        this.k = k;
        
        for(int i=0; i<len; i++){
            int[] visited = new int[len];
            if(k < dungeons[i][0])
                continue;
            
            System.out.println("시작 i : " + i);
            dfs(i, 0, dungeons[i][1], visited.clone());
        }
        
        return maxDepth;
    }
    
    public void dfs(int currentIndex, int depth, int fatigue, int[] visited){
        //System.out.println("currentIndex : " + currentIndex + " depth : " + depth + " fatigue : " + fatigue);
        
        visited[currentIndex] = 1;
        maxDepth = Math.max(maxDepth, ++depth);
        
        for(int nextIndex=0; nextIndex<len; nextIndex++){
            //방문노드 제외
            if(visited[nextIndex] > 0)
                continue;

            //입장 피로도 체크
            if(dungeons[nextIndex][0] > k-fatigue)
                continue;
            
            //피로도 누적
            int nextFatigue = fatigue + dungeons[nextIndex][1];
            
            //총 피로도 체크
            if(k < nextFatigue)
                continue;
            
            dfs(nextIndex, depth, nextFatigue, visited.clone());
        }
    }
}