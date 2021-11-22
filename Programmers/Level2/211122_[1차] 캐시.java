//https://programmers.co.kr/learn/courses/30/lessons/17680

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        var cache = new LinkedList<String>();
        for(var city : cities){
            city = city.toUpperCase();
            
            int hitIndex = -1;
            int index = 0;
            for(var cacheItem : cache){
                if(cacheItem.equals(city)){
                    hitIndex = index;
                    break;
                }
                index++;
            }
            
            if(hitIndex != -1){
                answer += 1;
                cache.remove(hitIndex);
                //System.out.println("Hit : " + city);
            }
            else{
                answer += 5;
                //System.out.println("not Hit : " + city);
            }
            
            cache.add(city);
            
            if(cache.size() > cacheSize){
                cache.poll();
            }
        }
        
        return answer;
    }
}