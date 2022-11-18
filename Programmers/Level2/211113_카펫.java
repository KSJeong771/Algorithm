//https://programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
    public int[] solution(int brown, int yellow) {
        // brown + yellow = 사각형의 넓이
        int rectSize = brown + yellow;
        
        int sqrt = (int)Math.sqrt(rectSize);
        for (int height=sqrt; height>=1; height--) {
            if (rectSize % height != 0) {
                continue;
            }
            
            // 넓이를 나누는 것에 성공한다면 가로, 세로 길이를 찾은 것이다.
            int width = rectSize / height;
            
            // 찾은 사각형이 brown과 yellow의 조건을 만족시키는지 검사해야한다.
            if ((width + height) * 2 - 4 == brown) {
                return new int[] {width, height};
            }
        }
        
        throw new RuntimeException("fail");
    }
}