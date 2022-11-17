//https://programmers.co.kr/learn/courses/30/lessons/12911#

class Solution {
    public int solution(int n) {
        int countOne = Integer.bitCount(n);
        
        int nextNumber = n;
        int nextCountOne;
        do {
            nextCountOne = Integer.bitCount(++nextNumber);
        }
        while (countOne != nextCountOne);
        
        return nextNumber;
    }
}