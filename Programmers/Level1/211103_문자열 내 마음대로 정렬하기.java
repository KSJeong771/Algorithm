//https://programmers.co.kr/learn/courses/30/lessons/12915

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings, new IndexComparator(n));
        answer = strings;
        
        return answer;
    }
    
    class IndexComparator implements Comparator<String> {
        int index = 0;
        
        public IndexComparator(int index){
            this.index = index;
        }
        
        @Override public int compare(String o1, String o2) {
            if (o1.charAt(index) - o2.charAt(index) == 0){
                int newindex = 0;
                while(index < o1.length()){
                    if(o1.charAt(newindex) - o2.charAt(newindex) != 0){
                        return o1.charAt(newindex) - o2.charAt(newindex);
                    }
                    newindex++;
                }
                return 0;
            }
            else{
                return o1.charAt(index) - o2.charAt(index);
            }
        }
    }
}