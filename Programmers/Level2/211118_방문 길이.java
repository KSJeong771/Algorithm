//https://programmers.co.kr/learn/courses/30/lessons/49994

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap();
        
        int x = 0;
        int y = 0;
        
        for(int i=0; i<dirs.length(); i++){
            String from = Integer.toString(y) +","+ Integer.toString(x);
            switch(dirs.charAt(i)){
                case 'U':
                    y--;
                    break;
                case 'D':
                    y++;
                    break;
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
            }
            
            if(y < -5){
                y = -5;
                continue;
            }
            
            if(x < -5){
                x = -5;
                continue;
            }
            
            if(y > 5){
                y = 5;
                continue;
            }
            
            if(x > 5){
                x = 5;
                continue;
            }
            
            String to = Integer.toString(y) +","+ Integer.toString(x);
            map.put("(" + from + ")->(" + to + ")", 1);
            map.put("(" + to + ")->(" + from + ")", 1);
        }
        
        // for(var v : map.entrySet()){
        //     System.out.println(v.getKey());
        // }
        
        return map.size() / 2;
    }
}