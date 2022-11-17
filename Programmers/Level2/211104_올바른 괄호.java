//https://programmers.co.kr/learn/courses/30/lessons/12909

import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> brackets = new Stack();
        
        for (var ch : s.toCharArray()) {
            if (brackets.isEmpty()) {
                if (ch == ')') {
                    return false;
                }
                
                brackets.push(ch);
                continue;
            }
            
            if (ch == ')' && brackets.peek() == '(') {
                brackets.pop();
            } else {
                brackets.push(ch);
            }
            
        }

        return brackets.isEmpty();
    }
}