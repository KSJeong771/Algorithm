//https://programmers.co.kr/learn/courses/30/lessons/43105

class Solution {
    public int solution(int[][] triangle) {
        for(int i=1; i<triangle.length; i++){
            //다음 노드의 관점에서 여태 지나왔던 길 중 큰 길을 선택한다.
            for(int j=0; j<triangle[i].length; j++){
                if(j-1 < 0){
                    triangle[i][j] += triangle[i-1][j];
                }
                else if(j >= triangle[i-1].length){
                    triangle[i][j] += triangle[i-1][j-1];
                }
                else{
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }
            }
            //print(triangle);
        }
        
        int max = -1;
        for(int i=0; i<triangle[triangle.length-1].length; i++){
            max = Math.max(max, triangle[triangle.length-1][i]);
        }
        
        return max;
    }
    
    public void print(int[][] triangle){
        for(int i=0; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}