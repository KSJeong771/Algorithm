//https://programmers.co.kr/learn/courses/30/lessons/17686

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, new Comparator<String>(){
           @Override
            public int compare(String s1, String s2){
                s1 = s1.toUpperCase();
                int start1 = getNumStartIndex(s1);
                int end1 = getNumEndIndex(s1);
                String head1 = s1.substring(0, start1);
                int number1 = Integer.parseInt(s1.substring(start1, end1+1));
                String tail1 = s1.substring(end1+1, s1.length());
                
                s2 = s2.toUpperCase();
                int start2 = getNumStartIndex(s2);
                int end2 = getNumEndIndex(s2);
                String head2 = s2.substring(0, start2);
                int number2 = Integer.parseInt(s2.substring(start2, end2+1));
                String tail2 = s2.substring(end2+1, s2.length());
                
            //System.out.println(head1 + " : " + head2);
                if(!head1.equals(head2)){
                    return head1.compareToIgnoreCase(head2);
                }
            //System.out.println(number1 + " : " + number2);
                if(number1 != number2){
                    return number1 - number2;
                }
                
                return 0;
            }
        });
        
        //for(var v : files)
        //    System.out.println(v);
        
        return files;
    }
    
    public int getNumStartIndex(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                return i;
        }
        
        return s.length()-1;
    }
    
    public int getNumEndIndex(String s){
        boolean findNum = false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                findNum = true;
            else{
                if(!findNum)
                    continue;
                else
                    return i-1;
            }
        }
        
        return s.length()-1;
    }
}