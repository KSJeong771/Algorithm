//https://programmers.co.kr/learn/courses/30/lessons/12985#

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a!=b){
            answer++;
            
            if(a > 1){
                a = (a%2 == 0) ? (a/2) : (a/2 + 1);
            }
            if(b > 1){
                b = (b%2 == 0) ? (b/2) : (b/2 + 1);
            }
            
            
            //System.out.println("a : " + a + " b : " + b);
        }
        
        return answer;
    }
}