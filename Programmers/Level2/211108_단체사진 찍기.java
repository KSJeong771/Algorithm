//https://programmers.co.kr/learn/courses/30/lessons/1835

import java.util.*;

class Solution {

    String[] gdata;
    public int solution(int n, String[] data) {
        int answer = 0;
        map = new HashMap();
        String input = "ACFJMNRT";
        gdata = data;
        asd("", input);

        System.out.println(map.size());
        answer = map.size();
        return answer;
    }

    HashMap<String, Integer> map;

    public void asd(String left, String right){
        //재귀 끝 조건
        if(right.length() == 0){
            map.put(left, 1);
            return;
        }

        for(int i=0; i<right.length(); i++){
            //문자열 붙이기
            String newLeft = left + Character.toString(right.charAt(i));

            boolean success = true;

            //조건으로 거르기
            for(var data : gdata){
                char start = data.charAt(0);
                char end = data.charAt(2);
                char condition = data.charAt(3);
                int num = Integer.parseInt(data.substring(4, data.length()));

                //조건 문자가 모두 있는 경우에만 체크
                if (newLeft.indexOf(start) == -1 || newLeft.indexOf(end) == -1){
                    continue;
                }

                int len = Math.abs(newLeft.indexOf(start)-newLeft.indexOf(end))-1;
                switch(data.charAt(3)){
                    case '=':
                        if(len != num){
                            success = false;
                            continue;
                        }
                        break;
                    case '>':
                        if(len <= num){
                            success = false;
                            continue;
                        }
                        break;
                    case '<':
                        if(len >= num){
                            success = false;
                            continue;
                        }
                        break;
                }
            }

            if(!success)
                continue;

            //원소 1개 뺀 문자열 만들기
            String newRight = "";
            for(int j=0; j<right.length(); j++){
                if(j == i){
                    continue;
                }

                newRight += Character.toString(right.charAt(j));
            }

            //재귀호출
            asd(newLeft, newRight);
        }
    }
}
