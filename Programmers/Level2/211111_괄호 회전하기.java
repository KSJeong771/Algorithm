//https://programmers.co.kr/learn/courses/30/lessons/76502

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            //이동
            String rotated = s.substring(i, s.length()) + s.substring(0, i);
            //System.out.println(rotated);
            
            //검사
            if(isCorrect(rotated))
                answer++;
        }
        
        return answer;
    }
    
    
    public boolean isCorrect(String w){
        Stack<Character> stack = new Stack();
        
        for(int i=0; i<w.length(); i++){
            char ch = w.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            
            char pk = stack.peek();
            if(pk == '{' && ch == '}')
                stack.pop();
            else if(pk == '[' && ch == ']')
                stack.pop();
            else if(pk == '(' && ch == ')')
                stack.pop();
            else
                stack.push(ch);
        }
        
        return stack.isEmpty();
    }
    
}