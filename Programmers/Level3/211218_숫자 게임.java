//https://programmers.co.kr/learn/courses/30/lessons/12987

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int indexB = 0;
        for(int indexA=0; indexA<A.length; indexA++){
            // System.out.println("indexA : " + indexA + " value : " + A[indexA]);
            while(indexB < B.length){
                // System.out.println("indexB : " + indexB + " value : " + B[indexB]);
                if(A[indexA] < B[indexB++]){
                    // System.out.println("hit!");
                    answer++;
                    break; 
                }
            }            
        }
        
        
        return answer; 
    }
}