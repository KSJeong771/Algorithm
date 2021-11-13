//https://programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //brown = 2w + 2h - 4
        //yellow = w*h - brown
        //w*h = yellow + brown
        //w+h = (brown+4)/2
        //w+h = brown/2 + 2
        
        //두 수의 합이 brown/2 + 2인 모든 수를 대상으로
        //두 수의 곱이 yellow + brown 조건을 만족하는지 조사
        
        //System.out.println("width+height : " + (brown/2+2));
        //System.out.println("width*height : " + (yellow + brown));
        for(int i=1; i<=brown/2+2; i++){
            int left = i;
            int right = brown/2+2 - i;
            //System.out.println("left : " + left + " right : " + right);
            
            if(left * right == yellow + brown){
                answer[0] = right;
                answer[1] = left;
                return answer;
            }
        }
        
        return answer;
    }
}