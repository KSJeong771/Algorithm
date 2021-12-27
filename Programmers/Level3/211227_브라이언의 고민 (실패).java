//https://programmers.co.kr/learn/courses/30/lessons/1830#

class Solution {
    public final String INVALID = "invalid";
    
    public int findSpace(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                return i;
            }
        }
        
        return -1;
    }
    
    public int findLowerCase(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                return i;
            }
        }
        
        return -1;
    }
    
    public String solution(String sentence) {
    	if(sentence.length() == 0) return "";
        if(findSpace(sentence) >= 0) {
            System.out.println("공백 발견 - invalid sentence : " + sentence);
            return INVALID;
        }
        
        String answer = "";
        boolean[] alphabetVisited = new boolean[27];
        
        while(true){
            //소문자를 찾는다.
            int left = findLowerCase(sentence);
            int right = left;
            
            //소문자를 찾지 못한 경우 반복문을 종료한다.
            if(left < 0) {
                System.out.println("소문자를 찾지 못한 경우 반복문을 종료한다.");
                answer += sentence;
                sentence = "";
                break;
            }
            
            if(alphabetVisited[sentence.charAt(left) - 'a']){
                //이미 처리했던 소문자가 있으면 invalid
                System.out.println("이미 처리했던 소문자가 있으면 invalid");
                return INVALID;
            }
            else{
                //소문자를 찾은 경우 찾은 소문자를 기록한다.
                System.out.println("소문자를 찾은 경우 찾은 소문자를 기록한다.");
                alphabetVisited[sentence.charAt(left) - 'a'] = true;
            }
            
            
            //자신과 같은것을 발견하면 카운트 늘리고 인덱스를 기록
            int count = 0;
            for(int i=left; i<sentence.length(); i++){
                if(sentence.charAt(i) == sentence.charAt(left)){
                    count++;
                    right = i;
                }
            }
            
            //카운트가 2여야만 규칙 2의 대상이 된다.
            if(count == 2){
                System.out.println("규칙2 : 카운트가 2여야만 규칙 2의 대상이 된다.");
                String leftWord = sentence.substring(0, left);
                String centerWord = sentence.substring(left+1, right);
                String rightWord = sentence.substring(right+1, sentence.length());
                
                if(centerWord.length() == 0) return INVALID;
                
                String leftWord2 = "";
                String centerWord2 = "";
                String rightWord2 = "";
                
                //소문자를 찾는다.
                int left2 = findLowerCase(centerWord);
                int right2 = left2;
                
                //소문자를 찾은 경우 규칙1 처리
                if(left2 >= 0) {
                    System.out.println("규칙2-1 : 소문자를 찾은 경우 규칙1 처리");
                    //소문자를 찾은 경우 찾은 소문자를 기록한다.
                    alphabetVisited[centerWord.charAt(left2) - 'a'] = true;
                    
                    //다른 소문자가 나오면 invalid
                    for(int i=left2; i<centerWord.length(); i+=2){
                        if(centerWord.charAt(i) != centerWord.charAt(left2)) {
                            System.out.println("규칙2-1 : 다른 소문자가 나오면 invalid");
                            return INVALID;
                        }
                        right2 = i;
                    }
                    
                    //소문자가 문자열 끝에 있으면 invalid
                    if(left2 == 0 || right2 == centerWord.length()-1) {
                        System.out.println("규칙2-1 : 소문자가 문자열 끝에 있으면 invalid");
                        return INVALID;
                    }
                    
                    leftWord2 = centerWord.substring(0, left2-1);
                    centerWord2 = "";
                    for(int i=left2-1; i<=right2+1 && i<centerWord.length(); i+=2){
                        centerWord2 += centerWord.substring(i, i+1);
                    }
                    
                    if(right2+2 < centerWord.length())
                        rightWord2 = centerWord.substring(right2+2, centerWord.length());
                    
                    centerWord = "";
                    if(leftWord2.length() > 0) centerWord += leftWord2 + " ";
                    if(centerWord2.length() > 0) centerWord += centerWord2;
                    System.out.println("규칙2-1 : leftWord2 : " + leftWord2 + " centerWord2 : " + centerWord2 + " rightWord2 : " + rightWord2);
                    //if(rightWord2.length() > 0) centerWord += rightWord2 + " ";
                }
                
                if(leftWord.length() > 0) answer += leftWord + " ";
                if(centerWord.length() > 0) answer += centerWord + " ";
                //if(rightWord.length() > 0) answer += rightWord + " ";
                
                sentence = rightWord2 + rightWord;
                System.out.println("규칙2 : answer : " + answer + " sentence : " + sentence);
                continue;
            }
            
            //규칙1 처리
            if(count > 0) {
                System.out.println("규칙1 : count : " + count);

                //소문자가 문자열 끝에 있으면 invalid
                if(left == 0 || right == sentence.length()-1) {
                    System.out.println("규칙1 : 소문자가 문자열 끝에 있으면 invalid");
                    return INVALID;
                }

                String leftWord = sentence.substring(0, left-1);
                String centerWord = "";
                String rightWord = "";
                
                for(int i=left-1; i<=right+1 && i<sentence.length(); i+=2){
                    centerWord += sentence.substring(i, i+1);
                }

                if(right+2 < sentence.length())
                    rightWord = sentence.substring(right+2, sentence.length());

                if(leftWord.length() > 0) answer += leftWord + " ";
                if(centerWord.length() > 0) answer += centerWord + " ";
                //if(rightWord.length() > 0) answer += rightWord + " ";
                
                sentence = rightWord;
                System.out.println("규칙1 : answer : " + answer + " sentence : " + sentence);
                continue;
            }
            
            //문자열이 어느 규칙에도 해당하지 않으면 반복문을 종료한다.
            break;
        }
        
        if(findLowerCase(answer) >= 0) {
            System.out.println("결과에서 소문자 발견 - invalid answer : " + answer);
            return INVALID;
        }
        if(sentence.length() > 0) {
            System.out.println("처리 못 한 문자열이 남아있음 - invalid sentence : " + sentence);
            return INVALID;
        }
        if(answer.length() > 0)
            if(answer.charAt(answer.length()-1) == ' ') 
                return answer.substring(0, answer.length()-1);
        return answer;
    }
}