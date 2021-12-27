//https://programmers.co.kr/learn/courses/30/lessons/77886#

import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0; i<s.length; i++){
            int count110 = 0;
            
            Stack<Character> stack = new Stack();
            for(int j=0; j<s[i].length(); j++){
                char ch = s[i].charAt(j);
                
                //check stack
                if(stack.size() >= 2){
                    if(ch == '0' && stack.get(stack.size()-1) == '1' && stack.get(stack.size()-2) == '1'){
                        count110++;
                        stack.pop();
                        stack.pop();
                        continue;
                    }
                }
                
                stack.push(ch);
            }
            
            StringBuilder sb = new StringBuilder();
            for(char ch : stack){
                sb.append(ch);
            }
            String removed110 = sb.toString();
            
            StringBuilder str = new StringBuilder();
            
            //left
            int lastZeroIndex = removed110.length()-1;
            while((lastZeroIndex >= 0) && removed110.charAt(lastZeroIndex) == '1'){
                lastZeroIndex--;
            }
            str.append(removed110.substring(0, lastZeroIndex+1));
            
            //center
            while(count110-- > 0){
                str.append("110");
            }
            
            //right
            str.append(removed110.substring(lastZeroIndex+1, removed110.length()));
            
            answer[i] = str.toString();
        }
        
        return answer;
    }
}

// class Solution {
//     public String[] solution(String[] s) {
//         String[] answer = new String[s.length];
        
//         for(int i=0; i<s.length; i++){
//             String removed110 = s[i];
//             int count110 = 0;
            
//             int beforeLength;
//             int afterLength;
//             do{
//                 beforeLength = removed110.length();
//                 removed110 = removed110.replace("110", "");
//                 afterLength = removed110.length();
//                 count110 += (beforeLength - afterLength) / 3;
//             }
//             while(beforeLength - afterLength != 0);
            
//             StringBuilder str = new StringBuilder();
            
//             //left
//             int lastZeroIndex = removed110.length()-1;
//             while((lastZeroIndex >= 0) && removed110.charAt(lastZeroIndex) == '1'){
//                 lastZeroIndex--;
//             }
//             str.append(removed110.substring(0, lastZeroIndex+1));
            
//             //center
//             while(count110-- > 0){
//                 str.append("110");
//             }
            
//             //right
//             str.append(removed110.substring(lastZeroIndex+1, removed110.length()));
            
//             answer[i] = str.toString();
//         }
        
//         return answer;
//     }
// }



// class Solution {
//     public String[] solution(String[] s) {
//         String[] answer = new String[s.length];
        
//         for(int i=0; i<s.length; i++){
//             // System.out.println("-------------");
            
//             String removed110 = s[i];
//             int count110 = 0;
            
//             //110 문자열을 전부 뽑아낸 다음 배치를 결정한다.
//             while(removed110.indexOf("110") >= 0){
//                 int beforeLength = removed110.length();
//                 removed110 = removed110.replace("110", "");
//                 int afterLength = removed110.length();
//                 count110 += (beforeLength - afterLength) / 3;
//             }
            
//             // System.out.println("removed110 : " + removed110 + " count110 : " + count110);
            
            
//             if(removed110.charAt(removed110.length()-1) == '1'){
//                 //가장 뒷자리에 1이 나오면 연속하는 1의 앞에 모든 110을 배치한다.
//                 int index = removed110.length()-1;
//                 while((index >= 0) && removed110.charAt(index) == '1'){
//                     index--;
//                 }
                
//                 String left = "";
//                 String right = removed110;
//                 if(index >= 0){
//                     left = removed110.substring(0, index+1);
//                     right = removed110.substring(index+1, removed110.length());
//                 }
                
//                 String center = "";
//                 while(count110 > 0){
//                     center += "110";
//                     count110--;
//                 }
//                 // System.out.println("left : " + left + " right : " + right);
//                 answer[i] = left + center + right;
//             }
//             else{
//                 //가장 뒷자리에 0이 나오면 뒤에 모든 110을 배치한다.
//                 answer[i] = removed110;
//                 while(count110 > 0){
//                     answer[i] += "110";
//                     count110--;
//                 }
//             }
//         }
//         return answer;
//     }
// }


// class Solution {
//     public String[] solution(String[] s) {
//         String[] answer = new String[s.length];
        
//         for(int i=0; i<s.length; i++){
//             String binaryString = s[i];
//             int index111 = binaryString.indexOf("111");
//             int index110 = binaryString.lastIndexOf("110");
//             int gap = index110-index111 > 3 ? 3 : index110-index111;
            
//             while((index111 >= 0 && index110 >= 0) && (gap > 0)){
//                 // System.out.println("index111 : " + index111 + " index110 : " + index110);
                
//                 //divide
//                 String left = binaryString.substring(0, index111+3);
//                 String right = binaryString.substring(index111, binaryString.length());
//                 // System.out.println("divide left : " + left + " right : " + right);
                
//                 //replace
//                 left = left.replace("111", "110");
                
//                 String right1 = right.substring(0, right.lastIndexOf("110"));
//                 String right2 = right.substring(right.lastIndexOf("110")+3, right.length());
                               
//                 right = right1 + right2;
//                 right = right.substring(gap, right.length());
//                 // System.out.println("replace left : " + left + " right : " + right + " gap : ");
                
//                 //attach
//                 String center = "";
//                 while(gap-- > 0)
//                     center += "1";
                
//                 //merge
//                 binaryString = left + center + right;
//                 // System.out.println("attach&merge binaryString : " + binaryString);
                
//                 //next step
//                 index111 = binaryString.indexOf("111");
//                 index110 = binaryString.lastIndexOf("110");
//                 gap = index110-index111 > 3 ? 3 : index110-index111;
//                 // System.out.println("next step index111 : " + index111 + " index110 : " + index110);
//             }
            
//             answer[i] = binaryString;
//         }
//         return answer;
//     }
// }