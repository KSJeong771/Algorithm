//https://programmers.co.kr/learn/courses/30/lessons/12909

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack();
        for(char ch : s.toCharArray()){
            if(stack.isEmpty()){
               stack.push(ch);
               continue;
            }
            
            if(ch == '('){
                stack.push(ch);
            }
            else if (ch == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }

        return stack.isEmpty();
    }
}