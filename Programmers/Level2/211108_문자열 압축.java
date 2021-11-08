//https://programmers.co.kr/learn/courses/30/lessons/60057

import java.util.*;
class Solution {
    class WordCount{
        String word;
        int count;
        public WordCount(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String s) {
        int answer = 987654321;
        
        for(int number=1; number<=s.length(); number++){
            Stack<WordCount> stack = new Stack();
            for(int inputStringIndex = 0; inputStringIndex < s.length(); inputStringIndex+=number){

                String temp = "";
                for(int i=inputStringIndex; i<inputStringIndex+number && i<s.length(); i++){
                    temp += s.charAt(i);
                }

                if(stack.isEmpty()){
                    stack.push(new WordCount(temp, 1));
                    continue;
                }

                var lastElement = stack.peek();
                if(!lastElement.word.equals(temp)){
                    stack.push(new WordCount(temp, 1));
                }
                else {
                    stack.set(stack.size()-1, new WordCount(lastElement.word, lastElement.count+1));
                }
            }

            int count = 0;
            String temp2 = "";
            while(!stack.isEmpty()){
                var v = stack.pop();

                if(v.count <= 1){
                    count += v.word.length();
                }
                else{
                    int 자릿수 = 1;
                    while(v.count >= 10){
                        if(v.count / 10 > 0)
                            자릿수++;
                        v.count /= 10;
                    }
                    count += (v.word.length() + 자릿수);
                }
            }
            
            answer = Math.min(answer, count);
        }
        
        
        return answer;
    }
}