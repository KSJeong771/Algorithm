//https://programmers.co.kr/learn/courses/30/lessons/17687

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        StringBuilder allNumbers = new StringBuilder();
        int currentNumber = 0;
        
        //게임이 m*t회 진행될 때 까지
        while(allNumbers.length() <= m * t){
            
            //n진법 변환
            int quotient = currentNumber;
            int remainder = quotient;
            int divider = n;
            
            StringBuffer convertedStr = new StringBuffer();
            do{
                remainder = quotient % divider;
                quotient /= divider;
                
                //0~9
                if(remainder <= 9)
                    convertedStr.append(remainder);
                //10~
                else
                    convertedStr.append((char)(65 + (remainder % 10)));
                
            } while(quotient > 0);
            
            allNumbers.append(convertedStr.reverse());
            
            //다음 숫자로
            currentNumber++;
        }
        
        for(int i=p-1; i<m*t; i+=m)
            answer += String.valueOf(allNumbers.charAt(i));
        
        return answer;
    }
}