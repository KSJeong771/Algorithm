//https://programmers.co.kr/learn/courses/30/lessons/12911#

class Solution {
    public void printBinary(int n){
        char[] biArr = Integer.toBinaryString(n).toCharArray();
        for(int i=0; i<biArr.length; i++){
            System.out.print(biArr[i]);
        }
        System.out.print(" " + n + "\n");
    }
    
    public int solution(int n) {
        int answer = 0;
        
        char[] biArr = Integer.toBinaryString(n).toCharArray();
        
        int zeroCount = 0;
        int oneCount = 0;
        
        for(int i=biArr.length-1; i>=0; i--){
            if(biArr[i] == '1'){
                oneCount++;
            }else{
                if(oneCount == 0)
                    zeroCount++;
                else
                    break;
            }
        }
        
        
        answer = n;
        //printBinary(answer);
        
        answer += 1 << (zeroCount+oneCount);
        answer -= 1 << (zeroCount+oneCount-1);
        oneCount--;
        //System.out.println("first zero : " + zeroCount + " one : " + oneCount);
        //printBinary(answer);
        
        if(zeroCount == 0){
            //printBinary(answer);
            return answer;
        }
        
        for(int i=0; i<oneCount; i++){
            answer -= 1 << zeroCount+i;
        }
        //System.out.println("second zero : " + zeroCount + " one : " + oneCount);
        //printBinary(answer);
        
        for(int i=0; i<oneCount; i++){
            answer += 1 << i;
        }
        //System.out.println("third zero : " + zeroCount + " one : " + oneCount);
        //printBinary(answer);
        return answer;
    }
}