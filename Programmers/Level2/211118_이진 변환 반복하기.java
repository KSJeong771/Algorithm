//https://programmers.co.kr/learn/courses/30/lessons/70129

class Solution {
    public int[] solution(String s) {
        int lostZero = 0;
        int conversionCount = 0;
        
        while (!s.equals("1")) {
            int lengthBefore = s.length();
            s = s.replace("0", "");
            
            int lengthAfter = s.length();
            s = Integer.toBinaryString(lengthAfter);
            
            lostZero += (lengthBefore - lengthAfter);
            conversionCount++;
        }
        
        return new int[] {conversionCount, lostZero};
    }
}