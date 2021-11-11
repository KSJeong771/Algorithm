//https://programmers.co.kr/learn/courses/30/lessons/42577

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s2.length()-s1.length();
            }
        });
            
        HashMap<String, Integer> map = new HashMap();
        for(int i=0; i<phone_book.length; i++){
            if(map.get(phone_book[i]) != null){
                //System.out.println("not null " + map.get(phone_book[i]));
                answer = false;
            }
            
            int length = phone_book[i].length();
            for(int j=0; j<length; j++){
                map.put(phone_book[i].substring(0, length-j), 1);
                //System.out.println(phone_book[i].substring(0, length-j));
            }
        }
        
        return answer;
    }
}