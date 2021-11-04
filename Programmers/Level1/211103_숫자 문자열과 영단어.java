//https://programmers.co.kr/learn/courses/30/lessons/81301

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<String, String> hmap = new HashMap<String, String>();
        hmap.put("zero", "0");
        hmap.put("one", "1");
        hmap.put("two", "2");
        hmap.put("three", "3");
        hmap.put("four", "4");
        hmap.put("five", "5");
        hmap.put("six", "6");
        hmap.put("seven", "7");
        hmap.put("eight", "8");
        hmap.put("nine", "9");
        
        var keys = hmap.keySet().iterator();
        while(keys.hasNext()){
            String temp = keys.next();
            s = s.replaceAll(temp, hmap.get(temp));
            //System.out.println("temp : " + temp + ", s : " + s + ", hmap.get(temp) : " + hmap.get(temp));
        }
        
        answer = Integer.parseInt(s);
        return answer;
    }
}