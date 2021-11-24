//https://programmers.co.kr/learn/courses/30/lessons/12980#

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while(n > 0){
            if(n % 2 != 0) ans++;
            n /= 2;
        }
        
        return ans;
    }
    
    //시간, 메모리 초과
//     public int solution(int n) {
//         int ans = 0;
//         int[] arr = new int[n+1];
//         for(int i=0; i<=n; i++){
//             arr[i] = i;
//         }
//         arr[0] = 1;
        
        
//         for(int i=1; i<=n; i++){
//             for(int j=i; j<=n; j++){
//                 arr[j] = Math.min(arr[j], arr[i]+j-i);
//             }
//             for(int j=i*2; j<=n; j*=2){
//                 arr[j] = Math.min(arr[j], arr[j/2]);
//             }
//         }
        
//         ans = arr[n];
//         return ans;
//     }
}