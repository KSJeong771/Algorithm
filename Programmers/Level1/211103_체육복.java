//https://programmers.co.kr/learn/courses/30/lessons/42862

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        boolean[] canLend = new boolean[n];
        for(int i=0; i<reserve.length; i++){
            canLend[reserve[i]-1] = true;
        }
        
        boolean[] lost2 = new boolean[n];
        for(int i=0; i<lost.length; i++){
            if(canLend[lost[i]-1]){
                canLend[lost[i]-1]= false;
                lost2[lost[i]-1]= false;
            }
            else{
                lost2[lost[i]-1]= true;
            }
        }
        
        // for(int i=0; i<n; i++){
        //     if(canLend[i])
        //         System.out.print(i+1);
        //     else
        //         System.out.print(0);
        // }
        // System.out.println();
        // for(int i=0; i<n; i++){
        //     if(lost2[i])
        //         System.out.print(i+1);
        //     else
        //         System.out.print(0);
        // }
        
        for(int i=0; i<n; i++){
            if(!lost2[i]){
               continue; 
            }
            
            
            int before = i - 1;
            if(before >= 0){
                if(canLend[before]){
                    canLend[before] = false;
                    lost2[i] = false;
                    continue;
                }
            }
            
            int after = i + 1;
            if(after < n){
                if(canLend[after]){
                    canLend[after] = false;
                    lost2[i] = false;
                    continue;
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<n; i++){
            if(lost2[i])
                count++;
        }
        
        answer = n-count;
        return answer;
    }
}