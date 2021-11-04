import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        char[] ch = dartResult.toCharArray();

        Stack<Integer> reverseNum = new Stack();
        int[] point = new int[3];
        int pointIndex = 0;
        
        HashMap<String, Integer> map = new HashMap();
        map.put("S", 1);
        map.put("D", 2);
        map.put("T", 3);
        
        for(int i=0; i<ch.length; i++){
            if(ch[i] >= '0' && ch[i] <= '9'){
                reverseNum.push((int)ch[i]);
            }
            else if (ch[i] >= 'A' && ch[i] <= 'Z'){
                 int num = 0;
                int multi = 1;

                while(!reverseNum.isEmpty()){
                    num += (reverseNum.pop()-'0') * multi;
                    multi *= 10;
                }

                //System.out.print("num Before : " + num);
                //System.out.print(" ch[i] : " + String.valueOf(ch[i]));
                int square = map.get(String.valueOf(ch[i]));

                //System.out.println(" square : " + square);
                int temp = 1;
                for(int j=0; j<square; j++){
                    temp *= num;
                }
                num = temp;

                //System.out.println("num After : " + temp);
                point[pointIndex++] = num;
            }
            else if(ch[i] == '#'){
                point[pointIndex-1] *= -1;
            }
            else if(ch[i] == '*'){
                for(int j=pointIndex-1; j>=0 && pointIndex-3 < j; j--){
                    point[j] *= 2;
                }
            }
            
            // for(int j=0; j<3; j++){
            //     System.out.print(point[j] + " ");
            // }
            // System.out.println();
        }
        
        for(int i=0; i<3; i++){
            answer += point[i];
        }
        return answer;
    }
}