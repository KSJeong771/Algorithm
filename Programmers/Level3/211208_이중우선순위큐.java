//https://programmers.co.kr/learn/courses/30/lessons/42628

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        var list = new ArrayList<Integer>();
        
        for(String operation : operations){
            String op = operation.split(" ")[0];
            String value = operation.split(" ")[1];
            if(op.equals("I")){
                list.add(Integer.parseInt(value));
            }
            else{
                if(list.size() == 0)
                    continue;
                
                if(value.equals("1")){
                    int maxValue = -987654321;
                    int maxIndex = -1;
                    for(int i=0; i<list.size(); i++){
                        if(maxValue < list.get(i)){
                            maxValue = list.get(i);
                            maxIndex = i;
                        }
                    }
                    
                    if(maxIndex >= 0)
                        list.remove(maxIndex);
                }
                else{
                    int minValue = 987654321;
                    int minIndex = -1;
                    for(int i=0; i<list.size(); i++){
                        if(minValue > list.get(i)){
                            minValue = list.get(i);
                            minIndex = i;
                        }
                    }
                    
                    if(minIndex >= 0)
                        list.remove(minIndex);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = -987654321;
        answer[1] = 987654321;
        
        for(int i=0; i<list.size(); i++){
            answer[0] = Math.max(answer[0], list.get(i));
            answer[1] = Math.min(answer[1], list.get(i));
        }
        
        if(answer[0] == -987654321)
            answer[0] = 0;
        
        if(answer[1] == 987654321)
            answer[1] = 0;
            
        return answer;
    }
}