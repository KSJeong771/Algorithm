//https://programmers.co.kr/learn/courses/30/lessons/42898

class Solution {
    public int solution(int xRange, int yRange, int[][] puddles) {
        int[][] dp = new int[yRange][xRange];
        dp[0][0] = 1;
        
        for(int i=0; i<puddles.length; i++){
            dp[puddles[i][1]-1][puddles[i][0]-1] = -987654321;
        }
        
        for(int step = 0; step < (xRange + yRange - 2); step++){
            int y = step+1;
            int x = -1;
            
            while(++x <= step){
                y--;
                
                if(x < 0) continue;
                if(x >= xRange) continue;
                if(y < 0) continue;
                if(y >= yRange) continue;
                if(dp[y][x] < 0) continue;
                
                if(x+1 < xRange && dp[y][x+1] >= 0){
                    dp[y][x+1] = (dp[y][x+1] + dp[y][x]) % 1000000007;
                }
                
                if(y+1 < yRange && dp[y+1][x] >= 0){
                    dp[y+1][x] = (dp[y+1][x] + dp[y][x]) % 1000000007;
                }
            }
        }
        
//         for(int i=0; i<yRange; i++){
//             for(int j=0; j<xRange; j++){
//                 System.out.print(dp[i][j] + " ");
//             }
//                 System.out.print("\n");
//         }
//                 System.out.print("\n");
        
        return dp[yRange-1][xRange-1];
    }
}