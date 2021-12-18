//https://programmers.co.kr/learn/courses/30/lessons/70130

class Solution {
    public int solution(int[] a) {
        int[] visited = new int[500001];
        int[] count = new int[500001];
        
        for(int i=0; i<a.length; i++){
            count[a[i]]++;
        }
        
        int max = 0;
        for(int i=0; i<a.length; i++){
            if(visited[a[i]] > 0) continue;
            if(count[a[i]] * 2 <= max) continue;
            
            visited[a[i]] = 1;
            max = Math.max(max, getStarLength(a[i], a));
        }
        
        return max;
    }
    
    public int getStarLength(int target, int[] a){
        int count = 0;
        int temp = -1;
        
        for(int i=0; i<a.length; i++){
            //스택에 먼저 보이는 원소 넣음
            if(temp == -1){
                temp = a[i];
                continue;
            }
            
            //스택에 넣은게 스타수열 대상이면 다른것을 찾는다
            if(temp == target){
                if(a[i] != target){
                    temp = -1;
                    count++;
                }
            }
            //스택에 넣은게 스타수열 대상이 아니면 스타수열 대상을 찾는다
            else{
                if(a[i] == target){
                    temp = -1;
                    count++;
                }
            }
        }
        
        return count * 2;
    }
}

//시간초과
// import java.util.*;

// class Solution {
//     public int solution(int[] a) {
//         int[] visited = new int[500001];
//         int max = 0;
//         for(int i=0; i<a.length; i++){
//             if(visited[a[i]] > 0) continue;
//             visited[a[i]] = 1;
//             max = Math.max(max, getStarLength(a[i], a));
//         }
        
//         return max;
//     }
    
//     public int getStarLength(int target, int[] a){
//         int count = 0;
//         Stack<Integer> stack = new Stack();
        
//         for(int i=0; i<a.length; i++){
//             int currentNumber = a[i];
            
//             //스택에 먼저 보이는 원소 넣음
//             if(stack.isEmpty()){
//                 stack.push(currentNumber);
//                 continue;
//             }
            
//             //스택에 넣은게 스타수열 대상이면 다른것을 찾는다
//             if(stack.peek() == target){
//                 if(currentNumber != target){
//                     stack.pop();
//                     count++;
//                 }
//             }
//             //스택에 넣은게 스타수열 대상이 아니면 스타수열 대상을 찾는다
//             else{
//                 if(currentNumber == target){
//                     stack.pop();
//                     count++;
//                 }
//             }
//         }
        
//         return count * 2;
//     }
// }