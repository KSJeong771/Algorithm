//https://programmers.co.kr/learn/courses/30/lessons/17677

import java.util.*;

class Solution {
    public HashMap<String, Integer> strToMap(String str){
        var map = new HashMap<String, Integer>();
        
        for(int i=0; i<str.length()-1; i++){
            //알파벳만 허용 (현재 문자)
            if(str.charAt(i) < 'A' || str.charAt(i) > 'Z'){
                continue;
            }
            
            //알파벳만 허용 (다음 글자)
            if(str.charAt(i+1) < 'A' || str.charAt(i+1) > 'Z'){
                i++;
                continue;
            }
            
            //2개 문자 묶기
            var substr = str.substring(i, i+2);
            
            //이미 집합에 있다면 카운트 증가
            if(map.get(substr) != null)
                map.put(substr, map.get(substr) + 1);
            //집합에 없다면 추가
            else
                map.put(substr, 1);
        }
        
        // for(var v : map.entrySet())
        //     System.out.print(v.getKey() + v.getValue() + " ");
        // System.out.print("\n");
        
        return map;
    }
    
    public int solution(String str1, String str2) {
        int answer = 0;
        
        var map1 = strToMap(str1.toUpperCase());
        var map2 = strToMap(str2.toUpperCase());
        
        var intersection = new HashMap<String, Integer>();
        var union = new HashMap<String, Integer>();
        
        for(var v : map1.entrySet()){
            //안 겹치면 합집합
            if(map2.get(v.getKey()) == null)
                union.put(v.getKey(), v.getValue());
            //겹치면 합집합 + 교집합
            else{
                union.put(v.getKey(), Math.max(v.getValue(), map2.get(v.getKey())));
                intersection.put(v.getKey(), Math.min(v.getValue(), map2.get(v.getKey())));
            }
        }
        
        for(var v : map2.entrySet()){
            //안 겹치면 합집합
            if(map1.get(v.getKey()) == null)
                union.put(v.getKey(), v.getValue());
            //교집합은 위에서 처리했음
        }
        
        double intersectionSize = 0;
        for(var v : intersection.entrySet())
            intersectionSize += v.getValue();
        
        double unionSize = 0;
        for(var v : union.entrySet())
            unionSize += v.getValue();
        
        // for(var v : intersection.entrySet())
        //     System.out.print(v.getKey() + v.getValue() + " ");
        // System.out.print("\n");
        // for(var v : union.entrySet())
        //     System.out.print(v.getKey() + v.getValue() + " ");
        // System.out.print("\n");
        
        //0으로 나누는 케이스
        if((int)union.size() == 0)
            answer = 65536;
        //65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력
        else
            answer = (int)(intersectionSize / unionSize * (double)65536);
        
        return answer;
    }
}