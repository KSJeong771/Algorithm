//https://programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;

class Solution {
    public int[] solution(String s) {
        //최상위 괄호 2겹 제거
        s = s.substring(2, s.length()-2);
        
        // },{ 를 기준으로 문자열 분할 
        String[] splitted = s.split("\\},\\{");
        
        //길이를 기준으로 정렬
        Arrays.sort(splitted, new Comparator<String>(){
           @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        
        ArrayList<Integer> list = new ArrayList();
        boolean[] visited = new boolean[100001]; 
        
        //길이가 작은 집합부터
        for(var str : splitted){
            //모든 숫자를 체크
            for(var numberStr : str.split(",")){
                //아직 튜플에 넣지 않은 숫자를 찾아 튜플에 넣는다
                int number = Integer.parseInt(numberStr);
                if(!visited[number]){
                    visited[number] = true;
                    list.add(number);
                }
            }
        }
        
        //출력 형식 맞추기
        int[] answer = new int[list.size()];
        int index = 0;
        for(var num : list){
            answer[index++] = num;
        }
        
        return answer;
    }
}