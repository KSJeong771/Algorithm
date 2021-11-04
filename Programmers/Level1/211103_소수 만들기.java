//https://programmers.co.kr/learn/courses/30/lessons/12977

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = -1;
        
        LinkedList<Integer> list = new LinkedList();
        
        for(int i=0; i<nums.length; i++){
            int first = nums[i];
            for(int j=i+1; j<nums.length; j++){
                int second = nums[j];
                for(int k=j+1; k<nums.length; k++){
                    int third = nums[k];
                    int sum = first+second+third;
                    boolean isPrime = true;
                    for(int l = 2; l < sum; l++){
                        if (sum % l == 0){
                            isPrime = false;
                            break;                            
                        }
                    }
                    if(isPrime)
                        list.add(sum);
                }
            }
        }
        
        //for(var i : list){
        //    System.out.print(i + " ");
        //}
        answer = list.size();
        return answer;
    }
}