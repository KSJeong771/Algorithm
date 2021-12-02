//https://programmers.co.kr/learn/courses/30/lessons/42895

class Solution {
    int min = 987654321;
    public int solution(int N, int target) {
        int[] pow = {1, 11, 111, 1111};
        for(int i=0; i<4; i++){
            int next = N * pow[i];
            func(N, target, 0 + next, i);
            func(N, target, 0 - next, i);
        }
        
        if(min > 8)
            min = -1;
        return min;
    }
    
    public void func(int N, int target, int current, int depth){
        depth++;
        if(depth > 8)
            return;
        
        if(current == target){
            min = Math.min(min, depth);
            return;
        }
        
        int[] pow = {1, 11, 111, 1111};
        for(int i=0; i<4; i++){
            int next = N * pow[i];
            func(N, target, current + next, depth + i);
            func(N, target, current - next, depth + i);
            func(N, target, current * next, depth + i);
            func(N, target, current / next, depth + i);
        }
    }
}