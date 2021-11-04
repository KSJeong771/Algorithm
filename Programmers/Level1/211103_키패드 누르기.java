//https://programmers.co.kr/learn/courses/30/lessons/67256

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int posLeft = 10;
        int posRight = 11;
        
        for(int i=0; i<numbers.length; i++){
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer = answer + "L";
                posLeft = numbers[i];
            }
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer = answer + "R";
                posRight = numbers[i];
            }
            else {
                int distLeft = GetDistance(posLeft, numbers[i]);
                int distRight = GetDistance(posRight, numbers[i]);
                if (distLeft < distRight){
                    answer = answer + "L";
                    posLeft = numbers[i];
                }
                else if (distLeft > distRight){
                    answer = answer + "R";
                    posRight = numbers[i];
                }
                else {
                    if (hand.equals("left")){
                        answer = answer + "L";
                        posLeft = numbers[i];
                    }
                    else if (hand.equals("right")){
                        answer = answer + "R";
                        posRight = numbers[i];
                    }
                    else{
                        System.out.print("error : " + hand);
                    }
                }
                System.out.println("i : " + i + ", numbers[i] : " + numbers[i]
                                   + ", posLeft : " + posLeft + ", posRight : " + posRight
                                   + ", distLeft : " + distLeft + ", distRight : " + distRight
                                   + ", answer : " + answer);
            }
        }
        
        return answer;
    }
    
    
    public int GetDistance(int from, int to){
        int[][] numpad = {{1,2,3},{4,5,6},{7,8,9},{10,0,11}};
        Point posFrom = new Point(4, 4);
        Point posTo = new Point(4, 4);
        
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                if (from == numpad[i][j]){
                    posFrom.x = i;
                    posFrom.y = j;
                }
                if (to == numpad[i][j]){
                    posTo.x = i;
                    posTo.y = j;
                }
            }
        }
        
        int distX = posFrom.x - posTo.x;
        if (distX < 0){
            distX *= -1;
        }
        int distY = posFrom.y - posTo.y;
        if (distY < 0){
            distY *= -1;
        }
        
        return distX + distY;
    }
    
    public class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}