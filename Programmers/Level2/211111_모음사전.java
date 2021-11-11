//https://programmers.co.kr/learn/courses/30/lessons/84512

import java.util.*;

class Solution {
    ArrayList<String> dic = new ArrayList();
    public int solution(String word) {
        int answer = 0;
        
        for(int i=0; i<5; i++)
            func(str.substring(i,i+1), 0);
        
        Collections.sort(dic);
        answer = Collections.binarySearch(dic, word)+1;
        
        // for(int i=0; i<dic.size(); i++){
        //     System.out.println(dic.get(i));
        // }
        
        return answer;
    }
    
    String str = "AEIOU";
    public void func(String sel, int depth){
        dic.add(sel);
        
        depth++;
        if(depth >= 5){
            return;
        }
        
        for(int i=0; i<5; i++)
            func(sel + str.substring(i,i+1), depth);
    }
}