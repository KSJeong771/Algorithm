//https://programmers.co.kr/learn/courses/30/lessons/49993

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skillTree : skill_trees){
            //중복, 범위 외 값을 제외하고 비교하기
            String temp = "";
            
            //비교를 위한 필터
            ArrayList<Character> filter = new ArrayList();
            for(int i=0; i<skill.length(); i++){
                filter.add(skill.charAt(i));
            }
            
            for(int i=0; i<skillTree.length(); i++){
                char value = skillTree.charAt(i);
                
                if(filter.indexOf(value) != -1){
                    temp += value;
                    
                    //중복을 거르기 위해
                    filter.remove(filter.indexOf(value));
                }
            }
            
            if(skill.startsWith(temp))
                answer++;
        }
        
        return answer;
    }
}