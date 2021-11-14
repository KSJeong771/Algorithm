//https://programmers.co.kr/learn/courses/30/lessons/67257

import java.util.*;

class Solution {
    
    public long solution(String expression) {
        long answer = 0;
        
        //6가지 경우의 수
        String[] opPriorities = {"*-+", "*+-", "-+*", "-*+", "+*-", "+-*"};
        
        for(String opPriority : opPriorities){
            var numbers = parseNumbers(expression);
            var operators = parseOperators(expression);
            
            //3개의 연산자 처리 단계
            for(int opPhase=0; opPhase<3; i++){
                char currentOperator = opPriority.charAt(opPhase);
                
                for(int i=0; j<operators.size(); i++){
                    //현재 단계와 일치하는 연산자만 처리
                    if(operators.get(i) != currentOperator)
                        continue;
                    
                    //연산자와 숫자를 빼서
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    
                    //계산하고 다시 넣어준다
                    numbers.add(i, calc(numbers.get(i), numbers.get(i+1), currentOperator));
                    
                    //remove로 인해 요소가 하나 줄어들기 때문에 인덱스 조절
                    i--;
                }
            }
            
            answer = Math.max(answer, Math.abs(numbers.get(0)));
        }
        
        return answer;
    }
    
    
    public ArrayList<Long> parseNumbers(String expression){
        ArrayList<Long> numbers = new ArrayList();

        String number = "";
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                number += expression.substring(i, i+1);
            }
            else{
                numbers.add(Long.parseLong(number));
                number = "";
            }
        }
        numbers.add(Long.parseLong(number));
        
        return numbers;
    }
    
    public ArrayList<Character> parseOperators(String expression){
        ArrayList<Character> operators = new ArrayList();

        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                continue;
            }
            else{
                operators.add(expression.charAt(i));
            }
        }
        
        return operators;
    }
    
    public long calc(Long n1, Long n2, char operator){
        switch(operator){
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
        }
        return -1;
    }
}