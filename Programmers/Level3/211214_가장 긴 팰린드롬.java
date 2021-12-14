//https://programmers.co.kr/learn/courses/30/lessons/12904

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
    
        //모든 문자열을 기준으로 시도해볼 수 있음
        //양 옆을 계속 비교하면서 확장
        char[] chArr = s.toCharArray();
        
        //가운데 문자가 홀수개일 경우
        for(int i=0; i<chArr.length; i++){
            int palindromeLength = 1;
            int backwardIndex = i;
            int forwardIndex = i;
            while(--backwardIndex >= 0 && ++forwardIndex < chArr.length){
                if(chArr[backwardIndex] != chArr[forwardIndex])
                    break;
                
                palindromeLength += 2;
            }
            
            
            answer = Math.max(answer, palindromeLength);
        }

        //가운데 문자가 짝수개일 경우
        for(int i=0; i<chArr.length-1; i++){
            if(chArr.length <= 1)
                break;
            
            if(chArr[i] != chArr[i+1])
                continue;
            
            int palindromeLength = 2;
            int backwardIndex = i;
            int forwardIndex = i+1;
            while(--backwardIndex >= 0 && ++forwardIndex < chArr.length){
                if(chArr[backwardIndex] != chArr[forwardIndex])
                    break;
                
                palindromeLength += 2;
            }
            
            
            answer = Math.max(answer, palindromeLength);
        }
        
        return answer;
    }
}