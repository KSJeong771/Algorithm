//https://school.programmers.co.kr/learn/courses/30/lessons/131128

import java.util.*;

class Solution {
    public String solution(String X, String Y) {
                    
        int[] numbersX = new int[10];
        int[] numbersY = new int[10];
        for (int i=0; i<X.length(); i++) {
            numbersX[X.charAt(i)-'0']++;
        }
        for (int i=0; i<Y.length(); i++) {
            numbersY[Y.charAt(i)-'0']++;
        }
        
//         for (int i=0; i<10; i++) {
//             System.out.print(numbersX[i] + " ");
//         }
//         System.out.println();
//         for (int i=0; i<10; i++) {
//             System.out.print(numbersY[i] + " ");
//         }
        
        // 가장 큰 정수 구하기
        StringBuilder answer = new StringBuilder();
        for (int i=9; i>=0; i--) {
            if (i == 0) {
                if (answer.length() == 0) {
                    if (Math.min(numbersX[i], numbersY[i]) == 0) {
                        return "-1";
                    }
                    return "0";
                }
            }
            for (int j=0; j<Math.min(numbersX[i], numbersY[i]); j++) {
                answer.append(i);
            }
        }
        
        return answer.toString();
    }
}