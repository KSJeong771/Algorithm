//https://programmers.co.kr/learn/courses/30/lessons/77484

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        
        int count_equal = 0;
        int count_zero = 0;
        
        for(int i=0; i<6; i++){
            if (lottos[i] == 0){
                count_zero++;
            }
            for(int j=0; j<6; j++){
                if (lottos[j] == win_nums[i]){
                    count_equal++;
                }
            }
        }
        
        answer[0] = 7 - count_equal - count_zero;
        answer[1] = 7 - count_equal;
        
        if (answer[0] > 6)
            answer[0] = 6;
        if (answer[1] > 6)
            answer[1] = 6;
        
        return answer;
    }
}