//https://programmers.co.kr/learn/courses/30/lessons/68936

class Solution {
    int count1 = 0;
    int count2 = 0;
    
    public int[] solution(int[][] arr) {
        int[] answer = {0,0};
        
        func(arr, arr.length, 0, 0);
        
        answer[0] = count1;
        answer[1] = count2;
        return answer;
    }
    
    public void func(int[][] arr, int size, int y, int x){
        boolean sameAll = true;
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(arr[y][x] != arr[i][j]){
                    sameAll = false;
                    break;
                }
            }
            if(!sameAll)
                break;
        }
        
        if(sameAll){
            if(arr[y][x] == 0){
                count1++;
            }
            if(arr[y][x] == 1){
                count2++;
            }
            return;
        }
        
        int nextSize = size / 2;
        func(arr, nextSize, y, x);
        func(arr, nextSize, y+nextSize, x);
        func(arr, nextSize, y, x+nextSize);
        func(arr, nextSize, y+nextSize, x+nextSize);
    }
}