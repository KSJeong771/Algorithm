//https://programmers.co.kr/learn/courses/30/lessons/62048

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        
        //가독성을 위해 추가 (생략 가능)
        int width = 1;
        
        //정수 높이를 구하여 적분
        for(int i=1; i<=w; i++){
            answer += maxHeight(w, h, i) * width;
        }
        
        return answer*2;
    }
    
    //x좌표 정수 지점에서 구할 수 있는
    //가장 큰 정수 y좌표 구하기
    public long maxHeight(int width, int height, int xPos){
        //(0, w), (h, 0)을 지나는 직선의 방정식 사용
        //테스트케이스 6번 오차 줄이기 위해 곱셈을 먼저 하였음
        double yPos =  -(double)height * (double)xPos / (double)width
                       + (double)height * (double)width / (double)width;
        
        //버림 연산
        long floorY = (long)Math.floor(yPos);
        return floorY;
    }
}