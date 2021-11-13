//https://programmers.co.kr/learn/courses/30/lessons/68645

class Solution {
    public int[] solution(int n) {
        //삼각형의 마지막 숫자는 n + n-1 + n-2 + ... 1
        //1부터 n까지 합 공식을 사용
        int totalCount;
        if(n%2 == 0)    
            totalCount = (n+1)*(n/2);
        else
            totalCount = (n+1)*(n/2) + (n/2)+1;
        
        int[][] triangleArr = new int[n][n];
        int x = 0;
        int y = 0;
        
        //방향이 2개이면 boolean을 쓰겠지만
        //방향이 3개이므로 3으로 나눈 나머지 값을 통해 현재 방향을 기록한다
        int direction = 1;
        //현재 방향에서 삼각형을 그릴 횟수
        int directionCount = n;
        
        //현재 숫자
        int currentNumber = 1;
        while(currentNumber <= totalCount){
            //배열에 삼각형 그린 뒤 숫자 증가
            triangleArr[y][x] = currentNumber++;
            
            //방향 바뀔 때 동작
            if(--directionCount == 0){
                directionCount = n - direction;
                direction++;
            }
            
            //현재 방향에 따라 좌표 변화를 다르게
            switch(direction % 3){
                case 1:
                    y++;
                    break;
                case 2:
                    x++;
                    break;
                case 0:
                    y--;
                    x--;
                    break;
            }
        }
        
        //2차원 배열 삼각형을 출력에 맞게 변환
        int[] answer = new int[totalCount];
        int index = 0;
        
        for(int i=0; i<triangleArr.length; i++){
            for(int j=0; j<triangleArr[0].length; j++){
                if(triangleArr[i][j] != 0)
                    answer[index++] = triangleArr[i][j];
            }
        }
        
        return answer;
    }
}