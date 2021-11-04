//https://programmers.co.kr/learn/courses/30/lessons/17681

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];
        
        for(int i=0; i<n; i++){
            int mapOr = arr1[i] | arr2[i];
            
            char[] chArr = new char[n];
            int div = 2;
            int index = n-1;
            while(mapOr > 0){
            //System.out.print(mapOr + " ");
                if(mapOr % div == 0){
                    chArr[index] = ' ';
                }
                else{
                    chArr[index] = '#';
                }
                mapOr /= div;
                index--;
            }
            
            //System.out.println(String.valueOf(chArr));
            answer[i] = new String(chArr).replaceAll("\u0000", " ");
        }
        
        
        return answer;
    }
}