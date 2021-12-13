//https://programmers.co.kr/learn/courses/30/lessons/12936#

import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int answerIndex = 0;
        
        ArrayList<Integer> remainingNumbers = new ArrayList();
        for(int i=1; i<=n; i++){
            remainingNumbers.add(i);
        }
        
        k--;
        long[] subsetSize = factorial(n);
        
        int index = 1;
        while(true){
            long size = subsetSize[n-index];
            int removeIndex = (int)(k / size);
            int removedValue = remainingNumbers.get((int)(removeIndex));
            
            answer[answerIndex++] = removedValue;
            remainingNumbers.remove(removeIndex);
            
            if(k == 0) 
                break;
            
            k %= size;
            index++;
        }
        
        
        for(long number : remainingNumbers){
            answer[answerIndex++] = (int)number;
        }
        
        return answer;
    }
    
    public long[] factorial(int n){
        long[] memo = new long[n+1];
        memo[0] = 1;
        memo[1] = 1;
        
        for(int i=2; i<=n; i++){
            memo[i] = memo[i-1] * i;
        }
        
        return memo;
    }
}