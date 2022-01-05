//https://programmers.co.kr/learn/courses/30/lessons/64062#

class Solution {
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = 200000000;
        int mid = (left + right)  2;
        
        while(left = right){
            boolean canAcross = true;
            int niniz = mid;
            
            int underZeroLength = 0;
            for(int i=0; istones.length; i++){
                if(stones[i] - niniz  0) {
                    if(++underZeroLength = k) {
                        canAcross = false;
                        break;
                    }
                }
                else underZeroLength = 0;
            }
            
            if(!canAcross)
                right = mid - 1;
            else
                left = mid + 1;
            
            mid = (left + right)  2;
        }
        
        return mid;
    }
}


시간초과
 class Solution {
     public int solution(int[] stones, int k) {
         징검다리를 건널 수 없는 니니즈가 나올 때까지
         int niniz = 0;
         while(true){
             단계마다 모든 stones는 반드시 1씩 감소한다.
             - 어떤 단계의 니니즈가 출발했을 때, 반드시 그 단계 미만의 돌은 이미 침몰해있다.
            
             int underZeroLength = 0;
             완탐을 해야 하는가 매번 20만을 돌아야 한다.
             for(int i=0; istones.length; i++){
                 int temp = stones[i] - niniz;
                
                 if(temp  0) {
                     underZeroLength++;
                     if(underZeroLength = k) return niniz-1;
                 }
                 else underZeroLength = 0;
             }
            
             niniz++;
         }
     }
 }