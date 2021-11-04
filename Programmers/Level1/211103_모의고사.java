//https://programmers.co.kr/learn/courses/30/lessons/42840

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] count = new int[3];
        int[][] methods = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        
        int index = 0;
        while(index < answers.length){
            //System.out.println("i : " + index + ", methods[0][index%5] : " + methods[0][index%5]);
            if (answers[index] == methods[0][index%5]){
                count[0]++;
            }
            if (answers[index] == methods[1][index%8]){
                count[1]++;
            }
            if (answers[index] == methods[2][index%10]){
                count[2]++;
            }
            index++;
        }
        
        int max = -1;
        for(int i=0; i<3; i++){
            if (count[i] > max){
                max = count[i];
            }
        }
        
        ArrayList<Integer> arr = new ArrayList();
        for(int i=0; i<3; i++){
            if(count[i] == max){
                arr.add(i+1);
            }
        }
        
        Integer[] answer2 = arr.toArray(new Integer[0]);
        answer = Arrays.stream(answer2).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}