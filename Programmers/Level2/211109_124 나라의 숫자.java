//https://programmers.co.kr/learn/courses/30/lessons/12899#

class Solution {
    public String solution(int n) {
        String answer = "";
        String sample = "124";
        
        //0  1  2  4
        //11 12 14 21
        //22 24 41 42
        //44 111 112 114
        
        // 1-1 / 3 = [0], (0  -> 1)
        // 2-1 / 3 = [0], (1  -> 2)
        // 3-1 / 3 = [0], (2  -> 4)
        // 4-1 / 3 = [1], (0  -> 1)    1-1 / 3 = [0], (0  -> 1)    => 11
        // 5-1 / 3 = [1], (1  -> 2)    1-1 / 3 = [0], (0  -> 1)    => 12
        // 6-1 / 3 = [1], (2  -> 4)    1-1 / 3 = [0], (0  -> 1)    => 14 
        
        // 15-1 / 3 = [4], (2 -> 4)
        //  4-1 / 3 = [1], (0 -> 1)
        //  1-1 / 3 = [0], (0 -> 1)
        //  => 114
        
        while(n > 0){
            int idx124 = (n-1) % 3;
            answer += sample.substring(idx124, idx124+1);
            n = (n-1)/3;
            
            //System.out.println("n : " + n + " " + sample.substring(idx124, idx124+1));
            //System.out.println(answer);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        answer = sb.reverse().toString();

        return answer;
    }
}