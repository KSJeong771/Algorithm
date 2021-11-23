//https://programmers.co.kr/learn/courses/30/lessons/17684

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> indexes = new ArrayList();
        
        // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
        ArrayList<String> dic = initializeDictionary();
            
        for(int i=0; i<msg.length(); i++){
            var current = msg.substring(i, msg.length());
            //System.out.println("i : " + i + " 현재 입력 : " + current);
            
            for(int j=dic.size()-1; j>=0; j--){
                String w = dic.get(j);
                
                // 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다
                if(!current.startsWith(w))
                    continue;
                
                //System.out.println("가장 긴 문자열 w : " + w);

                // 3. w에 해당하는 사전의 색인 번호를 출력하고 
                indexes.add(j+1);
                //System.out.println("w에 해당하는 사전의 색인 번호 : " + (j+1));

                // 3. 입력에서 w를 제거한다.
                i += (w.length()-1);

                if(i+1 >= msg.length())
                    break;
                                               
                // 4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
                dic.add(msg.substring(i-(w.length()-1), i+2));
                //System.out.println("w+c에 해당하는 단어를 사전에 등록 : " + msg.substring(i-(w.length()-1), i+2));
            
                //5. 단계 2로 돌아간다.
                break;
            }
        }
        
        int[] answer = new int[indexes.size()];
        int index = 0;
        for(var v : indexes)
            answer[index++] = v;
        
        return answer;
    }
    
    // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
    public ArrayList<String> initializeDictionary(){
        ArrayList<String> dic = new ArrayList();
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0; i<alphabet.length(); i++){
            dic.add(alphabet.substring(i, i+1));
        }
        
        return dic;
    }
}