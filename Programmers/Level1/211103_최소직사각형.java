//https://programmers.co.kr/learn/courses/30/lessons/86491

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max1 = -1;
        int max2 = -1;
        for(int i=0;i<sizes.length; i++){
            int widthIdx = 0;
            int heightIdx = 1;
            if(sizes[i][0] > sizes[i][1]){
                widthIdx = 1;
                heightIdx = 0;
            }
            
            if(sizes[i][widthIdx] > max1)
                max1 = sizes[i][widthIdx];
            if(sizes[i][heightIdx] > max2)
                max2 = sizes[i][heightIdx];
        }
        
        answer = max1 * max2;
        return answer;
    }
}