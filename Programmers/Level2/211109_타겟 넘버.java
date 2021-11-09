//https://programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int plus = dfs(numbers, target, numbers[0], 1);
        int minus = dfs(numbers, target, -numbers[0], 1);
        answer = plus + minus;
        return answer;
    }
    
    public int dfs(int[] numbers, int target, int value, int depth){
        //System.out.println("v : " + value + " t : " + target);
        if(depth == numbers.length){
            if(target == value){
                return 1;
            }else{
                return 0;
            }
        }
        
        int plus = dfs(numbers, target, value+numbers[depth], depth+1);
        int minus = dfs(numbers, target, value-numbers[depth], depth+1);
        
        return plus + minus;
    }
}