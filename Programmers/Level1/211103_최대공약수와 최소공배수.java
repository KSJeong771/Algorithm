//https://programmers.co.kr/learn/courses/30/lessons/12940

class Solution {
    public long[] solution(long n, long m) {
        int length = (int)Math.max(n, m) + 1;
        long[] an = new long[length];
        long[] am = new long[length];
        
        //1은 기본 약수
        an[1] = 1;
        am[1] = 1;
        
        int div = 2;
        while(n > 1){
            if(n % div == 0){
                n /= div;
                an[div]++;
                //System.out.print(div + " ");
            }else{
                div++;
            }
        }
        //System.out.println("");
        
        div = 2;
        while(m > 1){
            if(m % div == 0){
                m /= div;
                am[div]++;
                //System.out.print(div + " ");
            }else{
                div++;
            }
        }
        //System.out.println("---------");
        
        long[] answer = new long[2];
        long 최소공배수 = 1;
        long 최대공약수 = 1;
        for(int i=0; i<length; i++){
            if(an[i] == 0 && am[i] == 0){
                continue;
            }
            
            if(an[i] > 0 && am[i] > 0){
                long iterator = Math.min(an[i], am[i]);
                while(iterator > 0){
                    최대공약수 *= i;
                    iterator--;
                }
                
                iterator = an[i] + am[i] - Math.min(an[i], am[i]);
                while(iterator > 0){
                    최소공배수 *= i;
                    iterator--;
                }
                //System.out.println("공약수가 있음 i : " + i + " iterator : " + iterator + " 최대공약수 : " + 최대공약수 + " 최소공배수 : " + 최소공배수);
            }
            else{
                long iterator = an[i];
                while(iterator > 0){
                    최소공배수 *= i;
                    iterator--;
                }
                
                iterator = am[i];
                while(iterator > 0){
                    최소공배수 *= i;
                    iterator--;
                }
                //System.out.println("공약수가 없음 i : " + i + " iterator : " + iterator + " 최대공약수 : " + 최대공약수 + " 최소공배수 : " + 최소공배수);
            }
        }
        
        answer[0] = 최대공약수;
        answer[1] = 최소공배수;
        
        return answer;
    }
}