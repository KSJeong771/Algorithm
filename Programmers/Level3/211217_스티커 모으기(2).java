//https://programmers.co.kr/learn/courses/30/lessons/12971#

import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1)
            return sticker[0];
        
        int length = sticker.length;
        int max = -1;
        
        int[] memo = new int[length];
        memo[0] = sticker[0];
        memo[1] = sticker[0];
        for (int i=2; i<length-1; i++) {
            memo[i] = Math.max(memo[i-2] + sticker[i], memo[i-1]);
        }
        
        max = Math.max(max, memo[length-2]);
        memo[0] = 0;
        memo[1] = sticker[1];
        for (int i=2; i<length; i++) {
            memo[i] = Math.max(memo[i-2] + sticker[i], memo[i-1]);
        }

        max = Math.max(max, memo[length-1]);
        return max;
    }
}

// //시간, 메모리 초과
// import java.util.*;

// class Solution {
//     public int solution(int sticker[]) {
//         for(int centerIndex=0; centerIndex<sticker.length; centerIndex++){
//             int[] visited = new int[sticker.length];
            
//             int leftIndex = (centerIndex == 0) ? sticker.length-1 : centerIndex-1;
//             int rightIndex = (centerIndex == sticker.length-1) ? 0 : centerIndex+1;
//             visited[centerIndex] = 1;
//             visited[leftIndex] = 1;
//             visited[rightIndex] = 1;
            
//             dfs(centerIndex, sticker, visited, sticker[centerIndex]);
//         }
            
//         return max;
//     }
    
//     public int max = -1;
//     public void dfs(int currentIndex, int[] sticker, int[] visited, int stickerSum){
//         boolean visitedAll = true;
//         for(int i=0; i<visited.length; i++){
//             if(visited[i] == 0)
//                 visitedAll = false;
//         }
        
//         if(visitedAll){
//             max = Math.max(max, stickerSum);
//             return;
//         }
        
//         for(int centerIndex=0; centerIndex<sticker.length; centerIndex++){
//             if(visited[centerIndex] > 0) continue;
            
//             int leftIndex = (centerIndex == 0) ? sticker.length-1 : centerIndex-1;
//             int rightIndex = (centerIndex == sticker.length-1) ? 0 : centerIndex+1;
            
//             int[] visitedCopy = new int[visited.length];
//             for(int i=0; i<visited.length; i++)
//                 visitedCopy[i] = visited[i];
            
//             visitedCopy[centerIndex] = 1;
//             visitedCopy[leftIndex] = 1;
//             visitedCopy[rightIndex] = 1;
            
//             dfs(centerIndex, sticker, visitedCopy, stickerSum + sticker[centerIndex]);
//         }
//     }
// }