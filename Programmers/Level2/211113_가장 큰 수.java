//https://programmers.co.kr/learn/courses/30/lessons/42746

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>(){
           @Override
            public int compare(String a, String b){
                String num1 = a + b;
                String num2 = b + a;
                return Integer.parseInt(num2) - Integer.parseInt(num1);
            }
        });
        
        for(int i=0; i<arr.length; i++){
            if(answer.equals("0") && arr[i].equals("0"))
                continue;
            else
                answer += arr[i];
        }
        
        return answer;
    }
}