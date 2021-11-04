//https://programmers.co.kr/learn/courses/30/lessons/42889

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] reached = new int[N+1];
        int[] reachedNotClear = new int[N+1];
        for(int i=0;i<stages.length; i++){
            for(int j=1; j<=stages[i]; j++){
                reached[j-1]++;
            }
            reachedNotClear[stages[i]-1]++;
        }
        
        // for(int i=0; i<N+1; i++){
        //     System.out.print(reached[i] + " ");
        // }
        // System.out.println();
        // for(int i=0; i<N+1; i++){
        //     System.out.print(reachedNotClear[i] + " ");
        // }
        // System.out.println();
        
        ForSort[] fsort = new ForSort[N];
        for(int i=0; i<N; i++){
            if(reached[i] == 0){
                fsort[i] = new ForSort(0.0, i);
                continue;
            }
            else{
                fsort[i] = new ForSort((double)reachedNotClear[i]/(double)reached[i], i);
            }
        }
        
        
//         for(int i=0; i<N; i++){
//             System.out.print(fsort[i].clearRate + " ");
//         }
//         System.out.println();
//         for(int i=0; i<N; i++){
//             System.out.print(fsort[i].index + " ");
//         }
//         System.out.println();
        
        Arrays.sort(fsort);
        
//         for(int i=0; i<N; i++){
//             System.out.print(fsort[i].clearRate + " ");
//         }
//         System.out.println();
//         for(int i=0; i<N; i++){
//             System.out.print(fsort[i].index + " ");
//         }
//         System.out.println();
        
        int[] answer = {};
        answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = fsort[i].index + 1;
        }
        
        return answer;
    }
    
    class ForSort implements Comparable<ForSort>{
        private double clearRate;
        private int index;
        
        public double getClearRate(){
            return this.clearRate;
        }
        
        public ForSort(double c, int i){
            clearRate = c;
            index = i;
        }
        
        @Override
        public int compareTo(ForSort fs) {
            if (this.clearRate > fs.getClearRate()) {
                return -1;
            } else if (this.clearRate < fs.getClearRate()) {
                return 1;
            }
            return 0;
        }
    }
}