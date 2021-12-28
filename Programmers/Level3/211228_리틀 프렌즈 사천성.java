//https://programmers.co.kr/learn/courses/30/lessons/1836#

import java.util.*;

class Solution {
    
    public String solution(int boardHeight, int boardWidth, String[] stringBoard) {
        //처리하기 번거로운 String 배열 대신 char 배열을 사용한다.
        char[][] board = stringBoardToCharBoard(boardHeight, boardWidth, stringBoard);
        
        //알파벳 별 모든 좌표쌍을 미리 저장해둔다.
        ArrayList<Point>[] tilePosition = getAllTilePosition(boardHeight, boardWidth, board);
        
        //알파벳 갯수와 정답 문자열의 길이가 일치하지 않으면 impossible
        int alphabetCount = 0;
        for(var pos : tilePosition){
            if(pos.size() > 0){
                alphabetCount++;
            }
        }
        
        String answer = "";
        
        //제거된 타일이 아무것도 없어질 때 까지
        boolean tileRemoved = true;
        while(tileRemoved){
            tileRemoved = false;
            
            //알파벳 순으로 탐색
            for(int alphabetIndex=0; alphabetIndex<27; alphabetIndex++){
                if(tilePosition[alphabetIndex].size() == 0) continue;
                
                //좌표쌍 저장 함수의 동작 순서에 의해
                //시작점은 항상 끝점보다 높거나 같은 행에 존재한다.
                Point from = tilePosition[alphabetIndex].get(0);
                Point to = tilePosition[alphabetIndex].get(1);
                
                //점 두개를 이용해 사각형을 만든다.
                Rectangle rect = new Rectangle(from, to);
                
                //두 점으로 구성된 사각형이 온전하다고 가정하고 모든 변을 탐색한다.
                boolean upSide = true;
                boolean downSide = true;
                boolean leftSide = true;
                boolean rightSide = true;
                
                //직선의 시작점부터 너비 또는 높이만큼 장애물이 있는지 확인한다.
                Point lineStart;
                char dot;
                
                //통과 가능한 물체들
                final char EMPTY = '.';
                final char SELF = (char)(alphabetIndex + 'A');
                
                //윗변
                lineStart= rect.topLeft;
                for(int lineIndex=0; lineIndex<=rect.width; lineIndex++){
                    dot = board[lineStart.r][lineStart.c + lineIndex];
                    if(dot == EMPTY) continue;
                    if(dot == SELF) continue;
                    
                    upSide = false;
                    break;
                }
                
                //아랫변
                lineStart= rect.bottomLeft;
                for(int lineIndex=0; lineIndex<=rect.width; lineIndex++){
                    dot = board[lineStart.r][lineStart.c + lineIndex];
                    if(dot == EMPTY) continue;
                    if(dot == SELF) continue;
                    
                    downSide = false;
                    break;
                }
                
                //좌측변
                lineStart= rect.topLeft;
                for(int lineIndex=0; lineIndex<=rect.height; lineIndex++){
                    dot = board[lineStart.r + lineIndex][lineStart.c];
                    if(dot == EMPTY) continue;
                    if(dot == SELF) continue;
                    
                    leftSide = false;
                    break;
                }
                
                //우측변
                lineStart = rect.topRight;
                for(int lineIndex=0; lineIndex<=rect.height; lineIndex++){
                    dot = board[lineStart.r + lineIndex][lineStart.c];
                    if(dot == EMPTY) continue;
                    if(dot == SELF) continue;
                    
                    rightSide = false;
                    break;
                }
                
                boolean successToRemoveTile = false;
                if(from.c <= to.c){
                    //시작점이 끝점보다 왼쪽에 있는 경우 ㄴ, ㄱ모양 중 하나만 이어져도 타일을 지울 수 있다.
                    //너비 또는 높이가 없는 부분은 장애물도 없기에 지울 수 있는 것으로 취급한다.
                    successToRemoveTile = (leftSide & downSide) | (upSide & rightSide);
                }
                else {
                    //시작점이 끝점보다 오른쪽에 있는 경우 『, 』모양 중 하나만 이어져도 타일을 지울 수 있다.
                    successToRemoveTile = (upSide & leftSide) | (downSide & rightSide);
                }
                
                //타일 지우기 성공
                if(successToRemoveTile){
                    //지운 알파벳을 정답에 추가
                    answer += (char)(alphabetIndex + 'A');
                    
                    //게임판과 좌표쌍에서 타일 지우기
                    board[from.r][from.c] = '.';
                    board[to.r][to.c] = '.';
                    tilePosition[alphabetIndex] = new ArrayList<Point>();
                    
                    //타일을 지웠음을 기록
                    tileRemoved = true;
                    
                    //알파벳 순 정답을 만들기 위해 현재 단계에서 다음 알파벳으로 넘어가지 않고 처음부터 재탐색한다.
                    break;
                }
            }
        }        
        
        //알파벳 갯수와 정답 문자열의 길이가 일치하지 않으면 impossible
        return (answer.length() != alphabetCount) ? "IMPOSSIBLE" : answer;
    }
    
    public class Point{
        int r;
        int c;
        
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        @Override
        public String toString(){
            return "(" + r + "," + c + ")";
        }
    }
    
    public class Rectangle{
        Point topLeft;
        Point topRight;
        Point bottomLeft;
        Point bottomRight;
        int width;
        int height;
        
        public Rectangle(Point from, Point to){
            this.width = Math.abs(from.c - to.c);
            this.height = Math.abs(from.r - to.r);

            int minR = Math.min(from.r, to.r);
            int minC = Math.min(from.c, to.c);
            
            this.topLeft = new Point(minR, minC);
            this.topRight = new Point(minR, minC + this.width);
            this.bottomLeft = new Point(minR + this.height, minC);
            this.bottomRight = new Point(minR + this.height, minC + this.width);
        }
        
        @Override
        public String toString(){
            return "rect : " + topLeft + topRight + bottomLeft + bottomRight;
        }
    }
    
    //알파벳 별 모든 좌표쌍을 미리 저장해둔다.
    public ArrayList<Point>[] getAllTilePosition(int boardHeight, int boardWidth, char[][] board){
        ArrayList<Point>[] tilePosition = new ArrayList[27];
        
        for(int i=0; i<27; i++){
            tilePosition[i] = new ArrayList();
        }
        
        for(int i=0; i<boardHeight; i++){
            for(int j=0; j<boardWidth; j++){
                char ch = board[i][j];
                
                if(ch >= 'A' && ch <= 'Z'){
                    tilePosition[ch-'A'].add(new Point(i, j));
                }
            }
        }
        
        //printTilePosition(tilePosition);
        
        return tilePosition;
    }
    
    public void printTilePosition(ArrayList<Point>[] tilePosition){
        for(int i=0; i<27; i++){
            if(tilePosition[i].size() == 0) continue;
            
            char tile = (char)(i + 'A');
            Point from = tilePosition[i].get(0);
            Point to = tilePosition[i].get(1);
            
            System.out.print("tile : " + tile);
            System.out.print(", from : " + from);
            System.out.print(", to : " + to);
            System.out.print("\n");
        }
    }
    
    public char[][] stringBoardToCharBoard(int boardHeight, int boardWidth, String[] board){
        char[][] charBoard = new char[boardHeight][boardWidth];
        
        for(int i=0; i<boardHeight; i++){
            charBoard[i] = board[i].toCharArray();
        }
        
        return charBoard;
    }
}




//정답 코드 리팩토링 전 백업
// import java.util.*;

// class Solution {
    
//     public String solution(int boardHeight, int boardWidth, String[] stringBoard) {
//         //처리하기 번거로운 string 배열 대신 char 배열을 사용한다.
//         char[][] board = stringBoardToCharBoard(boardHeight, boardWidth, stringBoard);
        
//         //알파벳 별 모든 좌표쌍을 미리 저장해둔다.
//         ArrayList<Point>[] tilePosition = initTilePosition(boardHeight, boardWidth, board);
        
//         //알파벳 갯수와 정답 문자열의 길이가 일치하지 않으면 impossible
//         int alphabetCount = 0;
//         for(var pos : tilePosition){
//             if(pos.size() > 0){
//                 alphabetCount++;
//             }
//         }
        
//         String answer = "";
        
//         //제거된 타일이 아무것도 없어질 때 까지
//         boolean tileRemoved = true;
//         while(tileRemoved){
//             tileRemoved = false;
            
//             for(int alphabetIndex=0; alphabetIndex<27; alphabetIndex++){
//                 if(tilePosition[alphabetIndex].size() == 0) continue;
                
//                 char tile = (char)(alphabetIndex + 'A');
//                 //좌표쌍 저장 함수의 동작 순서에 의해 from의 r좌표 <= to의 r좌표
//                 Point from = tilePosition[alphabetIndex].get(0);
//                 Point to = tilePosition[alphabetIndex].get(1);
                
//                 //line to rect
//                 // System.out.println("line to rect tile : " + tile);
//                 Rectangle rect = new Rectangle(from, to);
//                 Point start;
//                 Point end;
//                 boolean fail1 = false;
//                 boolean fail2 = false;
                
//                 if(from.c <= to.c){
//                     //check topLeft-topRight-bottomRight
//                     // System.out.println("check1 topLeft-topRight, topRight-bottomRight");
//                     start = rect.topLeft;
//                     for(int i=0; i<=rect.width; i++){
//                         if(board[start.r][start.c + i] != '.'
//                            && board[start.r][start.c + i] != tile){
                            
//                             // System.out.println("board[start.r][start.c + i] : " + board[start.r][start.c + i]);
//                             fail1 = true;
//                         }
//                     }
                    
//                     start = rect.topRight;
//                     for(int i=0; i<=rect.height; i++){
//                         if(board[start.r + i][start.c] != '.'
//                            && board[start.r + i][start.c] != tile){
//                             // System.out.println("board[start.r + i][start.c] : " + board[start.r + i][start.c]);
//                             fail1 = true;
//                         }
//                     }
                    
//                     //check topLeft-bottomLeft-bottomRight
//                     // System.out.println("check1 topLeft-bottomLeft-bottomRight");
//                     start = rect.topLeft;
//                     for(int i=0; i<=rect.height; i++){
//                         if(board[start.r + i][start.c] != '.'
//                            && board[start.r + i][start.c] != tile){
//                             // System.out.println("board[start.r + i][start.c] : " + board[start.r + i][start.c]);
//                             fail2 = true;
//                         }
//                     }
                    
//                     start = rect.bottomLeft;
//                     for(int i=0; i<=rect.width; i++){
//                         if(board[start.r][start.c + i] != '.'
//                            && board[start.r][start.c + i] != tile){
//                             // System.out.println("board[start.r][start.c + i] : " + board[start.r][start.c + i]);
//                             fail2 = true;
//                         }
//                     }
//                 }
//                 else if(from.c > to.c){
//                     //check topRight-topLeft-bottomLeft
//                     // System.out.println("check2 topRight-topLeft-bottomLeft");
//                     start = rect.topLeft;
//                     for(int i=0; i<=rect.width; i++){
//                         if(board[start.r][start.c + i] != '.'
//                            && board[start.r][start.c + i] != tile){
//                             // System.out.println("board[start.r][start.c + i] : " + board[start.r][start.c + i]);
//                             fail1 = true;
//                         }
//                     }
//                     start = rect.topLeft;
//                     for(int i=0; i<=rect.height; i++){
//                         if(board[start.r + i][start.c] != '.'
//                            && board[start.r + i][start.c] != tile){
//                             // System.out.println("board[start.r + i][start.c] : " + board[start.r + i][start.c]);
//                             fail1 = true;
//                         }
//                     }
                    
//                     //check topRight-bottomRight-bottomLeft
//                     // System.out.println("check2 topRight-bottomRight-bottomLeft");
//                     start = rect.topRight;
//                     for(int i=0; i<=rect.height; i++){
//                         if(board[start.r + i][start.c] != '.'
//                            && board[start.r + i][start.c] != tile){
//                             // System.out.println("board[start.r + i][start.c] : " + board[start.r + i][start.c]);
//                             fail2 = true;
//                         }
//                     }
                    
//                     start = rect.bottomLeft;
//                     for(int i=0; i<=rect.width; i++){
//                         if(board[start.r][start.c + i] != '.'
//                            && board[start.r][start.c + i] != tile){
//                             // System.out.println("board[start.r][start.c + i] : " + board[start.r][start.c + i]);
//                             fail2 = true;
//                         }
//                     }
//                 }
                
//                 if(!fail1 || !fail2){
//                     // System.out.println("success");
//                     tilePosition[alphabetIndex] = new ArrayList<Point>();
//                     tileRemoved = true;
//                     answer += (char)(alphabetIndex + 'A');
//                     board[from.r][from.c] = '.';
//                     board[to.r][to.c] = '.';
//                     break;
//                 }
//             }
//         }        
        
//         return (answer.length() != alphabetCount) ? "IMPOSSIBLE" : answer;
//     }
    
//     public class Point{
//         int r;
//         int c;
        
//         public Point(int r, int c){
//             this.r = r;
//             this.c = c;
//         }
        
//         @Override
//         public String toString(){
//             return "(" + r + "," + c + ")";
//         }
//     }
    
//     public class Rectangle{
//         Point topLeft;
//         Point topRight;
//         Point bottomLeft;
//         Point bottomRight;
//         int width;
//         int height;
        
//         public Rectangle(Point from, Point to){
//             this.width = Math.abs(from.c - to.c);
//             this.height = Math.abs(from.r - to.r);

//             int minR = Math.min(from.r, to.r);
//             int minC = Math.min(from.c, to.c);
            
//             this.topLeft = new Point(minR, minC);
//             this.topRight = new Point(minR, minC + this.width);
//             this.bottomLeft = new Point(minR + this.height, minC);
//             this.bottomRight = new Point(minR + this.height, minC + this.width);
//         }
        
//         @Override
//         public String toString(){
//             return "rect : " + topLeft + topRight + bottomLeft + bottomRight;
//         }
//     }
    
//     //알파벳 별 모든 좌표쌍을 미리 저장해둔다.
//     public ArrayList<Point>[] initTilePosition(int boardHeight, int boardWidth, char[][] board){
//         ArrayList<Point>[] tilePosition = new ArrayList[27];
        
//         for(int i=0; i<27; i++){
//             tilePosition[i] = new ArrayList();
//         }
        
//         for(int i=0; i<boardHeight; i++){
//             for(int j=0; j<boardWidth; j++){
//                 char ch = board[i][j];
                
//                 if(ch >= 'A' && ch <= 'Z'){
//                     tilePosition[ch-'A'].add(new Point(i, j));
//                 }
//             }
//         }
        
//         //printTilePosition(tilePosition);
        
//         return tilePosition;
//     }
    
//     public void printTilePosition(ArrayList<Point>[] tilePosition){
//         for(int i=0; i<27; i++){
//             if(tilePosition[i].size() == 0) continue;
            
//             char tile = (char)(i + 'A');
//             Point from = tilePosition[i].get(0);
//             Point to = tilePosition[i].get(1);
            
//             System.out.print("tile : " + tile);
//             System.out.print(", from : " + from);
//             System.out.print(", to : " + to);
//             System.out.print("\n");
//         }
//     }
    
//     public char[][] stringBoardToCharBoard(int boardHeight, int boardWidth, String[] board){
//         char[][] charBoard = new char[boardHeight][boardWidth];
        
//         for(int i=0; i<boardHeight; i++){
//             charBoard[i] = board[i].toCharArray();
//         }
        
//         return charBoard;
//     }
// }