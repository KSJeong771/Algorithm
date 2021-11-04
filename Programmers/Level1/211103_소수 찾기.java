//https://programmers.co.kr/learn/courses/30/lessons/12921

class Solution {
    public int solution(int n) {
        int answer = 0;

        boolean[] noPrime = new boolean[n+1];
        noPrime[0] = true;
        noPrime[1] = true;

        //n 이하의 모든 숫자를 대상으로
        for(int number=2; number<=n; number++){
            //소수가 아니라고 마킹되어 있으면 다음 숫자로
            if(noPrime[number])
                continue;

            //현재 숫자가 소수인지 판별
            if(!isPrime(number))
                continue;

            //소수 카운팅
            answer++;

            //소수의 배수들은 소수가 아니다
            int primeNumber = number;
            int arrayMaxIndex = n;
            int multipleIndex = 2;
            int multipleNumber = primeNumber * multipleIndex;
            while(multipleNumber <= arrayMaxIndex) {
                noPrime[multipleNumber] = true;
                multipleIndex++;
                multipleNumber = primeNumber * multipleIndex;
            }
        }
        return answer;
    }

    public static boolean isPrime(int number) {
        boolean result = true;

        for(int j=2; j*j<=number; j++){
            if(number % j == 0){
                return false;
            }
        }

        //System.out.println(number + " is prime.");

        return result;
    }
}