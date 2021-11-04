//https://programmers.co.kr/learn/courses/30/lessons/1845

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int count = 0;
        int index = 0;
        boolean[] sel = new boolean[200001];
        while(count < nums.length/2 && index < nums.length){
            if(!sel[nums[index]]) {
                sel[nums[index]] = true;
                count++;
            }
            index++;
        }
        answer=count;
        return answer;
    }
}