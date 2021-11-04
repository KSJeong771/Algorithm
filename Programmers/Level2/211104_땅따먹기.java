//https://programmers.co.kr/learn/courses/30/lessons/12913#

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[] resultMax = new int[land.length];
        
        for(int row=1; row<land.length; row++){
            int currentRow = row;
            int previousRow = row-1;
            
            for(int currentColumn=0; currentColumn<4; currentColumn++){
                int currentValue = land[currentRow][currentColumn];
                
                int previousMax = -1;
                for(int previousColumn=0; previousColumn<4; previousColumn++){
                    if(currentColumn == previousColumn){
                        continue;
                    }
                    
                    previousMax = Math.max(previousMax, land[previousRow][previousColumn]);
                }
                
                land[currentRow][currentColumn] += previousMax;
            }
        }
        
        for(int i=0; i<4; i++){
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}