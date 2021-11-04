//https://programmers.co.kr/learn/courses/30/lessons/68644

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        boolean[] add = new boolean[201];
        int count = 0;
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if (!add[numbers[i] + numbers[j]]){
                    add[numbers[i] + numbers[j]] = true;
                    count++;
                }
            }
        }
        
        int index = 0;
        answer = new int[count];
        for(int i=0; i<=200; i++){
            if(add[i])
                answer[index++] = i;
        }
        
        
        
        return answer;
    }
}