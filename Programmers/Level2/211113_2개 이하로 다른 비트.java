//https://programmers.co.kr/learn/courses/30/lessons/77885

import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            //짝수
            if(numbers[i] % 2 == 0){
                answer[i] = numbers[i] + 1;
                continue;
            }
            
            //홀수
            //처음 발견한 0을 1로 바꾸고
            //마지막 발견한 1을 0으로 바꾼다
            long zeroIndex = 0;
            long temp = numbers[i];
            while(temp % (long)2 == 1){
                zeroIndex++;
                temp /= (long)2;
            }
            
            answer[i] = numbers[i] + ((long)1 << zeroIndex) - ((long)1 << zeroIndex-1);
            
            //시간초과
//             for(long j=number+1; ; j++){
//                 long or = Long.bitCount(number | j);
//                 long and = Long.bitCount(number & j);
//                 long bitDiff = or - and;
//                 //System.out.println("number : " + number + " j : " + j + " or : " + or + " and : " + and);
                
//                 if(bitDiff >= 1 && bitDiff <= 2){
//                     answer[i] = j;
//                     break;
//                 }
//             }
        }
        
        return answer;
    }
}