//https://programmers.co.kr/learn/courses/30/lessons/42885

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int smallIndex = 0;
        int bigIndex = people.length - 1;
        
        while(smallIndex <= bigIndex){
            var big = people[bigIndex--];
            answer++;
            
            var acc = big;
            while(smallIndex <= bigIndex){
                acc += people[smallIndex];
                
                if(acc <= limit){
                    smallIndex++;
                }
                else{
                    break;
                }
            }
        }
        
        return answer;
    }
}