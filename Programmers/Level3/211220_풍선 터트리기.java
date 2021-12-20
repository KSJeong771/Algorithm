//https://programmers.co.kr/learn/courses/30/lessons/68646

class Solution {
    public int solution(int[] a) {
        if(a.length <= 2) 
            return a.length;
        
        int[] minLeft = new int[a.length];
        int[] minRight = new int[a.length];
        
        //left
        minLeft[0] = 1000000000;
        for(int i=1; i<a.length; i++){
            minLeft[i] = Math.min(minLeft[i-1], a[i-1]);
        }

        //right
        minRight[a.length-1] = 1000000000;
        for(int i=a.length-2; i>=0; i--){
            minRight[i] = Math.min(minRight[i+1], a[i+1]);
        }

        int count = 0;
        for(int i=0; i<a.length; i++){
            if(minLeft[i] < a[i] && a[i] > minRight[i]){
            // System.out.println("NO minLeft : " + minLeft[i] + " a[i] : " + a[i] + " minRight : " + minRight[i]);
            }
            else{
            // System.out.println("YES minLeft : " + minLeft[i] + " a[i] : " + a[i] + " minRight : " + minRight[i]);
                count++;
                
            }
        }
            
//         for(int i=1; i<a.length-1; i++){
//             if(a[i] > minLeft && a[i] > minRight){
//                 continue;
//             }
//             count++;
//         }        
        
        return count;
    }
}

//시간초과
// class Solution {
//     public int solution(int[] a) {
//         if(a.length <= 2) 
//             return a.length;
        
//         //양쪽으로 나눠서 min값을 뽑음
//         //양쪽의 min값이 모두 살리고 싶은 숫자보다 작다면
//         //그 숫자는 살릴 수 없다
        
//         //양끝단 숫자는 무조건 살릴 수 있다.
//         int count = 2;
//         for(int i=1; i<a.length-1; i++){
//             //left
//             int minLeft = 987654321;
//             for(int j=0; j<=i-1; j++){
//                 minLeft = Math.min(minLeft, a[j]);
//             }
            
//             //right
//             int minRight = 987654321;
//             for(int j=i+1; j<a.length; j++){
//                 minRight = Math.min(minRight, a[j]);
//             }
            
            
//             if(a[i] > minLeft && a[i] > minRight){
                
//                 // System.out.println("NO minLeft : " + minLeft + " current : " + a[i] + " minRight : " + minRight);
//                 continue;
//             }
            
//                 // System.out.println("YES minLeft : " + minLeft + " current : " + a[i] + " minRight : " + minRight);
//             count++;
//         }        
        
//         return count;
//     }
// }