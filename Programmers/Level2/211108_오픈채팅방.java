//https://programmers.co.kr/learn/courses/30/lessons/42888

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        LinkedList<String> list = new LinkedList();
        HashMap<String, String> idNick = new HashMap();
        for(int i=0; i<record.length; i++){
            var spl = record[i].split(" ");
            
            switch(spl[0]){
                case "Enter":
                    idNick.put(spl[1], spl[2]);
                    break;
                case "Leave":
                    break;
                case "Change":
                    idNick.put(spl[1], spl[2]);
                    break;
            }
        }
        
        for(int i=0; i<record.length; i++){
            var spl = record[i].split(" ");
            
            switch(spl[0]){
                case "Enter":
                    list.add(idNick.get(spl[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    list.add(idNick.get(spl[1]) + "님이 나갔습니다.");
                    break;
                case "Change":
                    break;
            }
        }
        
        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
}