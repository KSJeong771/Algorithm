//https://school.programmers.co.kr/learn/courses/30/lessons/118666

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {

        Map<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<survey.length; i++) {
            char typeA = survey[i].charAt(0);
            char typeB = survey[i].charAt(1);
            
            if (choices[i] <= 4) {
                map.put(typeA, map.getOrDefault(typeA, 0) + (4-choices[i]));
            } else {
                map.put(typeB, map.getOrDefault(typeB, 0) + (choices[i]-4));
            }
        }
        
        String answer = "";
        char[][] types = new char[][] {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        for (int i=0; i<4; i++) {
            answer += typeCompare(map, types[i][0], types[i][1]);
        }
        
        return answer;
    }
    
    char typeCompare(Map<Character, Integer> map, char typeA, char typeB) {
        if (map.getOrDefault(typeA, 0) > map.getOrDefault(typeB, 0)) {
            return typeA;
        } else if (map.getOrDefault(typeA, 0) < map.getOrDefault(typeB, 0)) {
            return typeB;
        } else {
            return typeA < typeB ? typeA : typeB;
        }
    }
}