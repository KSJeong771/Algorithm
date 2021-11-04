//https://programmers.co.kr/learn/courses/30/lessons/12953

class Solution {
    public int solution(int[] arr) {
        int[] measure = new int[101];
        measure[1] = 1;
        
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            int div = 2;
            int count = 0;
            while(num > 1){
                if(num % div == 0){
                    count++;
                    measure[div] = Math.max(measure[div], count);
                    num /= div;
                }else{
                    count = 0;
                    div++;
                }
            }
        }
        int answer = 1;
        for(int i=1; i<measure.length; i++){
            if (measure[i] > 0){
                //System.out.println("i : " + i + ", measure[i] : " + measure[i]);
                answer *= Math.pow(i, measure[i]);
            }
        }
        return answer;
    }
}